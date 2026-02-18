package com.oscarpino.api_pokemon.ui.pokemons.state

import com.oscarpino.domain.model.GenerationComplete
import com.oscarpino.domain.model.Pokemon

data class PokemonState(
    val pokemonList: List<Pokemon> = emptyList<Pokemon>(),
    val loading: Boolean = true,
    val error: Boolean = false,
    val generationComplete: GenerationComplete = GenerationComplete(0,emptyList()),
    val generationNames: List<String> = emptyList<String>()
)
