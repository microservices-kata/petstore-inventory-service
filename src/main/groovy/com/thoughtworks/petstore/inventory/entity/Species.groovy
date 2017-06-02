package com.thoughtworks.petstore.inventory.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Species implements Serializable {

    @Id
    @GeneratedValue
    Long id

    @Column(nullable = false)
    String name

    @Column(nullable = true)
    String description

}
