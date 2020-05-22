package com.monical.groovy.learning.groovyInAction

/**
 * @author monical
 * @date 2020-04-12 00:23:26
 */
class Study01Basic {

    def method1() {
//        assert 'text'* 3 << 'hello' == 'texttexttexthello'
        assert 'text' * 3 << 'hello' == 'texttexttexthello': 'stringBuilder not equals to string'
    }

    public static void main(String[] args) {
        def instance = Study01Basic.newInstance()
//        instance.method1()
        def buffer = 'text' * 3 << 'hello'
        def buffer1 = buffer << 'h' << 'e' << 'l' << 'l' << 'o'
        assert buffer1.toString() == 'texttexttexthellohello'
        def x
//        assert x == 'hey, this is really the content of x'
    }


}
