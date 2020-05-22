package com.monical.groovy.learning.groovyInAction

/**
 * @author monical
 * @date 2020-04-12 08:55:46
 */
class ClassWithTypedAndUntypeFieldsAndProperties {

    public fieldWithModifier
    String typedField
    def untypedField
    protected field1, field2, field3
    private assignedField = new Date()

    static classField
    public static final String CONSTA = 'a', constb = 'b'

    def someMethod() {
        def localUntypeMethodVar = 1
        int localTypedMethodVar = 1
        def localVarWithoutAssignment, andAnotherOne
    }
}

def localVal = 1
boundvar = 1

def someMethod() {
    def localMethodVar = 1
    boundvar2 = 1
    println boundvar2
}

someMethod()

// Variable declaration examples
final String PI = '3.14'
assert PI.class.name == 'java.lang.String'
assert PI.size() == 4

/**
 * shouldFail with classCastException
 */
//GroovyAssert.shouldFail(ClassCastException) { Float areaOfCircleRadiusOne = PI }

// Referencing fields with the subscript operator
class Counter {
    public count = 0
}

def counter = new Counter()
counter.count = 1
assert counter.count == 1
def fieldName = 'count'
counter[fieldName] = 2
assert counter['count'] == 2
// Extending the general field-access mechanism
class PretendFieldCounter {
    public count = 0

    Object get(String name) {
        return 'pretend value'
    }

    void set(String name, Object value) { count++ }
}

def pretender = new PretendFieldCounter()
assert pretender.isNoField == 'pretend value'
assert pretender.count == 0
pretender.isNoFieldEither = 'just to increase counter'
pretender.isNoFieldEither = 'just to increase counter'
assert pretender.count == 2: 'pretender.count is 2'

// Declaring methods
class ClassWithTypedAndUntypedMethods {
    static void main(args) {
        def some = new ClassWithTypedAndUntypedMethods()
        some.publicVoidMethod()
        assert 'hi' == some.publicUntypedMethod()
        assert 'ho' == some.publicTypedMethod()
        combinedMethod()
    }

    void publicVoidMethod() {}

    def publicUntypedMethod() { return 'hi' }

    String publicTypedMethod() { return 'ho' }

    private static final void combinedMethod() {}
}

// Declaring parameter lists
class ClassWithTypedAndUntypedMethodParams {
    static void main(args) {
        assert 'untyped' == method(1)
        assert 'typed' == method('whatever')
        assert 'two args' == method(1, 2)
    }

    static method(arg) {
        return 'untyped'
    }

    static method(String arg) {
        return 'typed'
    }

    static method(arg1, Number arg2) {
        return 'two args'
    }
}
// advanced param uses
class Summer {
    def sumWithDefaults(a, b, c = 0) {
        return a + b + c
    }

    def sumWithDefaultsWay(a, b) {
        a + b
    }

    def sumWithListArgs(List args) {
//        args.inject { sum, i -> sum += i }
        args.inject(0) { sum, i -> sum += i }
    }

    def sumWithList(List args) {
        args.inject(0) { sum, i -> sum += i }
    }

    def sumWithOptionals(a, b, Object[] optionals) {
        return a + b + sumWithList(optionals.toList())
    }

    def sumWithOptionals(a, b) {
        a + b
    }

    def sumNamed(Map args) {
        ['a', 'b', 'c'].each {
            args.get(it, 0)
        }

//        ['a', 'b', 'c'].each { args[it] = args.get(it, 0)}
        return args.a + args.b + args.c
    }

    /*static main(args) {
        def instance = Summer.newInstance()
//        instance.sumWithDefaults(new Summer(), new Summer(), 'string')
        println instance.sumWithDefaults(10, 20)
        println instance.sumWithListArgs([10, 20, 30, 40, 50])
        println instance.sumWithOptionals(10, 11)
    }*/
}

def summer = new Summer()
assert 2 == summer.sumWithDefaults(1, 1)
assert 3 == summer.sumWithDefaults(1, 1, 1)
assert 2 == summer.sumWithList([1, 1])
assert 3 == summer.sumWithList([1, 1, 1])
assert 2 == summer.sumWithOptionals(1, 1)
assert 3 == summer.sumWithOptionals(1, 1, 1)
assert 2 == summer.sumNamed(a: 1, b: 1)
assert 3 == summer.sumNamed(a: 1, b: 1, c: 1)
assert 1 == summer.sumNamed(c: 1)