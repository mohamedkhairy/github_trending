
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

