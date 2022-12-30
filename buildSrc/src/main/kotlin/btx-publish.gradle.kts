import gradle.kotlin.dsl.accessors._6e78ee606e21d4d412c9c7a30855ae8d.java
import gradle.kotlin.dsl.accessors._df9f62808d4885b549ed5034a73d99cf.publishing
import gradle.kotlin.dsl.accessors._df9f62808d4885b549ed5034a73d99cf.signing
import java.util.regex.Pattern

plugins {
    `java-library`
    `maven-publish`
    signing
}

tasks {
    java {
        withSourcesJar()
        withJavadocJar()
    }

    javadoc{
        if (JavaVersion.current().isJava9Compatible) {
            (options as StandardJavadocDocletOptions).addBooleanOption("html5", true)
        }
        options.apply {
            encoding("UTF-8")
            charset("UTF-8")
            isFailOnError = false

            (this as StandardJavadocDocletOptions).apply {
                addStringOption("Xdoclint:none")
            }
        }
    }

}

publishing {
    publications {
        create<MavenPublication>("btx") {
            version = project.version.toString()
            from(components["java"])
            withBuildIdentifier()
            pom {
                name.set(project.name)
                description.set("An enterprise-level development framework based on springboot")
                url.set("https://github.com/cheesetree/btx-framework")
                licenses {
                    license {
                        name.set("The Apache Software License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                        distribution.set("repo")
                    }
                }
                developers {
                    developer {
                        id.set("cheesetree")
                        name.set("cheesetree")
                        email.set("cheesetree@163.com")
                        roles.add("Developer")
                        timezone.set("+8")
                    }
                }
                scm {
                    connection.set("https://github.com/cheesetree/btx-framework.git")
                    url.set("https://github.com/cheesetree/btx-framework")
                }
            }

            versionMapping {
//                usage("java-api") {
//                    fromResolutionOf("runtimeClasspath")
//                }
//                usage("java-runtime") {
//                    fromResolutionResult()
//                }
                allVariants {
                    fromResolutionResult()
                }
            }
        }
    }

    repositories {
        maven {
            name = "OSSRH"
            credentials {
                username = "${project.properties["OSSRH_USER"]}"
                password = "${project.properties["OSSRH_PASSWORD"]}"
            }
            isAllowInsecureProtocol = true
            url = if (project.version.toString().endsWith("-SNAPSHOT")) {
                BtxRepositories.ossrhMavenSnapshotsUrl
            } else {
                BtxRepositories.ossrhMavenReleasesUrl
            }
        }
    }
}

signing {
    sign(publishing.publications["btx"])
}

val fixPom: TaskProvider<Task> = tasks.register("fixPom") {
    doLast {
        val file = File("$buildDir/publications/btx/pom-default.xml")
        var content = file.readText()
        val pattern = Pattern.compile(
            "(?s)(<dependencyManagement>.+?<dependencies>)(.+?)(</dependencies>.+?</dependencyManagement>)",
            Pattern.DOTALL
        )
        var matcher = pattern.matcher(content)
        // 每次重头开始匹配解决多个dependencyManagement只被替换一次的问题
        while (matcher.find(0)) {
            val firstDependencies = matcher.group(2)
            content = matcher.replaceFirst("")
            matcher = pattern.matcher(content)
            content = matcher.replaceFirst("$1$2$firstDependencies$3")
        }
        // 删除版本号,全部依赖版本号
//        val versionPattern = Pattern.compile("(?s)(<dependency>.+?</artifactId>)(.+?</version>)(.+?<scope>" +
//                ".+?</dependency>)")
//        matcher = versionPattern.matcher(content)
//        if (matcher.find()) {
//            content = matcher.replaceAll("$1$3")
//        }
        // 去除空行
        val blankLinePattern = Pattern.compile("(?m)^\\s*$(\\n|\\r\\n)")
        matcher = blankLinePattern.matcher(content)
        content = matcher.replaceAll("")
        file.writeText(content)
    }
}

tasks.findByName("generatePomFileForBtxPublication")?.finalizedBy(fixPom)
