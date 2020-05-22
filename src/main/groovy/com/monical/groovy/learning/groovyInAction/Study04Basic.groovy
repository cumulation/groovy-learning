package com.monical.groovy.learning.groovyInAction

/**
 * @author monical
 * @date 2020-04-12 11:51:13
 */
//  Calling constructors with positional parameters
class VendorWithCtor {
    def prop1, prop2


    VendorWithCtor(var1, var2) {
        prop1 = var1
        prop2 = var2
    }
}

def first = new VendorWithCtor('hello', 'groovy')
def second = ['hello', 'groovy'] as VendorWithCtor // coercion with as
VendorWithCtor third = ['hello', 'groovy'] // Coercion with assignment
//VendorWithCtor faultFourth = ['hello', 'groovy', 123, false]
assert first.prop2 == second.prop2
assert first.prop1 == second.prop1
assert first.prop1 == third.prop1
assert first.prop2 == third.prop2

// Calling constructors with named parameters
class SimpleVendor {
    String name, product
}

def vendor1 = new SimpleVendor()
def vendor2 = new SimpleVendor(name: 'Canoo')
def vendor3 = new SimpleVendor(product: 'ULC')
def vendor4 = new SimpleVendor(name: 'Canoo', product: 'ULC')
def vendor = new SimpleVendor(name: 'Canoo')
assert 'Canoo' == vendor.name

vendor5 = ['hello', 'lily']
