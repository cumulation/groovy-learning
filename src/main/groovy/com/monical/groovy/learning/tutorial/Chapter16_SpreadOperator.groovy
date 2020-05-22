package com.monical.groovy.learning.tutorial

/**
 * @author monical* @date 2020-05-22 14:29:49
 */

//In most cases, the spread operator *. is identical to calling .collect { it.________ }.
def animals = ['cat', 'dog', 'fish']
assert animals*.length() == animals.collect { it.length() }
println animals*.length().class

// But if the subject is null, they behave a differently:
def animalsNull = null
assert animalsNull*.length() == null
assert animalsNull.collect { it.length() } == []
// Calling a method
assert ['cat', 'dog', 'fish']*.length() == [3, 3, 4]


// Note that when mixing types in the collection if the method not exists on some of the elements, a
//groovy.lang.MissingMethodException could be thrown:


try {
    ['cat', 'dog', 'fish', 3]*.length()
// it throws groovy.lang.MissingMethodException: No signature of method:
    Integer.length()
} catch (Exception e) {
    // MissingMethodException
}

//Accessing a property
class Vector {
    double x
    double y
}

def points = [
        new Vector(x: 10, y: -5),
        new Vector(x: -17.5, y: 3),
        new Vector(x: -3.3, y: -1)
]
assert points*.x == [10, -17.5, -3.3]

assert points.x == [10, -17.5, -3.3]
//If there is a null object on the collection it not throws a NPE, it returns a null instead:
assert ['cat', 'dog', 'fish', null]*.length() == [3, 3, 4, null]

//Using it directly in a null object it's also null-safe:
def nullCollection = null
assert nullCollection*.length() == null