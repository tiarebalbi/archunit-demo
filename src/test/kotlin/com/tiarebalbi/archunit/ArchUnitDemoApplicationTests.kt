package com.tiarebalbi.archunit

import com.tngtech.archunit.core.domain.JavaClasses
import com.tngtech.archunit.core.importer.ImportOption
import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.library.Architectures.layeredArchitecture

@AnalyzeClasses(packages = ["com.tiarebalbi"], importOptions = [ImportOption.DoNotIncludeTests::class])
class ArchUnitDemoApplicationTests {
    @ArchTest
    internal fun `A service can only access a repository`(importedClasses: JavaClasses) {
        layeredArchitecture()
            .layer("Controller").definedBy("..controllers..")
            .layer("Service").definedBy("..services..")
            .layer("Persistence").definedBy("..repositories..")
            .whereLayer("Controller").mayNotBeAccessedByAnyLayer()
            .whereLayer("Service").mayOnlyBeAccessedByLayers("Controller")
            .whereLayer("Persistence").mayOnlyBeAccessedByLayers("Service")
            .check(importedClasses)
    }
}
