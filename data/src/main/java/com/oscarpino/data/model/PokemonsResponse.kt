package com.oscarpino.data.model

import com.google.gson.annotations.SerializedName

data class PokemonsResponse(@SerializedName("pokemon_species") val pokemonSpecies:List<PokemonRemote>)