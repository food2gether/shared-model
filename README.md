# shared-model

This repo contains shared code for all microservices by food2gether.

## How to use

You might want to replace the variable reference with the version you want to use.

### Maven
```xml
<project>
    <repositories>
        <repository>
            <id>jitpack</id>
            <name>Jitpack</name>
            <url>https://jitpack.io</url>
        </repository>
    </repositories>
    
    <dependencies>
        <dependency>
            <groupId>com.github.food2gether</groupId>
            <artifactId>shared-model</artifactId>
            <version>X.Y.Z</version>
        </dependency>
    </dependencies>
    ...
</project>
```

### Gradle

In your `build.gradle.kts` file:
```kotlin
repositories {
    maven {
        name = "jitpack"
        url = uri("https://jitpack.io")
    }
}

dependencies {
    implementation("com.github.food2gether:shared-model:X.Y.Z")
}
```
