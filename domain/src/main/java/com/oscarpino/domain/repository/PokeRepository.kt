package com.oscarpino.domain.repository

import com.oscarpino.common.BaseResponse
import com.oscarpino.common.BaseResponseV2
import com.oscarpino.domain.model.GenerationComplete
import com.oscarpino.domain.model.Pokemon

interface PokeRepository {
    suspend fun getGenerations(): BaseResponseV2<GenerationComplete>
    suspend fun getPokemons(generationName:String): BaseResponseV2<List<Pokemon>>
    suspend fun getpokemonDetail(pokemon: Pokemon): BaseResponse<Pokemon>


}
