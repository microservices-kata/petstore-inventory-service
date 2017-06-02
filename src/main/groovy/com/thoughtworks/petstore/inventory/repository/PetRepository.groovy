package com.thoughtworks.petstore.inventory.repository

import com.thoughtworks.petstore.inventory.entity.Pet
import org.springframework.data.repository.CrudRepository

interface PetRepository extends CrudRepository<Pet, Long> {
    List<Pet> findById(Long id)
}