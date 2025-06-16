package com.vpdevs.uninotes

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform