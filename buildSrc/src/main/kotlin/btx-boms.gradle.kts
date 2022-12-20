plugins {
    `java-platform`
    `maven-publish`
}

/**
 * 默认为防止用户错误地引入依赖，而不是引入依赖约束，如果引入依赖会报错失败。
 * 通过这个配置可以让Gradle允许引入依赖，当然这是可选的
 */
javaPlatform {
    allowDependencies()
}

dependencies {
    val publishProjects:List<Project> by rootProject.extra
    constraints {
        Deps.getAll().forEach {
            api(it)
        }

        publishProjects.forEach {
            api(it)
        }
    }
    DepsManagement.getAll().forEach{
        api(platform(it))
    }
}
