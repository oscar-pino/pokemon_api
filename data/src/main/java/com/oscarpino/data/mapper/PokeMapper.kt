package com.oscarpino.data.mapper

import com.oscarpino.data.model.PokemonRemote
import com.oscarpino.domain.model.Pokemon

fun List<PokemonRemote>.toPokemon():List<Pokemon>{
    return this.map {
        Pokemon(name = it.name, image = "")
    }
}