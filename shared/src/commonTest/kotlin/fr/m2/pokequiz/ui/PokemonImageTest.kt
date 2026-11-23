package fr.m2.pokequiz.ui

import kotlin.test.Test
import kotlin.test.assertEquals

class PokemonImageTest {
    @Test
    fun grayscaleUsesZeroSaturation() {
        assertEquals(0f, pokemonImageSaturation(grayscale = true))
    }

    @Test
    fun colorImageUsesFullSaturation() {
        assertEquals(1f, pokemonImageSaturation(grayscale = false))
    }
}
