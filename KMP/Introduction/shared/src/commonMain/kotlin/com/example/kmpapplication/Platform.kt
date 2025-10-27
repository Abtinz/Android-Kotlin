package com.example.kmpapplication

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform