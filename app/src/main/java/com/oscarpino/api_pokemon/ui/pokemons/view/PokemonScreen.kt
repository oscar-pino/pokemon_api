package com.oscarpino.api_pokemon.ui.pokemons.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.oscarpino.api_pokemon.ui.pokemons.intent.PokemonIntent
import com.oscarpino.api_pokemon.ui.pokemons.viewmodel.PokemonsViewModel
import javax.inject.Inject

@Composable
fun PokemonScreen(modifier:Modifier = Modifier, pokemonsViewModel: PokemonsViewModel = hiltViewModel()){


    //me fui a lo que llegue sigo, pero ya esta bien avanzado

    //le puse hasta inyeccion de dependencias, fijate estudealo

    val state = pokemonsViewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        pokemonsViewModel.sendIntent(PokemonIntent.GetPokemonsByGeneration(1))
    }

    Box(modifier = Modifier.fillMaxSize()) {
        LazyVerticalGrid(columns = GridCells.Fixed(3)) {
            items(items = state.value.pokemonList, itemContent = {
                PokemonItem()
            })
        }
    }
}