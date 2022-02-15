package com.tiarebalbi.archunit.services

import com.tiarebalbi.archunit.models.Demo
import com.tiarebalbi.archunit.repositories.DemoRepository
import com.tiarebalbi.archunit.services.exceptions.ValidationException
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class DemoService(private val demoRepository: DemoRepository) {
    private val logger = LoggerFactory.getLogger(this::class.java)

    fun findAll(): MutableList<Demo> {
        logger.info("Retrieving all entries")

        return this.demoRepository.findAll()
    }

    fun save(demo: Demo) {
        val exists = this.demoRepository.existsByName(demo.name)
        if (exists) {
            logger.warn("Demo > Name: ${demo.name} is duplicated")
            throw ValidationException("unable to save record")
        }

        this.demoRepository.save(demo)
    }
}
