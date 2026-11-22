package fr.m2.pokequizz.domain

import kotlin.time.Duration

class QuizEngine(pokemons: List<Pokemon>) {
    private val pokemons = pokemons.toList()

    init {
        require(this.pokemons.isNotEmpty()) { "Une partie nécessite au moins un Pokémon" }
    }

    val results: List<QuestionResult>
        field = mutableListOf<QuestionResult>()

    val total: Int get() = pokemons.size
    val currentIndex: Int get() = results.size
    val current: Pokemon? get() = pokemons.getOrNull(currentIndex)
    val isFinished: Boolean get() = currentIndex == total
    val totalPoints: Int get() = results.sumOf { it.points }
    val totalTime: Duration get() = results.fold(Duration.ZERO) { total, result -> total + result.elapsed }

    fun submit(answer: String, hintUsed: Boolean, elapsed: Duration): QuestionResult {
        val pokemon = checkNotNull(current) { "La partie est terminée" }
        val correct = AnswerChecker.isCorrect(answer, pokemon.nameFr)
        val result = QuestionResult(
            pokemon = pokemon,
            answer = answer,
            correct = correct,
            hintUsed = hintUsed,
            elapsed = elapsed,
            points = ScoreCalculator.points(correct, hintUsed, elapsed),
        )
        results.add(result)
        return result
    }
}
