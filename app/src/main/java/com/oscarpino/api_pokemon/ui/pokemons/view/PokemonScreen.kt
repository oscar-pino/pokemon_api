package com.oscarpino.api_pokemon.ui.pokemons.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.oscarpino.api_pokemon.ui.pokemons.intent.PokemonIntent
import com.oscarpino.api_pokemon.ui.pokemons.viewmodel.PokemonsViewModel

@Composable
fun PokemonScreen(
    modifier: Modifier = Modifier,
    pokemonsViewModel: PokemonsViewModel = hiltViewModel()
) {

    val state = pokemonsViewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        pokemonsViewModel.sendIntent(PokemonIntent.GetPokemonsByGeneration(1))
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            //.background(Color.LightGray.copy(alpha = 0.6f)),
            .background(Color(0xFFFF0303)),
            contentAlignment = Alignment.Center
    ) {


        LazyVerticalGrid(columns = GridCells.Fixed(3), modifier = Modifier.fillMaxSize().padding(4.dp), horizontalArrangement = Arrangement.spacedBy(2.dp)) {
            items(items = state.value.pokemonList, itemContent = { pokemon ->
                PokemonItem(pokemon)
            })
        }
    }
}

