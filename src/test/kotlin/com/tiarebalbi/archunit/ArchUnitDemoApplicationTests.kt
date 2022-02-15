package com.tiarebalbi.archunit

import com.tngtech.archunit.core.domain.JavaClasses
import com.tngtech.archunit.core.importer.ImportOption
import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses
import com.tngtech.archunit.library.Architectures.layeredArchitecture
import com.tngtech.archunit.library.GeneralCodingRules

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

    @ArchTest
    internal fun `all exception classes must have Exception as a suffix`(importedClasses: JavaClasses) {
        classes().that().resideInAPackage("..exceptions..").should()
            .haveSimpleNameEndingWith("Exception").check(importedClasses)
    }

    @ArchTest
    internal fun `no class should throw generic exception`(importedClasses: JavaClasses) {
        noClasses().should(GeneralCodingRules.THROW_GENERIC_EXCEPTIONS).check(importedClasses)
    }

    @ArchTest
    internal fun `no class should use joda time`(importedClasses: JavaClasses) {
        noClasses().should(GeneralCodingRules.USE_JODATIME).check(importedClasses)
    }
}
