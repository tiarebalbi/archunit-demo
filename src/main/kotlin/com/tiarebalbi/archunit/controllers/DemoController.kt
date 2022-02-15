package com.tiarebalbi.archunit.controllers

import com.tiarebalbi.archunit.models.Demo
import com.tiarebalbi.archunit.services.DemoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
@ResponseBody
class DemoController(private val demoService: DemoService) {

    @GetMapping("/")
    fun getAllEntries() = demoService.findAll()

    @PostMapping("/save")
    fun getAllEntries(@RequestBody demo: Demo) = demoService.save(demo)
}
