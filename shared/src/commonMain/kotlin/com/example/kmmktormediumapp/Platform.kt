package com.example.kmmktormediumapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform