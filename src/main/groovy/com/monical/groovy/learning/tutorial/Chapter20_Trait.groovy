package com.monical.groovy.learning.tutorial

/**
 * @author monical* @date 2020-05-22 13:59:54
 */

// A trait is a reusable set of methods and fields that can be added to one or more classes.
// 和jdk8 default 类似，区别在于trait 声明的方法总是会被执行
trait BarkingAbility {
    String bark() { "I'm barking!!" }
}
// They can be used like normal interfaces, using implements keyword:
class Dog implements BarkingAbility {}

def d = new Dog()
assert d.bark() == "I'm barking!!"
//Also they can be used to implement multiple inheritance (avoiding diamond issue).
// Dogs can scratch his head, so:
trait ScratchingAbility {
    String scratch() { "I'm scratching my head!!" }
}

class A_Dog implements BarkingAbility, ScratchingAbility {}

def d1 = new A_Dog()
assert d1.bark() == "I'm barking!!"
assert d1.scratch() == "I'm scratching my head!!"
// Multiple inheritance problem
/*Class can implement multiple traits. In case if one trait defines method with the same signature
like another trait, there is a multiple inheritance problem. In that case the method from last
declared trait is used:*/

trait Foo {
    def hello() { 'Foo' }
}

trait Bar {
    def hello() { 'Bar' }
}

class FooBar implements Foo, Bar {}

assert new FooBar().hello() == 'Bar'