package com.monical.groovy.learning.tutorial

/**
 * @author monical* @date 2020-05-22 16:56:51
 */
def lst = ['foo', 'bar', 'baz']
def f_value = lst.find { it.startsWith('f') } // 'foo' found
f_value?.length() // returns 3
def null_value = lst.find { it.startsWith('z') } // no element found. Null returned
// equivalent to null_value==null ? null : null_value.length()
println null_value?.length() // no NullPointerException thrown
// no safe operator used
println null_value.length() // NullPointerException thrown

// Concatenation of safe navigation operators
/*class User {
    String name
    int age
}*/
// 跨文件的class
def users = [
        new User(name: "Bob", age: 20),
        new User(name: "Tom", age: 50),
        new User(name: "Bill", age: 45)
]
def null_value1 = users.find { it.age > 100 } // no over-100 found. Null
null_value1?.name?.length() // no NPE thrown
// null ?. name ?. length()
// (null ?. name) ?. length()
// ( null ) ?. length()
// null
null_value1?.name.length() // NPE thrown
// null ?. name . length()
// (null ?. name) . length()
// ( null ) . length() ===> NullPointerException