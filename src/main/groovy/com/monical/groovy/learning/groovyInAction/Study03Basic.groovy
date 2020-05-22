package com.monical.groovy.learning.groovyInAction

/**
 * @author monical
 * @date 2020-04-12 08:47:27
 */
class Study03Basic {

    static main(args) {
        println 'public static void main(String[] args) boils down to this in Groovy'
        def mydate3 = Date.parse("yyyy-MM-dd hh:mm:ss", "2014-04-03 1:23:45")
        println mydate3
    }

}



