package fr.m2.pokequizz

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.m2.pokequiz.data.FakePokemons
import org.jetbrains.compose.resources.painterResource

import fr.m2.pokequiz.resources.Res
import fr.m2.pokequiz.resources.app_name
import fr.m2.pokequiz.resources.compose_multiplatform
import fr.m2.pokequiz.ui.PokemonImage
import fr.m2.pokequiz.ui.theme.PokeQuizTheme
import org.jetbrains.compose.resources.stringResource


@Composable
@Preview
fun App() {
    PokeQuizTheme {
        var showContent by remember { mutableStateOf(false) }
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            var gray by remember { mutableStateOf(true) }
            Column {
                PokemonImage(FakePokemons.pikachu.imageUrl, grayscale = gray, modifier = Modifier.size(240.dp))
                Button(onClick = { gray = !gray }) { Text("Basculer") }
            }
        }
    }
}