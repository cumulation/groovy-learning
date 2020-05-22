package com.monical.groovy.learning.tutorial

/**
 * @author monical* @date 2020-05-22 18:10:42
 */
//
//Syntax
//• closure.curry(parameter)
//• closure.rcurry(parameter)
//• closure.ncurry(index, parameters ...)


def honestlyNoParam = { ->
    "I Don't have it"
}
// The following all throw IllegalArgumentException
honestlyNoParam.curry('whatever')
honestlyNoParam.rcurry('whatever')
honestlyNoParam.ncurry(0, 'whatever')