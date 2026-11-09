package fr.m2.pokequizz

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform