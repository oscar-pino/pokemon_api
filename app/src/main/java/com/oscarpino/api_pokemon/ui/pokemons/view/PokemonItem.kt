package com.oscarpino.api_pokemon.ui.pokemons.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.oscarpino.api_pokemon.ui.theme.orange
import com.oscarpino.domain.model.Pokemon

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun PokemonItem(pokemon: Pokemon) {
    Card(colors = CardDefaults.cardColors(containerColor = Color.White)) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = pokemon.name.replaceFirstChar { it.uppercase() },
                fontSize = 22.sp,
                maxLines = 1,
                fontWeight = FontWeight.Medium,
                color = orange,
                fontFamily = FontFamily.Default
            )
            GlideImage(
                model = pokemon.image,
                contentDescription = null,
                modifier = Modifier.size(200.dp),
                contentScale = ContentScale.Crop
            )
        }
    }
}
