/*
 * This file was generated by the Gradle 'init' task.
 *
 * This project uses @Incubating APIs which are subject to change.
 */

plugins {
    `java-library`
    id("org.springframework.boot")
}

dependencies {
    api(project(":btx-framework-core"))
    api("org.springframework.boot:spring-boot-autoconfigure")
}

tasks {
    jar {
        enabled = true
        archiveClassifier.set("")
    }

}