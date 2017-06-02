package com.thoughtworks.petstore.inventory.controller

import com.thoughtworks.petstore.inventory.entity.Species
import com.thoughtworks.petstore.inventory.repository.SpeciesRepository
import groovy.transform.CompileStatic
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.InvalidDataAccessApiUsageException
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody


@CompileStatic
@Controller
@RequestMapping(value = "/api/species")
class SpeciesController {

    @Autowired
    SpeciesRepository speciesRepository

    @ApiOperation(value = "Get species via id")
    @GetMapping(path = "/{speciesId}")
    @ResponseBody
    Species getSpecies(@ApiParam(value = "Species id") @PathVariable Long speciesId) {
        try {
            return speciesRepository.findById(speciesId).get(0)
        } catch (IndexOutOfBoundsException e) {
            return null
        }
    }

    @ApiOperation(value = "Create new species")
    @PostMapping(path = "")
    @ResponseBody
    Species createSpecies(@RequestBody Species species) {
        return speciesRepository.save(species)
    }

}
