package fr.m2.pokequizz

import fr.m2.pokequizz.platform.removeDiacritics
import kotlin.test.Test
import kotlin.test.assertEquals

class TextNormalizationTest {
    @Test
    fun removesFrenchAccents() {
        assertEquals("Salameche", "Salamèche".removeDiacritics())
        assertEquals("Evoli", "Évoli".removeDiacritics())
        assertEquals("aeiouc", "àéîõüç".removeDiacritics())
        assertEquals("Evoli", "E\u0301voli".removeDiacritics())
    }

    @Test
    fun keepsPlainAscii() {
        assertEquals("Pikachu", "Pikachu".removeDiacritics())
    }
}