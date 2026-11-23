package fr.m2.pokequiz.ui.theme

import androidx.compose.ui.graphics.Color
import kotlin.test.Test
import kotlin.test.assertEquals

class PokeQuizThemeTest {
    @Test
    fun lightThemeUsesLightPokedexColors() {
        val colorScheme = pokeQuizColorScheme(darkTheme = false)

        assertEquals(Color(0xFFDC0A2D), colorScheme.primary)
        assertEquals(Color(0xFFFFFBFF), colorScheme.background)
        assertEquals(Color.White, colorScheme.onPrimary)
    }

    @Test
    fun darkThemeUsesDarkSurfacesAndLightPokedexColors() {
        val colorScheme = pokeQuizColorScheme(darkTheme = true)

        assertEquals(Color(0xFFFFB3B7), colorScheme.primary)
        assertEquals(Color(0xFF1A1112), colorScheme.background)
        assertEquals(Color(0xFF680014), colorScheme.onPrimary)
    }
}
