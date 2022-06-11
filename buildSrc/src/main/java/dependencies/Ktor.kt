package dependencies

object Ktor {
    private const val ktorVersion = "1.6.2"
    const val core = "io.ktor:ktor-client-core:$ktorVersion"
    const val clientSerialization = "io.ktor:ktor-client-serialization:$ktorVersion"
    const val android = "io.ktor:ktor-client-android:$ktorVersion"
    const val ktorJson = "io.ktor:ktor-client-json:$ktorVersion"
    const val logging = "io.ktor:ktor-client-logging:$ktorVersion"


}