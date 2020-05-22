package com.monical.groovy.learning.tutorial
/**
 * @author monical* @date 2020-05-22 14:24:05
 */
//String Interpolation
// basic
def str = 'nice'
assert "Groovy is $str" == 'Groovy is nice'

// Dotted Expression
def arg = [phrase: 'interpolated']
assert "This is $arg.phrase" == 'This is interpolated'

//Eager expression
def str1 = 'old'
def interpolated1 = "I am the ${str1} value"
assert interpolated1 == 'I am the old value'
str1 = 'new'
assert interpolated1 == 'I am the old value'

//Lazy expression
// This is different than normal interpolation as the GString
//can potentially have different values, depending on the closure, whenever it is converted into a String.
def str2 = 'old'
def interpolated2 = "I am the ${-> str2} value"
assert interpolated2 == 'I am the old value'
str2 = 'new'
assert interpolated2 == 'I am the new value'

// expression
def str3 = 'dsl'
def interpolated3 = "Groovy ${-> str3.length() + 1} easy ${str3.toUpperCase()}"
assert interpolated3 == 'Groovy 4 easy DSL'
str3 = 'Domain specific language'
assert interpolated3 == 'Groovy 25 easy DSL'