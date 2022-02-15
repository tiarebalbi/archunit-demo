package com.tiarebalbi.archunit.repositories

import com.tiarebalbi.archunit.models.Demo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DemoRepository : JpaRepository<Demo, Long> {
    fun existsByName(name: String): Boolean
}
