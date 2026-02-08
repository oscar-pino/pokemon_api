package com.oscarpino.api_pokemon.ui.pokemons.view

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.oscarpino.domain.model.Pokemon

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun PokemonItem(pokemon: Pokemon) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .height(120.dp)
            .background(
                color = Color.Red.copy(alpha=.1f), shape = RoundedCornerShape(100.dp)
            )
            .border(width=2.dp, shape = RoundedCornerShape(100.dp), color=Color(0xFFE0E0E0))
            .padding(16.dp)

    ) {
        Text(
            text = pokemon.name.replaceFirstChar { it.uppercase() },
            fontSize = 20.sp,
            maxLines = 1,
            fontWeight = FontWeight.W700, //FontWeight.Medium
            color = Color(0xFFFDFCFC),
            fontFamily = FontFamily.SansSerif
        )
        GlideImage(
            model = pokemon.image,
            contentDescription = null,
            modifier = Modifier.size(200.dp)
        )
    }
}
