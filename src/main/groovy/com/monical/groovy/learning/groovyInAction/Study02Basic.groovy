package com.monical.groovy.learning.groovyInAction

/**
 * @author monical
 * @date 2020-04-12 00:43:02
 */
//@Grab('commons-lang:commons-lang:2.4')
class Study02Basic {

    public static void main(String[] args) {
        def x = 1
        def y = 2
        assert x + y == 3
        assert x.plus(y) == 3
        assert x instanceof Integer
        assert x instanceof Number
    }

}
