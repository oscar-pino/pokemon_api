package com.oscarpino.api_pokemon.ui.pokemons.view

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.oscarpino.api_pokemon.ui.pokemons.intent.PokemonIntent
import com.oscarpino.api_pokemon.ui.pokemons.viewmodel.PokemonsViewModel
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.sp

@Composable
fun PokemonScreen(
    modifier: Modifier = Modifier,
    pokemonsViewModel: PokemonsViewModel = hiltViewModel()
) {

    val state by pokemonsViewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        pokemonsViewModel.sendIntent(PokemonIntent.GetPokemonsByGeneration(1))
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Red)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Yellow)
                .horizontalScroll(rememberScrollState())
                .padding(vertical = 30.dp)
                .padding(horizontal = 50.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            val generationNames = arrayListOf(
               // "Kanto",
                "pikoro",
                "Johto",
                "Hoenn",
                "Sinnoh",
                "Unova",
                "Kalos",
                "Alola",
                "Galar",
                "Paldea"
            )

            state.generationNames.forEach{

                Text(fontSize = 42.sp, text=it.replaceFirstChar { it.uppercase() },
                    modifier=Modifier.clickable {
                        pokemonsViewModel.sendIntent(PokemonIntent.GetPokemonsByGeneration(state.generationNames.indexOf(it)))
                    }.border(width = 3.dp, shape = RoundedCornerShape(100.dp), color=Color(0xFFE0E0E0)))


            }
        }

        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier
                .fillMaxSize()
                .padding(4.dp),
            horizontalArrangement = Arrangement.spacedBy(2.dp),
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            items(state.pokemonList) { pokemon ->
                PokemonItem(pokemon)
            }
        }
    }
}

