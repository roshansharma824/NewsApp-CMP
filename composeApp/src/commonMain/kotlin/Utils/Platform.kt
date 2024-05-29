package Utils

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform