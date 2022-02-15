package com.tiarebalbi.archunit

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ArchunitDemoApplication

fun main(args: Array<String>) {
    runApplication<ArchunitDemoApplication>(*args)
}
