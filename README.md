# shared-model

This repo contains shared code for all microservices by food2gether.

## How to use

You might want to replace the variable reference with the version you want to use.

### Maven
```xml
<project>
    <properties>
        <food2gether.shared-model.version>X.Y.Z</food2gether.shared-model.version>
        <!-- This is a private access token which can only read from the github packages registry of food2gether -->
        <!-- This token may be used by anyone who is interested in our packages -->
        <ghpkg.f2g.key>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</ghpkg.f2g.key>
    </properties>
    ...
    <repositories>
        <repository>
            <id>ghpkg-food2gether</id>
            <name>GitHub Packages Food2Gether</name>
            <url>https://anonymous:${ghpkg.f2g.key}@maven.pkg.github.com/food2gether/*</url>
        </repository>
    </repositories>
    
    <dependencies>
        <dependency>
            <groupId>com.github.food2gether</groupId>
            <artifactId>shared-model</artifactId>
            <version>${food2gether.shared-model.version}</version>
        </dependency>
    </dependencies>
    ...
</project>
```

### Gradle
In your `gralde.properties` file:
```properties
food2gether.shared-model.version=1.0.0
# This is a private access token which can only read from the github packages registry of food2gether
# This token may be used by anyone who is interested in our packages
ghpkg.f2g.key=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
```

In your `build.gradle.kts` file:
```kotlin
repositories {
    maven {
        name = "ghpkg-food2gether"
        url = uri("https://maven.pkg.github.com/food2gether/*")
        credentials {
            username = "anonymous"
            password = project.findProperty("ghpkg.f2g.key") as String
        }
    }
}

dependencies {
    implementation("com.github.food2gether:shared-model:${project.findProperty("food2gether.shared-model.version")}")
}
```