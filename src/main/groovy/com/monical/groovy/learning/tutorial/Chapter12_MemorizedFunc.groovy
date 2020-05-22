package com.monical.groovy.learning.tutorial

/**
 * @author monical* @date 2020-05-22 17:39:25
 */

// Since Groovy 1.8 a convenient memoize() method is added on closures:
// normal closure
def sum = { int x, int y ->
    println "sum ${x} + ${y}"
    return x + y
}
sum(3, 4)
sum(3, 4)
// prints
// sum 3 + 4
// sum 3 + 4
// memoized closure
def sumMemoize = sum.memoize()
sumMemoize(3, 4)
// the second time the method is not called
// and the result it's take from the previous
// invocation cache
sumMemoize(3, 4)
// prints
// sum 3 + 4