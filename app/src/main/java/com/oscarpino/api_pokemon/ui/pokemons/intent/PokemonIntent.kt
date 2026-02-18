package com.oscarpino.api_pokemon.ui.pokemons.intent

import com.oscarpino.domain.model.Generation

sealed interface PokemonIntent{

    data object GetGenerationsIntent: PokemonIntent
    data class GetPokemonsByGeneration(val generation: Generation): PokemonIntent
}