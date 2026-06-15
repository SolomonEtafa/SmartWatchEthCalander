import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
}

val keystoreProperties = Properties().apply {
    rootProject.file("keystore.properties").inputStream().use(::load)
}

android {
    namespace = "com.solomonetafa.ethiopiancalendar"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.solomonetafa.ethiopiancalendar"
        minSdk = 33
        targetSdk = 35
        versionCode = 4
        versionName = "1.0.0"
    }

    signingConfigs {
        create("release") {
            storeFile = rootProject.file(keystoreProperties.getProperty("storeFile"))
            storePassword = keystoreProperties.getProperty("storePassword")
            keyAlias = keystoreProperties.getProperty("keyAlias")
            keyPassword = keystoreProperties.getProperty("keyPassword")
        }
    }

    buildTypes {
        debug {
            isMinifyEnabled = true
        }
        release {
            isMinifyEnabled = true
            isShrinkResources = false
            signingConfig = signingConfigs.getByName("release")
        }
    }
}
