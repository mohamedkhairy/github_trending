

//buildscript {
//
//    val kotlin_version by extra("1.5.31")
//    repositories {
//        gradlePluginPortal()
//        google()
//        mavenCentral()
//    }
//
//    dependencies {
//        classpath ("org.jetbrains.kotlin.android:1.5.31")
////        classpath ("com.google.dagger:hilt-android-gradle-plugin:2.38.1")
//        classpath("com.android.application:7.2.0")
//        classpath("com.android.library:7.2.0")
//
//
//    }
//}
//
//allprojects {
//    repositories {
//        google()
//        mavenCentral()
//        jcenter() // Warning: this repository is going to shut down soon
//    }
//}
//
//tasks.register("clean",Delete::class){
//    delete(rootProject.buildDir)
//}


buildscript {
        val compose_version by extra ("1.1.0-beta01")

}// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id ("com.android.application") version "7.2.0" apply false
    id ("com.android.library") version "7.2.0" apply false
    id ("org.jetbrains.kotlin.android") version "1.5.31" apply false
    id ("com.google.dagger.hilt.android") version "2.41" apply false

}

tasks.register("clean",Delete::class){
    delete(rootProject.buildDir)
}

