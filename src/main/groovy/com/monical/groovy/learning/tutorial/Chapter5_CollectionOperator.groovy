package com.monical.groovy.learning.tutorial

/**
 * @author monical* @date 2020-05-22 18:12:12
 */

/**
 * **************************** List ********************************
 */
//Iterate over a collection
def lst = ['foo', 'bar', 'baz']
// using implicit argument
lst.each { println it }
// using explicit argument
lst.each { val -> println val }
// both print:
// foo
// bar
// baz

// Iterate with index

def lst1 = ['foo', 'bar', 'baz']
// explicit arguments are required
lst1.eachWithIndex { val, idx -> println "$val in position $idx" }
// prints:
// foo in position 0
// bar in position 1
// baz in position 2

//Filter a list with findAll
def lst2 = [10, 20, 30, 40]
lst2.findAll { it > 25 } // [30, 40]

// Find the first element matching a condition
def lst3 = [10, 20, 30, 40]
lst3.find { it > 25 } // 30. Note: it returns a single value

// Create maps with collectEntries
// From list
def lst4 = ['foo', 'bar', 'baz']
// for each entry return a list containing [key, value]
lst4.collectEntries { [it, it.toUpperCase()] } // [foo: FOO, bar: BAR, baz: BAZ]
// another option, return a map containing the single entry
lst4.collectEntries { [(it): it.toUpperCase()] } // [foo: FOO, bar: BAR, baz: BAZ]

/**
 * **************************** Map ********************************
 */
def map = [foo: 'FOO', bar: 'BAR', baz: 'BAZ']
// using implicit argument
map.each { println "key: ${it.key}, value: ${it.value}" }
// using explicit arguments
map.each { k, v -> println "key: $k, value: $v" }
// both print:
// key: foo, value: FOO
// key: bar, value: BAR
// key: baz, value: BAZ

//Create a new list using collect
def lst5 = ['foo', 'bar', 'baz']
lst5.collect { it } // ['foo', 'bar', 'baz']
lst5.collect { it.toUpperCase() } // ['FOO', 'BAR', 'BAZ']

def entries = lst5.collectEntries { it -> [it, it.length()] }
println entries instanceof Map

// To collect keys or values from a maps
def map1 = [foo: 'FOO', bar: 'BAR', baz: 'BAZ']
def keys = map1.collect { it.key } // ['foo', 'bar', 'baz']
def vals = map1.collect { it.value } // ['FOO', 'BAR', 'BAZ']

// From Map
def map2 = [foo: 'FOO', bar: 'BAR', baz: 'BAZ']
map2.collectEntries { [it.key * 2, it.value * 2] } // [foofoo: FOOFOO, barbar: BARBAR, bazbaz: BAZBAZ]
// using explicit arguments k and v
map2.collectEntries { k, v -> [k * 2, v * 2] } // [foofoo: FOOFOO, barbar: BARBAR, bazbaz: BAZBAZ]

// Apply transformation to nested collections
def lst6 = ['foo', 'bar', ['inner_foo', 'inner_bar']]
lst6.collectNested { it.toUpperCase() } // [FOO, BAR, [INNER_FOO, INNER_BAR]]

def collect = lst6.collect { it.toUpperCase() }
println collect
def lst7 = ['foo', 'bar', ['inner_foo', 'inner_bar']]
lst7.flatten() // ['foo', 'bar', 'inner_foo', 'inner_bar']
lst7.flatten().collect { it -> it.toUpperCase() }
// Caught: groovy.lang.MissingMethodException: No signature of method: java.util.ArrayList.toUpperCase()

// Remove duplicates
def lst8 = ['foo', 'foo', 'bar', 'baz']
// *modifies* the list removing duplicate items
lst8.unique() // [foo, bar, baz]
// setting to false the "mutate" argument returns a new list, leaving the original intact
lst8.unique(false) // [foo, bar, baz]
// convert the list to a Set, thus removing duplicates
lst8.toSet() // [baz, bar, foo]
// defining a custom equality criteria. For example: to elements are equal if have the same first letter
println lst.unique() { it[0] } // [foo, bar]. 'bar' and 'baz' considered equal

//Build a map from two lists
nrs = [1, 2, 3, 4, 5, 6, 7, 8, 9]
lets = ['a', 'b', 'c', 'd', 'e', 'f']
println GroovyCollections.transpose([nrs, lets])
        .collect { le -> [(le[0]): le[1]] }.collectEntries { it }
//or
println[nrs, lets].transpose().collectEntries { [it[0], it[1]] }
// [1:a, 2:b, 3:c, 4:d, 5:e, 6:f]