package com.oscarpino.data.repository

import com.oscarpino.common.BaseResponse
import com.oscarpino.common.BaseResult
import com.oscarpino.data.api.PokeApi
import com.oscarpino.data.mapper.toPokemon
import com.oscarpino.domain.model.Pokemon
import com.oscarpino.domain.repository.PokeRepository

class PokeRepositoryImpl(private val api: PokeApi): PokeRepository {
    override suspend fun getPokemons(generationId:Int): BaseResponse<List<Pokemon>> {
        return try{
            val response = api.getPokemons(generationId)

            when(response.code()){
                200-> {
                    response.body()?.let {
                        BaseResponse(it.pokemonSpecies.toPokemon(), BaseResult.SUCCESSFUL)

                    }?:run{
                        BaseResponse(null, BaseResult.ERROR)
                    }
                }
                else->{
                    BaseResponse(null, BaseResult.ERROR)
                }
            }
        } catch (e: Exception){
            BaseResponse(null, BaseResult.ERROR)

        }
    }
}