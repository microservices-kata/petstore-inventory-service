package com.thoughtworks.petstore.inventory.repository

import com.thoughtworks.petstore.inventory.entity.Shop
import org.springframework.data.repository.CrudRepository

interface ShopRepository extends CrudRepository<Shop, Long> {
    List<Shop> findById(Long id)
}