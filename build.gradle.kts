plugins {
    `java-library`
}

version = project.properties["version"].toString()
group = project.properties["maven_group"].toString()

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(group = "org.junit.jupiter", name = "junit-jupiter", version = "5.10.0")
    testRuntimeOnly(group = "org.junit.platform", name = "junit-platform-launcher")
    compileOnly(group = "jakarta.annotation", name = "jakarta.annotation-api", version = "2.1.1")
}

tasks.test {
    useJUnitPlatform()
}

task<Jar>("javadocJar") {
    archiveClassifier = "javadoc"
    from(tasks.javadoc)
}

tasks.javadoc {
    excludes += "**/test/**"
}


java.toolchain {
    languageVersion = JavaLanguageVersion.of(21)
}

