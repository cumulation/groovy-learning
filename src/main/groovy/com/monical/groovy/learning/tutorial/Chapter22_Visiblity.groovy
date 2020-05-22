package com.monical.groovy.learning.tutorial

/**
 * @author monical* @date 2020-05-22 13:51:34
 */
//Private fields and methods are not private in groovy
class MyClass {
    private String privateField
}
def prvtClss = new MyClass(privateField: 'qwerty')
println prvtClss.privateField

// 唯一的区别是ide会自动提示？