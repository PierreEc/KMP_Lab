package fr.m2.pokequiz.data
import fr.m2.pokequizz.domain.Score
import kotlin.time.Duration.Companion.seconds
object FakeScores {
    val initial: List<Score> = listOf(
        Score(
            id = 1,
            pseudo = "Sacha",
            points = 50,
            totalTime = 71.seconds,
            hintsUsed = 1,
            playedAtEpochMs = 0L),

        Score(
            id = 2,
            pseudo = "Sdfdacha",
            points = 50,
            totalTime = 73.seconds,
            hintsUsed = 1,
            playedAtEpochMs = 0L),

        Score(
            id = 3,
            pseudo = "Hugo",
            points = 60,
            totalTime = 70.seconds,
            hintsUsed = 1,
            playedAtEpochMs = 0L),
    )
}