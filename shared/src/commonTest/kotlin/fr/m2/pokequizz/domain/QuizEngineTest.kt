package fr.m2.pokequizz.domain

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertFalse
import kotlin.test.assertNull
import kotlin.test.assertTrue
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

class QuizEngineTest {
    private fun pokemon(id: Int, fr: String, en: String) = Pokemon(
        id = id,
        nameFr = fr,
        nameEn = en,
        imageUrl = "https://example.com/$id.png",
    )

    private val pokemons = listOf(
        pokemon(1, "Bulbizarre", "Bulbasaur"),
        pokemon(4, "Salamèche", "Charmander"),
        pokemon(7, "Carapuce", "Squirtle"),
        pokemon(25, "Pikachu", "Pikachu"),
        pokemon(133, "Évoli", "Eevee"),
    )

    @Test
    fun initialState() {
        val engine = QuizEngine(pokemons)
        assertEquals(5, engine.total)
        assertEquals(0, engine.currentIndex)
        assertEquals(pokemons[0], engine.current)
        assertFalse(engine.isFinished)
        assertEquals(0, engine.totalPoints)
        assertEquals(Duration.ZERO, engine.totalTime)
        assertTrue(engine.results.isEmpty())
    }

    @Test
    fun fullGameComputesTotals() {
        val engine = QuizEngine(pokemons)
        val first = engine.submit("bulbizarre", hintUsed = false, elapsed = 3.seconds)
        assertEquals(QuestionResult(pokemons[0], "bulbizarre", true, false, 3.seconds, 11), first)
        assertEquals(1, engine.currentIndex)
        assertEquals(pokemons[1], engine.current)
        engine.submit("salameche", hintUsed = true, elapsed = 12.seconds)
        engine.submit("tortank", hintUsed = false, elapsed = 4.seconds)
        engine.submit("PIKACHU", hintUsed = false, elapsed = 10.seconds)
        engine.submit(" evoli ", hintUsed = true, elapsed = 2.seconds)
        assertEquals(32, engine.totalPoints)
        assertEquals(31.seconds, engine.totalTime)
        assertTrue(engine.isFinished)
        assertEquals(5, engine.currentIndex)
        assertNull(engine.current)
        assertEquals(pokemons, engine.results.map { it.pokemon })
        assertEquals(listOf(11, 5, 0, 10, 6), engine.results.map { it.points })
    }

    @Test
    fun submitAfterEndThrows() {
        val engine = QuizEngine(pokemons)
        repeat(pokemons.size) { engine.submit("", false, Duration.ZERO) }
        assertFailsWith<IllegalStateException> { engine.submit("", false, Duration.ZERO) }
        assertEquals(pokemons.size, engine.results.size)
    }

    @Test
    fun emptyListIsRejected() {
        assertFailsWith<IllegalArgumentException> { QuizEngine(emptyList()) }
    }

    @Test
    fun inputListChangesDoNotAlterGame() {
        val input = pokemons.toMutableList()
        val engine = QuizEngine(input)
        input.clear()
        assertEquals(5, engine.total)
        assertEquals(pokemons[0], engine.current)
    }
}
