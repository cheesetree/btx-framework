object Properties {
    const val springDependencyManagementVersion = "1.1.2"
    const val springBootVersion = "2.7.14"
    const val fastjsonVersion = "1.2.83"
    const val mybatisPlusVersion = "3.5.3.1"
    const val lombokVersion = "1.18.28"
    const val hutoolVersion = "5.8.20"
    const val orgMapstructVersion = "1.5.5.Final"
    const val lombokMapstructBindingVersion = "0.2.0"
    const val shiroVersion = "1.12.0"
    const val jasigCasVersion = "3.6.4"
    const val jacksonVersion = "2.14.1"
    const val okhttpVersion = "4.10.0"
    const val snakeyamlVersion = "1.33"
    const val feignVersion = "12.4"
    const val guavaVersion = "32.1.1-jre"
    const val log4jVersion = "2.20.0"
    const val jmhVersion = "1.36"
    const val redissonVersion = "3.17.7"
    const val flywayVersion = "9.21.0"
}

object Deps {
    const val snakeyaml = "org.yaml:snakeyaml"
    const val lombok = "org.projectlombok:lombok"
    const val mapstruct = "org.mapstruct:mapstruct:${Properties.orgMapstructVersion}"
    const val mybatisPlusStarter = "com.baomidou:mybatis-plus-boot-starter:${Properties.mybatisPlusVersion}"
    const val mybatisPlus = "com.baomidou:mybatis-plus:${Properties.mybatisPlusVersion}"
    const val oracleJdbc = "com.oracle.database.jdbc:ojdbc8"
    const val oracleJdbcI18n = "com.oracle.database.nls:orai18n"
    const val mysqlJdbc = "com.mysql:mysql-connector-j"
    const val postgresqlJdbc = "org.postgresql:postgresql"
    const val feignReactiveWrappers = "io.github.openfeign:feign-reactive-wrappers:${Properties.feignVersion}"
    const val feignHttpclient = "io.github.openfeign:feign-okhttp:${Properties.feignVersion}"
    const val guava = "com.google.guava:guava:${Properties.guavaVersion}"
    const val lombokMapstructBinding =
        "org.projectlombok:lombok-mapstruct-binding:${Properties.lombokMapstructBindingVersion}"
    const val mapstructProcessor = "org.mapstruct:mapstruct-processor:${Properties.orgMapstructVersion}"
    const val lombokProcessor = "org.projectlombok:lombok:${Properties.lombokVersion}"

    // 修复Apache Log4j任意代码执行漏洞安全风险
    const val log4jToSlf4j = "org.apache.logging.log4j:log4j-to-slf4j:${Properties.log4jVersion}"
    const val log4jApi = "org.apache.logging.log4j:log4j-api:${Properties.log4jVersion}"

    // 修复jacksonDatabind任意代码执行漏洞安全风险
    const val jacksonDatabind = "com.fasterxml.jackson.core:jackson-databind:${Properties.jacksonVersion}"
    const val fastjson = "com.alibaba:fastjson:${Properties.fastjsonVersion}"
    const val shiroStarter = "org.apache.shiro:shiro-spring-boot-starter:${Properties.shiroVersion}"
    const val jasigCas = "org.jasig.cas.client:cas-client-support-saml:${Properties.jasigCasVersion}"
    const val okhttp = "com.squareup.okhttp3:okhttp:${Properties.okhttpVersion}"
    const val redisson = "org.redisson:redisson-spring-boot-starter:${Properties.redissonVersion}"
    const val flywaydb = "org.flywaydb:flyway-core:${Properties.flywayVersion}"

    const val springBootConfigurationProcessor =
        "org.springframework.boot:spring-boot-configuration-processor:${Properties.springBootVersion}"

    const val jmhCore = "org.openjdk.jmh:jmh-core:${Properties.jmhVersion}"
    const val jmhGeneratorAnnprocess = "org.openjdk.jmh:jmh-generator-annprocess:${Properties.jmhVersion}"

    fun getAll(): List<String> {
        return listOf(
            snakeyaml,
            lombok,
            mapstruct,
            mybatisPlusStarter,
            mybatisPlus,
            oracleJdbc,
            oracleJdbcI18n,
            mysqlJdbc,
            postgresqlJdbc,
            feignReactiveWrappers,
            feignHttpclient,
            mapstructProcessor,
            lombokMapstructBinding,
            fastjson,
            guava,
            log4jToSlf4j,
            log4jApi,
            jmhCore,
            jmhGeneratorAnnprocess,
            jacksonDatabind,
            shiroStarter,
            jasigCas,
            redisson,
            okhttp,
            flywaydb
        )
    }
}

object DepsManagement {
    const val springBoot = "org.springframework.boot:spring-boot-dependencies:${Properties.springBootVersion}"
    const val hutool = "cn.hutool:hutool-bom:${Properties.hutoolVersion}"

    /**
     * 获取所有的托管的版本
     */
    fun getAll(): List<String> {
        return listOf(springBoot, hutool)
    }

}



