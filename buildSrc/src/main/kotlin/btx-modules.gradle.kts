plugins {
    `java-library`
    `java-test-fixtures`
}

dependencies {
}


// Disable publication of test fixture artifacts.
val javaComponent = components["java"] as AdhocComponentWithVariants
javaComponent.withVariantsFromConfiguration(configurations["testFixturesApiElements"]) {
    skip()
}
javaComponent.withVariantsFromConfiguration(configurations["testFixturesRuntimeElements"]) {
    skip()
}
