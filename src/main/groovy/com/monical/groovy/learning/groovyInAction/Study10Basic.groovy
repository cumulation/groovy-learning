package com.monical.groovy.learning.groovyInAction

/**
 * @author monical* @date 2020-04-23 10:44:17
 */
int function(List args) {

    args.size()
}
int function(int x, int y, int z) {
    x*y+z
}

// spread method arg
def args = [4,5,6]
assert function(*args) == 26
//assert function(args) == 26
println function(args)