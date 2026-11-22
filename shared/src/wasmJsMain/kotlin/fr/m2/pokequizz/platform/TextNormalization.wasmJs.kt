package fr.m2.pokequizz.platform

@OptIn(kotlin.js.ExperimentalWasmJsInterop::class)
private fun normalizeNfd(value: String): String = js("value.normalize('NFD')")

actual fun String.removeDiacritics(): String =
    normalizeNfd(this).filterNot { it.category == CharCategory.NON_SPACING_MARK }
