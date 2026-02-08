package com.oscarpino.data.mapper

import com.oscarpino.data.model.PokemonDetailResponse
import com.oscarpino.domain.model.PokemonDetail

fun PokemonDetailResponse.toPokemonDetail(): PokemonDetail{

    return PokemonDetail(
        name=this.specie.name,
        url=this.specie.url,
        front_default=this.sprite.front_default,
        front_shiny=this.sprite.front_shiny,
        back_default=this.sprite.back_default,
        back_shiny=this.sprite.back_shiny
    )
}