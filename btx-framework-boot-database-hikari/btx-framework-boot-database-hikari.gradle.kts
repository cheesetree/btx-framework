/*
 * This file was generated by the Gradle 'init' task.
 *
 * This project uses @Incubating APIs which are subject to change.
 */

plugins {
    `java-library`
}

dependencies {
    compileOnly("org.springframework.boot:spring-boot-starter-jdbc")
}

tasks {
    jar {
        enabled = true
        archiveClassifier.set("")
    }
}
