import dependencies.BuildVersion
import dependencies.AndroidX
import dependencies.Google
import dependencies.Hilt
import dependencies.Kotlinx
import dependencies.Ktor
import dependencies.Serialization
import dependencies.Kotlin
import dependencies.Compose
import dependencies.Coil
import dependencies.Room



plugins {
    id("com.android.application")
    kotlin("android")
    id ("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    kotlin("plugin.serialization") version "1.5.31"
    id("kotlin-android")
}

android {

    compileSdk = BuildVersion.compileSdk
//    buildToolsVersion = BuildVersion.buildTools
    defaultConfig {
        applicationId  = BuildVersion.appId
        minSdk = BuildVersion.minSdk
        targetSdk = BuildVersion.targetSdk
        versionCode  = BuildVersion.versionCode
        versionName = BuildVersion.versionName
        multiDexEnabled = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }



    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility  = JavaVersion.VERSION_1_8
        targetCompatibility  = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = BuildVersion.jvmTarget
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = rootProject.extra["compose_version"] as String
    }

    packagingOptions {
        exclude("/META-INF/{AL2.0,LGPL2.1}")
    }

    }



dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation (Kotlin.kotlinStdlib)

    implementation(AndroidX.constraintlayout)
    implementation(AndroidX.coreKtx)
    implementation(AndroidX.appCompat)
    implementation(AndroidX.lifecycleRuntime)
    implementation(AndroidX.lifecycleVmKtx)
    implementation(AndroidX.livedataKtx)
    implementation(AndroidX.fragmentKtx)
//    implementation(AndroidX.swiperefreshlayout)

    implementation(Google.material)
    implementation(Hilt.android)
//    implementation("androidx.legacy:legacy-support-v4:1.0.0")
//    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.4.1")
//    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.1")
    kapt(Hilt.compiler)


    implementation(Coil.coil)

    implementation(Room.room)
    implementation(Room.roomKtx)
    kapt(Room.roomCompiler)

    implementation(Kotlinx.coroutinesCore)
    implementation(Compose.composeUi)
    implementation(Compose.composeMaterial)
    implementation(Compose.composeTools)
    implementation(Compose.composeActivity)


    implementation(Serialization.serialization)

    implementation(Ktor.core)
    implementation(Ktor.clientSerialization)
    implementation(Ktor.android)
    implementation(Ktor.ktorJson)
    implementation(Ktor.logging)

    testImplementation("junit:junit:4.12")
    androidTestImplementation("androidx.test:runner:1.1.2-alpha01")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.1.2-alpha01")




}
kapt {
    correctErrorTypes = true
}

