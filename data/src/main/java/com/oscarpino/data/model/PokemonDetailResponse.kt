package com.oscarpino.data.model

import com.google.gson.annotations.SerializedName

data class PokemonDetailResponse(
    val specie: SpecieResponse,
    @SerializedName("sprites") val sprite: SpritResponse
)