package fr.m2.pokequiz.ui

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import coil3.compose.AsyncImage
import fr.m2.pokequiz.resources.Res
import fr.m2.pokequiz.resources.mystery_pokemon
import fr.m2.pokequiz.resources.pokemon_artwork
import org.jetbrains.compose.resources.stringResource

internal fun pokemonImageSaturation(grayscale: Boolean): Float =
    if (grayscale) 0f else 1f

@Composable
fun PokemonImage(url: String, grayscale: Boolean, modifier: Modifier = Modifier) {
    val saturation by animateFloatAsState(
        targetValue = pokemonImageSaturation(grayscale),
        animationSpec = tween(durationMillis = 700),
        label = "saturation",
    )

    AsyncImage(
        model = url,
        contentDescription = stringResource(
            if (grayscale) Res.string.mystery_pokemon else Res.string.pokemon_artwork,
        ),
        colorFilter = ColorFilter.colorMatrix(
            ColorMatrix().apply { setToSaturation(saturation) },
        ),
        contentScale = ContentScale.Fit,
        modifier = modifier,
    )
}
