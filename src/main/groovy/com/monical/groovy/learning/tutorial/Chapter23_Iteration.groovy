package com.monical.groovy.learning.tutorial

/**
 * @author monical* @date 2020-05-22 12:01:05
 */
5.times {
    println "hello world"
}
println '***'
5.step(10, 2, {
    it ->
        println "$it hello world"
})
// 一个参数可以忽略
5.upto(10, {
    it ->
        println "$it upto>>>"
})

def list = [1, 2, 5, 7]
list.each {
    println it
}
list.eachCombination {
    it -> it * 100
}
list.each { val ->
    println val
}
list.eachWithIndex { it, index ->
    println "value " + it + " at index " + index
}
// 矩阵
[[2, 3], [4, 5, 6]].eachCombination { println "矩阵Found $it" }
[2, 3, 4, 5, 6].eachCombination { println "Found $it" } // Found [2, 3, 4, 5, 6]
// 排列
def permutations = []
[1, 2, 3].eachPermutation { permutations << it }
assert permutations == [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]