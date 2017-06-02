package com.thoughtworks.petstore.inventory.repository

import com.thoughtworks.petstore.inventory.entity.Category
import org.springframework.data.repository.CrudRepository

interface CategoryRepository extends CrudRepository<Category, Long> {
    List<Category> findById(Long id)
}
