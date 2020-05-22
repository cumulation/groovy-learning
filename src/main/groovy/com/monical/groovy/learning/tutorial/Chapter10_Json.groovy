package com.monical.groovy.learning.tutorial

import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import groovy.transform.ToString

/**
 * @author monical* @date 2020-05-22 17:41:17
 */
// Parse a json string
def jsonSlurper = new JsonSlurper()
def obj = jsonSlurper.parseText('{ "foo": "bar", "baz": [1] }')

assert obj.foo == 'bar'
assert obj.baz == [1]
def content = /
        {
            "content":"{\"pageConf\":{\"bgColor\":\"#fff\"},\"naming\":{\"name\":\"活动页面\"},\"shareConf\":null,\"crumbs\":[{\"type\":\"project\",\"id\":\"2154741\"},{\"type\":\"activity\",\"id\":\"7\"},{\"type\":\"project\",\"id\":\"2154741\"},{\"type\":\"live\",\"id\":3}]}",
            "publishTagFrom":1,
            "uid":"0e56a981087a42758f0d8d37b9971b53",
            "id":147
        }
/
def parse = jsonSlurper.parseText(content)
println parse['content']

// parse a json file
File fl = new File('myTestUsage.json')
// parse(File file) method is available since 2.2.0
obj = jsonSlurper.parse(fl)
// for versions < 2.2.0 it's possible to use
def old = jsonSlurper.parse(fl)

println """
$old
${old?.size}
"""

// Write a json to string
def json = JsonOutput.toJson([foo: 'bar', baz: [1]])
assert json == '{"foo":"bar","baz":[1]}'

// In addition to maps, lists and primitives groovy.json.JsonOutput also supports a POJOs
//serialitzation:

class Tree {
    def name
    def type


    @Override
    public String toString() {
        return "Tree{" +
                "name=" + name +
                ", type=" + type +
                '}';
    }
}
Tree willow = new Tree(name:'Willow',type:'Deciduous')
Tree olive = new Tree(name:'Olive',type:'Evergreen')
assert JsonOutput.toJson(willow) == '{"type":"Deciduous","name":"Willow"}'
assert JsonOutput.toJson([willow,olive]) ==
        '[{"type":"Deciduous","name":"Willow"},{"type":"Evergreen","name":"Olive"}]'

def trees = jsonSlurper.parseText('[{"type":"Deciduous","name":"Willow"}]') as Tree[]
println trees[0]

// Pretty-print a json string
json = JsonOutput.toJson([foo: 'bar', baz: [1]])
assert json == '{"foo":"bar","baz":[1]}'
def pretty = JsonOutput.prettyPrint(json)

assert pretty == '''{
    "foo": "bar",
    "baz": [
        1
    ]
}'''

//println JsonOutput.prettyPrint(JsonOutput.toJson(old))
json = JsonOutput.toJson([foo: 'bar', baz: [1]])
// 绝对path
new File("/tmp/output.json").write(json)