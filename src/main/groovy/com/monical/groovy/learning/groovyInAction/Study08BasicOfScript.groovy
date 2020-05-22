package com.monical.groovy.learning.groovyInAction

import groovy.transform.TypeChecked

import java.util.concurrent.ArrayBlockingQueue
import java.util.concurrent.BlockingQueue

/**
 * @author monical
 * @date 2020-04-13 11:39:12
 */
@TypeChecked
class Detective {
    String firstName
    String lastName
}

//def sherlock = new Detective(firstname: 'Sherlock', lastname: 'Holmes')
sherlock = new Detective(lastName: 'Holmes', firstName: 'Sherlock')
assert sherlock.lastName == 'Holmes'
assert -1 << 29 == 7 << 29: "-1 << 29 equals 7 << 29"

@TypeChecked
class Sleuth {
    String firstName
    String lastName

    String getFullName() { "$firstName $lastName" }
}

BlockingQueue queue = new ArrayBlockingQueue(10)
queue.offer(1)
queue.offer(2)
queue.offer(3)
queue.offer(4)

Thread thread = new Thread(new Runnable() {
    @Override
    void run() {
        5.times {
            println Thread.currentThread().name + queue.take()
        }
    }
})
thread.start()
//Thread.sleep(1000)
//thread.interrupt()

/*

def thread1 = {
    for (; ;) {
        println Thread.currentThread().name
    }
} as Thread
thread1.start()*/

Thread.start { 10.times {
    println "${Thread.currentThread().name} index$it"
}}
//def thread2 = new Thread({
//    for (; ;) println "Thread.currentThread().name >> queue.take()"
//})
//thread.start()
//thread1.start()
//thread2.start()
//thread1.interrupt()
