package com.monical.groovy.learning.groovyInAction

/**
 * @author monical* @date 2020-04-26 20:11:43
 */
// trait

class A {
    void something() {
        //
        // println 'a something'
    }
}

trait T {
    void something() {
        //
        println 'trait of T something'
    }

}

class B extends A implements T {

}

class C extends A implements T {

}

class D extends A implements T {
// the implementation from the trait is always used if the class declares the trait in its interface list and
// that it doesn’t provide an implementation even if a super class does.
}

//new B().something()
//new C().something()
new D().something()

// SAM coercion 只有一个abstract 方法 时才有效
// refer to http://docs.groovy-lang.org/next/html/documentation/core-traits.html#_sam_type_coercion

trait Greeter {
    abstract def getName()
//    abstract def getNickName()
    String greet() { "Hello $name" }
}

Greeter greeter = { 'Alice' }

void greet(Greeter g) { println g.greet() }

greet { 'Alice' }
greet greeter