import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    base
    kotlin("jvm") version Kotlin.version apply false
    id("io.spring.dependency-management") version SpringDependencyManagement.version
    id("org.springframework.boot") version SpringBoot.version
    id("org.jetbrains.kotlin.plugin.spring") version Kotlin.version
}

// whoknows.. might break it? probably not though...
allprojects {

    group = "com.dcsg.pricing"
    version = "1.0"

    repositories {
        mavenCentral()
        mavenLocal()
        maven {
            name = "dsg-nexus-pricing"
            url = uri("https://nexus.tools.dcsg.com/repository/pricing")
        }
        maven {
            name = "dsg-nexus-releases"
            url = uri("https://nexus.tools.dcsg.com/repository/maven-releases")
        }
        maven { url = uri("https://packages.confluent.io/maven/") }
        maven { url = uri("https://plugins.gradle.org/m2/") }
        maven { url = uri("https://repo.spring.io/milestone") }
    }
}

subprojects {

    // a way to use plugins
    apply {
        plugin("org.jetbrains.kotlin.jvm") // kotlin jvm plugin
        plugin("kotlin-spring") // kotlin spring plugin
        plugin("io.spring.dependency-management") // imports the bom
    }

    dependencyManagement {
        imports {
            mavenBom("org.springframework.boot:spring-boot-dependencies:${SpringBoot.version}")
            mavenBom("org.jetbrains.kotlin:kotlin-bom:${Kotlin.version}")
            mavenBom("org.springframework.cloud:spring-cloud-dependencies:${SpringCloud.version}")
        }
    }

    configurations.all {
        this.exclude("org.springframework.boot", "spring-boot-starter-logging")
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            // ah, specifing the nul safety of kotlin.. nothing crazy here :)
            // See https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-kotlin.html#boot-features-kotlin-null-safety
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = Jvm.target
        }
    }

    // tasks with type test..
    tasks.withType<Test> {

        // love junit!
        useJUnitPlatform()

        // Ensures that when tests fail we have as much information as possible to
        // diagnose the issue
        testLogging {
            showStackTraces = true
            showCauses = true
            showExceptions = true
            exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
        }
    }

}


