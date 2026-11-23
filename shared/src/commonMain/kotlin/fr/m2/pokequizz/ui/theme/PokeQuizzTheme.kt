package fr.m2.pokequiz.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.unit.dp

private val PokedexRed = Color(0xFFDC0A2D)

private val LightColors = lightColorScheme(
    primary = PokedexRed,
    onPrimary = Color.White,
    primaryContainer = Color(0xFFFFDAD6),
    onPrimaryContainer = Color(0xFF410002),
    secondary = Color(0xFF3B4CCA),
    onSecondary = Color.White,
    secondaryContainer = Color(0xFFDEE0FF),
    onSecondaryContainer = Color(0xFF00105C),
    tertiary = Color(0xFFFFCB05),
    onTertiary = Color(0xFF2B2100),
    tertiaryContainer = Color(0xFFFFE28A),
    onTertiaryContainer = Color(0xFF241A00),
    background = Color(0xFFFFFBFF),
    onBackground = Color(0xFF201A1B),
    surface = Color(0xFFFFFBFF),
    onSurface = Color(0xFF201A1B),
    surfaceVariant = Color(0xFFF3DDDF),
    onSurfaceVariant = Color(0xFF514345),
    outline = Color(0xFF827477),
    error = Color(0xFFBA1A1A),
    onError = Color.White,
)

private val DarkColors = darkColorScheme(
    primary = Color(0xFFFFB3B7),
    onPrimary = Color(0xFF680014),
    primaryContainer = Color(0xFF93001F),
    onPrimaryContainer = Color(0xFFFFDAD6),
    secondary = Color(0xFFBFC3FF),
    onSecondary = Color(0xFF151B6B),
    secondaryContainer = Color(0xFF2E3587),
    onSecondaryContainer = Color(0xFFDEE0FF),
    tertiary = Color(0xFFE8C547),
    onTertiary = Color(0xFF3B2F00),
    tertiaryContainer = Color(0xFF564500),
    onTertiaryContainer = Color(0xFFFFE28A),
    background = Color(0xFF1A1112),
    onBackground = Color(0xFFF4DEDF),
    surface = Color(0xFF1A1112),
    onSurface = Color(0xFFF4DEDF),
    surfaceVariant = Color(0xFF514345),
    onSurfaceVariant = Color(0xFFD8C2C4),
    outline = Color(0xFFA08C8E),
    error = Color(0xFFFFB4AB),
    onError = Color(0xFF690005),
)

internal fun pokeQuizColorScheme(darkTheme: Boolean): ColorScheme =
    if (darkTheme) DarkColors else LightColors

object QuizColors {
    val Correct = Color(0xFF2E7D32)
    val Wrong = Color(0xFFC62828)
}

fun typeColor(type: String): Color = when (type) {
    "grass" -> Color(0xFF7AC74C)
    "fire" -> Color(0xFFEE8130)
    "water" -> Color(0xFF6390F0)
    // TODO : electric, normal, fairy, poison, psychic (+ les autres si vous voulez)
    else -> Color(0xFF9E9E9E)
}

fun onTypeColor(type: String): Color =
    if (typeColor(type).luminance() > 0.5f) Color.Black else Color.White

@Composable
fun PokeQuizTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colorScheme = pokeQuizColorScheme(darkTheme),
        typography = Typography(),
        shapes = Shapes(medium = RoundedCornerShape(16.dp)),
        content = content,
    )
}
