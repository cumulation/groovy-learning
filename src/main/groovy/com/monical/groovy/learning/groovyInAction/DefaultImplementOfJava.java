package com.monical.groovy.learning.groovyInAction;

import groovy.transform.ToString;

/**
 * @author monical
 * @date 2020-04-26 20:16:56
 */

@ToString
public interface DefaultImplementOfJava {

    default void something() {
        System.out.println("A1 default something");
    }
}

@ToString
class Pojo {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}

class PojoUseGroovyTransform {

    public static void main(String[] args) {
        Pojo pojo = new Pojo();
        pojo.setName("hello groovy");
        // not work
        System.out.println(pojo);
    }
}

