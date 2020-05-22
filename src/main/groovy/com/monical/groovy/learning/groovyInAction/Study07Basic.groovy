package com.monical.groovy.learning.groovyInAction
/**
 * @author monical
 * @date 2020-04-12 21:45:12
 */
println String.metaClass
assert String.metaClass =~ /MetaClassImpl/
String.metaClass.low = { -> delegate.toLowerCase() }
String.metaClass.upper = { delegate.toUpperCase() }
//String.metaClass.upper2 = { owner.toUpperCase() }
//String.metaClass.upper3 = { this.toUpperCase() }
println String.metaClass
assert String.metaClass =~ /ExpandoMetaClass/
assert "DiErK".low() == "dierk"
println 'DiErK'.upper() == 'DIERK'
//println 'DiErK'.upper2() == 'DIERK'
//println 'DiErK'.upper3() == 'DIERK'

def move(string, distance) {
    string.collect { (it as char) + distance as char }.join()
}

String.metaClass {
    shift = -1
    encode { -> move delegate, shift }
    decode { -> move delegate, -shift }
    getCode { -> encode() }
    getOrig { -> decode() }
}
assert "IBM".encode() == "HAL"
assert "HAL".orig == "IBM"
def ibm = "IBM"
ibm.shift = 7
assert ibm.code == "PIT"