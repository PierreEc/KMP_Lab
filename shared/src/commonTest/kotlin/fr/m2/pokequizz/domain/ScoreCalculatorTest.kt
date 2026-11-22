package fr.m2.pokequizz.domain

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

class ScoreCalculatorTest {
    @Test
    fun correctWithoutHintFast() {
        assertEquals(11, ScoreCalculator.points(true, false, 5.seconds))
    }

    @Test
    fun correctWithoutHintSlow() {
        assertEquals(10, ScoreCalculator.points(true, false, 15.seconds))
    }

    @Test
    fun correctWithHintFast() {
        assertEquals(6, ScoreCalculator.points(true, true, 5.seconds))
    }

    @Test
    fun correctWithHintSlow() {
        assertEquals(5, ScoreCalculator.points(true, true, 15.seconds))
    }

    @Test
    fun incorrectWithoutHintFast() {
        assertEquals(0, ScoreCalculator.points(false, false, 5.seconds))
    }

    @Test
    fun incorrectWithHint() {
        assertEquals(0, ScoreCalculator.points(false, true, 5.seconds))
    }

    @Test
    fun exactlyTenSecondsGivesNoBonus() {
        assertEquals(10, ScoreCalculator.points(true, false, 10.seconds))
        assertEquals(5, ScoreCalculator.points(true, true, 10.seconds))
    }

    @Test
    fun justUnderTenSecondsGivesBonus() {
        assertEquals(11, ScoreCalculator.points(true, false, 9_999.milliseconds))
    }
}
