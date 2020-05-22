package com.monical.groovy.learning.groovyInAction

/**
 * @author monical* @date 2020-04-14 10:20:36
 */
println "Outter thread: " + Thread.currentThread().getName()
Thread.start {
    println "Inner thread: " + Thread.currentThread().getName()
    "How are you?".each {
        print it
    }
}
println "Fine, thank you."

//groovy -e "println '上海市长宁区天山西路789号中山国际广场B栋8楼上海市长宁区天山西路789号中山国际广场B栋8楼上海市长宁区天山西路789号中山国际广场B栋8楼'.length()"
def twister = 'she sells sea shells by the sea shore'
// contains word
println 'twister =~ /shore/ result :' + (twister =~ 'shore1').count
assert twister.contains('shore')
assert twister =~ 'shore'
assert twister =~ /shore/
println """
twister.contains('shore') is ${twister.contains('shore')}
twister =~ 'shore' is ${twister =~ 'shore'}
twister =~ /shore/ is ${twister =~ /shore/}
"""
// contains sea twice
assert (twister =~ 'sea').size() == 2
assert (twister =~ /sea/).count == 2
println 'grep result:' + twister.split(/ /).grep(~/sea/).size()

// words start with 'sh',\b = word boundary
def s = (twister =~ /sh[a-z]*\b/).collect().join(' ')
assert s == 'she shells shore'