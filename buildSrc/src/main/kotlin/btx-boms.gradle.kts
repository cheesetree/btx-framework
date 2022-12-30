plugins {
    `java-platform`
    `maven-publish`
    signing
}

/**
 * 默认为防止用户错误地引入依赖，而不是引入依赖约束，如果引入依赖会报错失败。
 * 通过这个配置可以让Gradle允许引入依赖，当然这是可选的
 */
javaPlatform {
    allowDependencies()
}

dependencies {
    val publishProjects: List<Project> by rootProject.extra
    constraints {
        Deps.getAll().forEach {
            api(it)
        }

        publishProjects.forEach {
            api(it)
        }
    }
    DepsManagement.getAll().forEach {
        api(platform(it))
    }
}

publishing {
    publications {
        create<MavenPublication>("btxbom") {
            artifactId = "btx-framework-dependencies"
            version = project.version.toString()
            from(components["javaPlatform"])
            withBuildIdentifier()
            pom {
                name.set("btx-framework-dependencies")
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
    sign(publishing.publications["btxbom"])
}

