package fr.m2.pokequizz

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Pokequizz",
    ) {
        App()
    }
}