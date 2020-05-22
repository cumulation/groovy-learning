package com.monical.groovy.learning.groovyInAction

import java.text.SimpleDateFormat

/**
 * @author monical
 * @date 2020-04-12 20:56:34
 */
this
this.class
this.class.methods
this.class.methods.name
this.class.methods.name.grep(~/get.*/).sort()

// Invoice example for GPath
class Invoice {
    List items
    Date date

    def method1(param1) {
        new LineItem(product: ['cao', 123] as Product)
    }
}

class LineItem {
    Product product
    int count

    int total() {
        return product.dollar * count
    }

    def method2(param2) {
        "lineItem:method2//${param2}"
    }
}

class Product {
    String name
    def dollar

    Product(String name, dollar) {
        this.name = name
        this.dollar = dollar
    }

    Product() {

    }
}
// Fills with sample data
//def ulcDate = Date.parse('yyyy-MM-dd', '2015-01-01')
def ulcDate = new SimpleDateFormat('yyyy-MM-dd').parse('2015-01-01')
//def otherDate = Date.parse('yyyy-MM-dd', '2015-02-02')
//def otherDate = LocalDate.parse('2015-02-02', DateTimeFormatter.ofPattern('yyyy-MM-dd'))
def otherDate = new SimpleDateFormat('yyyy-MM-dd').parse('2015-02-02')
def ulc = new Product(dollar: 1499, name: 'ULC')
def ve = new Product(dollar: 499, name: 'Visual Editor')

def invoices = [new Invoice(date: ulcDate, items: [new LineItem(count: 5, product: ulc),
                                                   new LineItem(count: 1, product: ve)]),
                new Invoice(date: otherDate, items: [new LineItem(count: 4, product: ve)])]

def flatten = invoices.items.flatten()
def allItems = invoices.items.flatten()
//println invoices.items*.total.flatten()
// 不能自动提示
def bool = flatten*.total() == [5 * 1499, 1 * 499, 4 * 499]
println "${flatten*.total()} + $bool"
println allItems.grep({ it.total() > 900 }).product.name

def searchDates = invoices.grep { it.items.any { it.product == ulc } }.date*.toString()
assert [ulcDate.toString()] == searchDates

def getList() { return [1, 2, 3] }

def getList2() {
    [3, 4, 5]
}

def sum(a, b, c, d) {
    a * b + c * d
}

def sum(a, b, c) { return a + b + c }
// 解构
assert 6 == sum(*list)
def range = (1..3)
assert [0,1,2,3] == [0,*range]
def map = [a:1,b:2]
assert [a:1, b:2, c:3] == [c:3, *:map]

def invoice = new Invoice()
def var = invoice.method1('hello').method2('groovy')
// Concise syntax with command chains
println var == "${invoice.method1 'hello' method2 'groovy' }"