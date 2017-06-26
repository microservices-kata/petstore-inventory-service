package com.thoughtworks.petstore.inventory.controller

import com.google.common.collect.ImmutableMap
import groovy.transform.CompileStatic
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@CompileStatic
@Controller
@RequestMapping(value = "/app")
class AppController {

    @Value("\${app.lang}")
    String lang
    @Value("\${spring.profiles}")
    String env

    @ApiOperation(value = "Show programing language")
    @GetMapping(path = "/info")
    @ResponseBody
    public Map getLanguage() {
        return ImmutableMap.of("language", lang,
                "environment", env)
    }
}
