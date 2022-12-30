import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

plugins {
    `kotlin-dsl`
    id("java-gradle-plugin")
    id("org.springframework.boot") version Properties.springBootVersion apply false
    id("io.spring.dependency-management") version Properties.springDependencyManagementVersion apply false
}

val frameworkBomProject = project(":btx-framework-dependencies")
val moduleProjects = subprojects.filter { it.name.startsWith("btx-framework") } - frameworkBomProject
val publishProjects by extra {
    subprojects - frameworkBomProject
}
val javaProjects = subprojects - frameworkBomProject

configure(allprojects) {
    group = "top.cheesetree.btx.framework"
    version = BtxRepositories.version

    repositories {
        mavenLocal()
        // 优先使用国内源
        maven { setUrl("https://maven.aliyun.com/repository/public") }
        maven { setUrl("https://maven.aliyun.com/repository/central") }
        maven { setUrl("https://maven.aliyun.com/repository/spring") }
        maven { setUrl("https://maven.aliyun.com/repository/jcenter") }
        maven { setUrl("https://maven.aliyun.com/repository/apache-snapshots") }
        maven { setUrl("https://maven.aliyun.com/repository/google") }
        maven { setUrl("https://maven.aliyun.com/repository/releases") }
        maven { setUrl("https://maven.aliyun.com/repository/snapshots") }
        maven { setUrl("https://maven.aliyun.com/repository/grails-core") }
        maven { setUrl("https://maven.aliyun.com/repository/mapr-public") }
        maven { setUrl("https://maven.aliyun.com/repository/gradle-plugin") }
        maven { setUrl("https://maven.aliyun.com/repository/spring-plugin") }
        mavenCentral()
    }


    configurations.all {
        resolutionStrategy.cacheChangingModulesFor(0, "minutes")
        //exclude(group = "junit", module = "junit")
    }

    tasks.withType<GenerateModuleMetadata> {
        enabled = false
    }
}

configure(javaProjects) {
    apply {
        plugin("io.spring.dependency-management")
        plugin("java-library")
    }

    dependencies {
        api(platform(frameworkBomProject))

        implementation(Deps.lombok)
        implementation(Deps.mapstruct)

        annotationProcessor(Deps.lombokProcessor)
        annotationProcessor(Deps.mapstructProcessor)
        annotationProcessor(Deps.lombokMapstructBinding)
        annotationProcessor(Deps.springBootConfigurationProcessor)
        testAnnotationProcessor(Deps.lombokProcessor)
        testAnnotationProcessor(Deps.mapstructProcessor)
        testAnnotationProcessor(Deps.lombokMapstructBinding)
    }


    java {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    tasks.withType<Test> {
        //junit5测试框架使用以下配置
        useJUnitPlatform()
    }

    tasks.withType<Jar> {
        manifest {
            val currentTime = LocalDateTime.now()
            val formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmm")
            attributes(
                "Manifest-Version" to "1.0",
                "Implementation-Title" to project.name,
                "Automatic-Module-Name" to project.name,
                "Implementation-Version" to project.version,
                "Built-By" to System.getProperty("user.name"),
                "Built-Timestamp" to currentTime.toInstant(ZoneOffset.ofHours(8)).toEpochMilli(),
                "Built-Time" to formatter.format(currentTime),
                "Build-Jdk-Spec" to System.getProperty("java.version")
            )
        }
    }
}

configure(moduleProjects) {
    apply {
        plugin("btx-modules")
    }
}

configure(publishProjects) {
    apply {
        plugin("btx-publish")
    }

}