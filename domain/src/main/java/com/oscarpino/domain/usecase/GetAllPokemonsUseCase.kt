package com.oscarpino.domain.usecase

import com.oscarpino.common.BaseResponse
import com.oscarpino.common.BaseUseCaseWithParam
import com.oscarpino.domain.model.Pokemon
import com.oscarpino.domain.repository.PokeRepository
import javax.inject.Inject

class GetAllPokemonsUseCase @Inject constructor(private val repository: PokeRepository): BaseUseCaseWithParam<GetAllPokemonsUseCase.Params, BaseResponse<List<Pokemon>>>(){

    data class Params(val generationId:Int)

    override suspend fun execute(params: Params): BaseResponse<List<Pokemon>> {
        return repository.getPokemons(params.generationId)
    }
}