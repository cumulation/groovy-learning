package com.monical.groovy.learning.groovyInAction

/**
 * @author monical* @date 2020-05-20 15:40:50
 */
// How to create new Date in Groovy at specific date and time
// https://stackoverflow.com/questions/22848000/how-to-create-new-date-in-groovy-at-specific-date-and-time
// takes the date encoded as milliseconds since midnight, January 1, 1970 UTC
def mydate1 = new Date(System.currentTimeMillis())

// create from an existing Calendar object
def mydate2 = new GregorianCalendar(2014, Calendar.APRIL, 3, 1, 23, 45).time

// uses the format strings from Java's SimpleDateFormat

try {
    def mydate3 = Date.parse("yyyy-MM-dd hh:mm:ss", "2014-04-03 1:23:45")
    println mydate3
} catch (MissingMethodException e) {
    println 'occurs here'
}

// uses a format equivalent to EEE MMM dd HH:mm:ss zzz yyyy
def mydate4 = Date.parseToStringDate("Thu Apr 03 01:23:45 UTC 2014")

def mydate5 = new Date().copyWith(
        year: 2014,
        month: Calendar.APRIL,
        dayOfMonth: 3,
        hourOfDay: 1,
        minute: 23,
        second: 45)

