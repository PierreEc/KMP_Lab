package fr.m2.pokequiz.data

import fr.m2.pokequizz.domain.Pokemon
import kotlin.test.Test
import kotlin.test.assertEquals

class FakePokemonsTest {
    @Test
    fun firstTodoPokemonEntriesArePresent() {
        assertEquals(
            listOf(
                Pokemon(
                    id = 7,
                    nameFr = "Carapuce",
                    nameEn = "Squirtle",
                    imageUrl = "https://raw.githubusercontent.com/Yarkis01/TyraDex/images/sprites/7/regular.png",
                    types = listOf("water"),
                ),
                Pokemon(
                    id = 25,
                    nameFr = "Pikachu",
                    nameEn = "Pikachu",
                    imageUrl = "https://raw.githubusercontent.com/Yarkis01/TyraDex/images/sprites/25/regular.png",
                    types = listOf("electric"),
                ),
                Pokemon(
                    id = 39,
                    nameFr = "Rondoudou",
                    nameEn = "Jigglypuff",
                    imageUrl = "https://raw.githubusercontent.com/Yarkis01/TyraDex/images/sprites/39/regular.png",
                    types = listOf("normal", "fairy"),
                ),
            ),
            FakePokemons.all.filter { it.id in setOf(7, 25, 39) },
        )
    }
}
