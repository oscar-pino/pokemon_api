package com.oscarpino.domain.repository

import com.oscarpino.common.BaseResponse
import com.oscarpino.domain.model.Pokemon

interface PokeRepository {
    suspend fun getPokemons(generationId:Int):BaseResponse<List<Pokemon>>
    suspend fun getpokemonDetail(pokemon: Pokemon): BaseResponse<Pokemon>
}
