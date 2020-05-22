package com.monical.groovy.learning.tutorial

/**
 * @author monical* @date 2020-05-22 13:55:03
 */
// use configSluper instead of property files
config = new ConfigSlurper().parse(new File('myConfig.groovy').toURL())
assert 'Hello World!' == config.message
assert 42 == config.aNumber
assert false == config.aBoolean
assert ["apples", "grapes", "oranges"] == config.aList
println config