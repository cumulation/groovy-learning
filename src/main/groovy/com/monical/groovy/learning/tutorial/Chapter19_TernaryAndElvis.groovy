package com.monical.groovy.learning.tutorial

/**
 * @author monical* @date 2020-05-22 14:05:40
 */
// long form
String sayHello_0(String name) {
    "Hello, ${name ? name : 'stranger'}."
}
// elvis
String sayHello_1(String name) {
    "Hello, ${name ?: 'stranger'}."
}
//Usage (with condition) in assignment
def results = []
(1..4).each {
    def what = (it % 2) ? 'odd' : 'even'
    results << what
}
assert results == ['odd', 'even', 'odd', 'even']