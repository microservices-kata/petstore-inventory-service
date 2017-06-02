package com.thoughtworks.petstore.inventory.repository

import com.thoughtworks.petstore.inventory.entity.Species
import org.springframework.data.repository.CrudRepository

interface SpeciesRepository extends CrudRepository<Species, Long> {
    List<Species> findById(Long id)
}
