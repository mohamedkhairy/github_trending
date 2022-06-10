package dependencies

object Ktor {
    private const val ktorVersion = "1.6.2"
    const val core = "io.ktor:ktor-client-core:$ktorVersion"
    const val clientSerialization = "io.ktor:ktor-client-serialization:$ktorVersion"
    const val android = "io.ktor:ktor-client-android:$ktorVersion"
    const val ktorJson = "io.ktor:ktor-client-json:$ktorVersion"
    const val logging = "io.ktor:ktor-client-logging:$ktorVersion"



//    const val ktorServerTest = "io.ktor:ktor-server-test-host:$ktorVersion"
//    const val ktorKotlinTest = "org.jetbrains.kotlin:kotlin-test:$ktorVersion"
//    const val ktorClientMock = "io.ktor:ktor-client-mock:$ktorVersion"
}