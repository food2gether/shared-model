# shared-model

This repo contains shared code for all microservices by food2gether.

## How to use

You might want to replace the variable reference with the version you want to use.

### Maven
```xml
<project>
    ...
    <repositories>
        <repository>
            <id>ghpkg-f2g-shared-model</id>
            <name>GitHub Packages Food2Gether shared-model</name>
            <url>https://maven.pkg.github.com/food2gether/shared-model</url>
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
```kotlin
repositories {
    maven {
        name = "GitHubPackages"
        url = uri("https://maven.pkg.github.com/food2gether/shared-model")
        credentials {
            username = project.findProperty("gh.user") ?: System.getenv("GH_USERNAME")
            password = project.findProperty("gh.token") ?: System.getenv("GH_TOKEN")
        }
    }
}

dependencies {
    implementation("com.github.food2gether:shared-model:${project.findProperty("food2gether.shared-model.version")}")
}
```