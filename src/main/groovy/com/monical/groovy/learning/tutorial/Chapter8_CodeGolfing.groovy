package com.monical.groovy.learning.tutorial

@Grapes(
        @Grab(group = 'org.codehaus.gpars', module = 'gpars', version = '0.12')
)
import groovyx.gpars.GParsPool

/**
 * @author monical* @date 2020-05-22 18:03:53
 */
// Spread dot operator(*.)
(1..10)*.multiply(2) // equivalent to (1..10).collect{ it *2 }
d = ["hello", "world"]
d*.size() // d.collect{ it.size() }

GParsPool.withPool { def result = d.collectParallel { processItem(it) } }

def processItem(param) {
    println " currentThread: ${Thread.currentThread().name} --- $param"
}