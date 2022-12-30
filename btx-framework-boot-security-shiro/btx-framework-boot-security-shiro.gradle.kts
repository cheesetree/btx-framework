/*
 * This file was generated by the Gradle 'init' task.
 *
 * This project uses @Incubating APIs which are subject to change.
 */

plugins {
    `java-library`
}

dependencies {
    api(project(":btx-framework-boot-security"))
    api(project(":btx-framework-boot-web"))
    api("org.apache.shiro:shiro-spring-boot-starter")
    api("org.jasig.cas.client:cas-client-support-saml")
    api("com.fasterxml.jackson.core:jackson-databind")
}

tasks {
    jar {
        enabled = true
        archiveClassifier.set("")
    }

}
