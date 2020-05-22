package com.monical.groovy.learning.groovyInAction

/**
 * @author monical
 * @date 2020-04-12 12:09:17
 */
//Multiple class declarations in one file

class Vendor {
    String name
    public String product
    public Address address = new Address()
}

class Address {
    public String street, town, state
    public int zip
}

def canoo = new Vendor()
canoo.name = 'Canoo Engineering AG'
canoo.product = 'UltraLightClient (ULC)'

canoo.address.street = 'Kirschgartenst. 7'
canoo.address.zip = 4051
canoo.address.town = 'Basel'
canoo.address.state = 'Switzerland'
assert canoo.dump() =~ /ULC/
assert canoo.address.dump() =~ /Basel/


