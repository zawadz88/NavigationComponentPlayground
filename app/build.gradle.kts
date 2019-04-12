plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    kotlin("android.extensions")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdkVersion(Versions.androidCompileSdkVersion)
    defaultConfig {
        applicationId = "com.github.zawadz88.navigationcomponentplayground"
        minSdkVersion(Versions.androidMinSdkVersion)
        targetSdkVersion(Versions.androidTargetSdkVersion)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(Dependencies.Kotlin.stdlib)
    implementation(Dependencies.AndroidX.coreKtx)
    implementation(Dependencies.AndroidX.appcompat)
    implementation(Dependencies.AndroidX.constraintlayout)
    implementation(Dependencies.AndroidX.legacySupport)
    implementation(Dependencies.Google.material)
    implementation(Dependencies.AndroidArchitecture.navigationKtx)
    implementation(Dependencies.AndroidArchitecture.navigationUiKtx)
    implementation(Dependencies.Util.timber)
    implementation(Dependencies.Injection.dagger)
    implementation(Dependencies.Injection.daggerAndroid)

    kapt(Dependencies.Injection.daggerCompiler)
    kapt(Dependencies.Injection.daggerAnnotationProcessor)
}
