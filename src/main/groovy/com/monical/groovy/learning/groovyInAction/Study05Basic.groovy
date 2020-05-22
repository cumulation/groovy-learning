package com.monical.groovy.learning.groovyInAction

/**
 * @author monical
 * @date 2020-04-12 18:31:29
 */
class ClassWithProperties {
    def someProperty
    public someField
    private somePrivateField
    String strField
    static int intVal
}

def obj = new ClassWithProperties()
def store = []
obj.properties.each {
    e ->
        store += e.key
        store += e.value
}

println store
println obj.properties.size()

def store1 = []
// list operation
store1 += 123
store1 += 234
store1 << 345
println store1