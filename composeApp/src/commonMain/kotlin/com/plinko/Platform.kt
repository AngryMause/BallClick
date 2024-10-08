package com.plinko

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform