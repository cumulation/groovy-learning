package com.monical.groovy.learning.tutorial


import org.slf4j.LoggerFactory

import java.sql.Connection
import java.sql.DriverManager

/**
 * @author monical* @date 2020-05-22 18:23:56
 */
// Closure with explicit parameters
def addNumbers = { a, b -> a + b }
addNumbers(-7, 15) // returns 8

def withConnection(String url, String user, String pass, Closure closure) {
    def log = LoggerFactory.getLogger("Chapter4_Closure")
    Connection conn = null
    try {
        conn = DriverManager.getConnection(url, user, pass)
        closure.call(conn)
        conn.commit()
    } catch (Exception e) {
        log.error("DB Action failed", e)
        conn.rollback()
    } finally {
        conn?.close()
    }
}

List<String> list = ['11']
def inject = list.inject('xxx jun') {
    result, item ->
        result + (result && item ? ',' : '') + (item ? "${item.trim()}" : '')
}
println inject

DB_PATH = 'jdbc:mysql://10.72.108.63:5002/myshowfans?characterEncoding=UTF8&socketTimeout=60000&allowMultiQueries=true'
DB_USER = 'myshowfans'
DB_PASS = 'myshowfans'
withConnection(DB_PATH, DB_USER, DB_PASS) { Connection conn ->
    def statement = conn.createStatement()
    def results = statement.executeQuery('SELECT * FROM Fans_WxTpl')
    // ... more processing ...
}