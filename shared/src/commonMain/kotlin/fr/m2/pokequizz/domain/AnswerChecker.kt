package fr.m2.pokequizz.domain

import fr.m2.pokequizz.platform.removeDiacritics

object AnswerChecker {
    private val NON_ALPHANUMERIC = Regex("[^a-z0-9]")

    fun normalize(input: String): String =
        input.trim().lowercase().removeDiacritics().replace(NON_ALPHANUMERIC, "")

    fun isCorrect(input: String, expected: String): Boolean {
        val normalized = normalize(input)
        return normalized.isNotEmpty() && normalized == normalize(expected)
    }

    fun hint(name: String): String = name.firstOrNull()?.uppercase() ?: ""
}
