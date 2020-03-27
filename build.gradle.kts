/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Java Library project to get you started.
 * For more details take a look at the Java Libraries chapter in the Gradle
 * User Manual available at https://docs.gradle.org/6.2.2/userguide/java_library_plugin.html
 */

plugins {
    // Apply the java-library plugin to add support for Java Library
    `java-library`
    `application`

}

repositories {
    // Use jcenter for resolving dependencies.
    // You can declare any Maven/Ivy/file repository here.
    jcenter()

    flatDir {
        dirs("libs")
    }
}

dependencies {

    // This dependency is exported to consumers, that is to say found on their compile classpath.
    api("org.apache.commons:commons-math3:3.6.1")

    // https://mvnrepository.com/artifact/com.google.guava/guava
    api("com.google.guava:guava:28.2-jre");

    api("edu.princeton.cs.algs4:algs4:1.0")

    // https://mvnrepository.com/artifact/com.googlecode.princeton-java-algorithms/algorithms
    //api("com.googlecode.princeton-java-algorithms:algorithms:4.0.1")

    // This dependency is used internally, and not exposed to consumers on their own compile classpath.
    implementation("com.google.guava:guava:28.1-jre")

    // Use JUnit Jupiter API for testing.
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.5.2")

    // Use JUnit Jupiter params for testing.
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.5.2")

    // Use JUnit Jupiter Engine for testing.
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.5.2")
}

val test by tasks.getting(Test::class) {
    // Use junit platform for unit tests
    useJUnitPlatform()

application {
    mainClassName = "graphs.undirected.weighted.PrimEager"
}

}







