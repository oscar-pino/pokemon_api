package com.oscarpino.domain.usecase

import com.oscarpino.common.BaseResponse
import com.oscarpino.common.BaseUseCaseWithParam
import com.oscarpino.common.Params
import com.oscarpino.domain.model.Pokemon
import com.oscarpino.domain.repository.PokeRepository
import javax.inject.Inject

class GetAllPokemonsUseCase @Inject constructor(private val repository: PokeRepository):
    BaseUseCaseWithParam<Params, BaseResponse<List<Pokemon>>>(){

    override suspend fun execute(params: Params): BaseResponse<List<Pokemon>> {

        return repository.getPokemons(params.generationId)
    }
}