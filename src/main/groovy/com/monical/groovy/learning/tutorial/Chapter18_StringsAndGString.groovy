package com.monical.groovy.learning.tutorial

/**
 * @author monical* @date 2020-05-22 14:09:55
 */
// Strings and GString literals 文字
//  GString supports string interpolation.
// Single quoted string
def str = 'Single quoted string'
assert str instanceof String
//Double quoted string (without interpolation placeholder)
def str1 = "Double quoted string"
assert str1 instanceof String
// Double quoted string (interpolation)
def param = 'string'
def str2 = "Double quoted ${param}"
assert str2 instanceof GString
assert str2 == 'Double quoted string'

//The parameter is by default resolved eagerly, this means this applies:
def param3 = 'string'
def str3 = "Double quoted ${param3}"
param3 = 'another string'
assert str3 == 'Double quoted string'

// In order to load the parameter lazily every time the string is used, this can be done:
def param4 = 'string'
def str4 = "Double quoted ${-> param4}"
assert str4 == 'Double quoted string'
param4 = 'lazy load'
assert str4 == 'Double quoted lazy load'

//Multiline string
def str5 = '''multiline
string'''

def str6 = '''
multiline string1
multiline string2
'''
assert str5 instanceof String

//Multiline string (extra trailing newline)
assert str5.readLines().size() == 2
assert str6.readLines().size() == 3
// Multiline string (without extra trailing newline)
def str7 = '''\
multiline
string'''
assert str7.readLines().size() == 2

// Triple double quoted string
def param8 = 'string'
def str8 = """
multiline
$param8
"""
assert str8 instanceof GString
assert str8.readLines().size() == 3
assert str8 == '''
multiline
string
'''

//Slashy string (no interpolation placeholder)
def str9 = /  1
multiline string
no need to escape slash
\n/
assert str9 instanceof String
assert str9.readLines().size() == 4
assert str9.contains('\\n')
str9.readLines().eachWithIndex { String entry, int i -> println "$i + $entry" }

// Slashy string (interpolation)
def param10 = 'string'
def str10 = /     
multiline $param
no need to escape slash
\n
/
assert str10 instanceof GString
assert str10.readLines().size() == 4
assert str10.contains('\\n')
assert str10.contains('string')
//Dollar slash string
def param11 = 'string'
def str11 = $/
multiline $param
no need to escape slash
\n
$
$$
/$
assert str11 instanceof GString
assert str11.readLines().size() == 6
assert str11.contains('\\n')
assert str11.contains('$')