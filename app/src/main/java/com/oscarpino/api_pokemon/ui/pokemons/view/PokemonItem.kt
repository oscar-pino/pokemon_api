package com.oscarpino.api_pokemon.ui.pokemons.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview
fun PokemonItem(){
    Box(modifier = Modifier.padding(2.dp)) {
        Card(modifier = Modifier.size(50.dp), colors = CardDefaults.cardColors(containerColor = Color.Red)) {
            Column { 

            }
        }
    }

}