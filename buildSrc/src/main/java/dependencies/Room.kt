package dependencies

object Room {

    private const val room_version = "2.4.2"
    val room by lazy { "androidx.room:room-runtime:$room_version" }
    val roomCompiler by lazy { "androidx.room:room-compiler:$room_version" }
    val roomKtx by lazy { "androidx.room:room-ktx:$room_version" }

}