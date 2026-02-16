package com.oscarpino.api_pokemon.ui.pokemons.intent

sealed interface PokemonIntent{

    data class GetPokemonsByGeneration(val generationId:Int): PokemonIntent
}