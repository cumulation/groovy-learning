package com.monical.groovy.learning.groovyInAction
/**
 * @author monical* @date 2020-04-21 10:06:45
 */
def clazz = AjaxCodeEnum.metaClass
//println(AjaxCodeEnum.metaPropertyValues.properties)
//println(AjaxCodeEnum.properties)
//同时获取键值
collect = AjaxCodeEnum.collect { [name: it.name(), code: it.code, value: it.desc] }
println collect.class
println 'com.monical.groovy.learning.AjaxCodeEnum'.md5()
println 'com.monical.groovy.learning1.AjaxCodeEnum'.md5()

// md5(ajaxcodeenum) => key
//字符转枚举对象
//def fs = A/*jaxCodeEnum.valueOf(value)
//fs.name
//fs.value*/

//值集合
AjaxCodeEnum.values().collect({ println it.name() + it.code + it.desc })

def packet = Package.getPackage('com.monical.groovy.learning')
println packet.findAll({ println it.class.name })

def clo = { -> getThisObject() }
assert clo() == this

assert { this }() == this
assert { owner }() == this
assert { delegate }() == this

def runnable() {
    def whatIsThisObject = { -> getThisObject() }
    def whatIsThisObject1 = { -> owner }
    assert whatIsThisObject() == this
    assert whatIsThisObject1() == this
    def whatIsThis = { this }
    assert whatIsThis() == this
}

runnable()


class Enclosing {
    void run() {
        def whatIsOwnerMethod = { getOwner() }
        assert whatIsOwnerMethod() == this
        def whatIsOwner = { owner }
        assert whatIsOwner() == this
    }
}

class EnclosedInInnerClass {
    class Inner {
        Closure cl = { owner }
    }

    void run() {
        def inner = new Inner()
        assert inner.cl() == inner
    }
}

class NestedClosures {
    void run() {
        def nestedClosures = {
            def cl = { owner }
            cl()
        }
        assert nestedClosures() == nestedClosures
    }
}


class Person {
    String name
}
class Thing {
    String name
}

def p = new Person(name: 'Norman')
def t = new Thing(name: 'Teapot')



def upperCasedName = { delegate.name.toUpperCase() }

upperCasedName.delegate = p
assert upperCasedName() == 'NORMAN'
println( p.name + t.name)
upperCasedName.delegate = t

//upperCasedName.setDelegate(t)
assert upperCasedName.call(t) == upperCasedName()
assert upperCasedName() == 'TEAPOT'
println( p.name + t.name)



def target = p
def upperCasedNameUsingVar = { target.name.toUpperCase() }
assert upperCasedNameUsingVar() == 'NORMAN'