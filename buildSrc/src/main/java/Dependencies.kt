object Versions {
    // Kotlin
    const val kotlinVersion = "1.3.21" // please also update in versions.gradle

    // Build info
    const val androidMinSdkVersion = 21
    const val androidTargetSdkVersion = 28
    const val androidCompileSdkVersion = 28
    const val androidBuildToolsVersion = "28.0.3"

    // Plugins
    const val androidGradlePlugin = "3.3.2"
    const val safeArgs = "2.1.0-alpha02"

    // AndroidX
    const val appcompat = "1.0.2"
    const val coreKtx = "1.0.1"
    const val constraintlayout = "1.1.3"
    const val legacySupport = "1.0.0"
    const val navigation = "2.1.0-alpha02"

    // Google
    const val material = "1.1.0-alpha04"

    // Utilities
    const val timber = "4.7.1"
}

object GradlePlugins {
    val android = "com.android.tools.build:gradle:${Versions.androidGradlePlugin}"
    val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}"
    val safeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.safeArgs}"
}

object Dependencies {

    object Kotlin {
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlinVersion}"
    }

    object AndroidX {
        const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
        const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
        const val constraintlayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintlayout}"
        const val legacySupport = "androidx.legacy:legacy-support-v4:${Versions.legacySupport}"
    }

    object AndroidArchitecture {
        const val navigationKtx = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
        const val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    }

    object Google {
        const val material = "com.google.android.material:material:${Versions.material}"
    }

    object Util {
        const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
    }
}
