package fr.m2.pokequiz.data

import fr.m2.pokequizz.domain.PokemonSummary
import fr.m2.pokequizz.domain.QUESTIONS_PER_GAME
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue
import kotlin.time.Duration

class FakePokemonRepositoryTest {
    private val repository = FakePokemonRepository(latency = Duration.ZERO)

    @Test
    fun pokemonReturnsTheMatchingId() = runTest {
        assertEquals(FakePokemons.pikachu, repository.pokemon(25))
    }

    @Test
    fun pokemonThrowsWhenIdDoesNotExist() = runTest {
        assertFailsWith<NoSuchElementException> {
            repository.pokemon(999)
        }
    }

    @Test
    fun pageReturnsEnglishSummariesForTheRequestedRange() = runTest {
        assertEquals(
            listOf(
                PokemonSummary(4, "Charmander", artworkUrl(4)),
                PokemonSummary(7, "Squirtle", artworkUrl(7)),
            ),
            repository.page(offset = 1, limit = 2),
        )
    }

    @Test
    fun pagePastTheEndIsEmpty() = runTest {
        assertTrue(repository.page(offset = 10, limit = 2).isEmpty())
    }

    @Test
    fun randomPokemonsReturnsRequestedDistinctPokemon() = runTest {
        val selected = repository.randomPokemons(count = 3)

        assertEquals(3, selected.size)
        assertEquals(3, selected.map { it.id }.toSet().size)
        assertTrue(selected.all { it in FakePokemons.all })
    }

    @Test
    fun randomPokemonsUsesTheDefaultQuestionCount() = runTest {
        assertEquals(QUESTIONS_PER_GAME, repository.randomPokemons().size)
    }

    @Test
    fun randomPokemonsReturnsAllAvailableWhenCountIsLargerThanDataset() = runTest {
        assertEquals(
            FakePokemons.all.map { it.id }.toSet(),
            repository.randomPokemons(count = 10).map { it.id }.toSet(),
        )
    }
}
