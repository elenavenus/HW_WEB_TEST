plugins {
    id("java")
}

group = "ru.netology"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.2")
    // Uncomment if using Selenide
    testImplementation("com.codeborne:selenide:6.17.2")
}

tasks.test {
    useJUnitPlatform()
    // Pass the `selenide.headless` property to the JVM, useful in Selenide-based projects
    systemProperty("selenide.headless", System.getProperty("selenide.headless"))
    // Set browser preferences for Selenide-based projects, disabling the password manager
    //systemProperty("chromeoptions.prefs", System.getProperty("chromeoptions.prefs", "profile.password_manager_leak_detection=false"))
}