package fr.m2.pokequizz

import fr.m2.pokequizz.platform.removeDiacritics
import kotlin.test.Test
import kotlin.test.assertEquals
class TextNormalizationTest {
    @Test
    fun removesFrenchAccents() {
        assertEquals("Salameche","Salamèche".removeDiacritics())
        assertEquals("Evoli","Évoli".removeDiacritics())
    }
    @Test
    fun keepsPlainAscii() {
// TODO : "Pikachu" reste "Pikachu"
    }
}