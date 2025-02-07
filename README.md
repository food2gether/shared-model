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
        <ghpkg.f2g.key>g&#x69;&#x74;&#x68;&#x75;&#x62;&#x5F;&#x70;&#x61;&#x74;&#x5F;&#x31;&#x31;&#x41;&#x4F;&#x37;&#x47;&#x58;&#x33;&#x49;&#x30;&#x65;&#x43;&#x61;&#x7A;&#x6F;&#x69;&#x48;&#x38;&#x53;&#x75;&#x68;&#x4C;&#x5F;&#x37;&#x46;&#x71;&#x50;&#x57;&#x43;&#x4C;&#x6D;&#x70;&#x70;&#x70;&#x39;&#x61;&#x48;&#x39;&#x6E;&#x42;&#x51;&#x38;&#x76;&#x49;&#x4E;&#x4A;&#x74;&#x73;&#x68;&#x63;&#x33;&#x73;&#x61;&#x49;&#x33;&#x5A;&#x55;&#x71;&#x6C;&#x4D;&#x74;&#x62;&#x52;&#x6E;&#x6E;&#x76;&#x47;&#x5A;&#x36;&#x4E;&#x46;&#x54;&#x4B;&#x4F;&#x37;&#x35;&#x6D;&#x4F;&#x64;&#x6A;&#x56;&#x33;</ghpkg.f2g.key>
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