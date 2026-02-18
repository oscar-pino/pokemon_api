package com.oscarpino.domain.usecase

import com.oscarpino.common.BaseResponseV2
import com.oscarpino.common.BaseUseCaseWithParam
import com.oscarpino.domain.model.Pokemon
import com.oscarpino.domain.repository.PokeRepository
import javax.inject.Inject

class GetAllPokemonsUseCase @Inject constructor(private val repository: PokeRepository)
    :BaseUseCaseWithParam<String, BaseResponseV2<List<Pokemon>>>(){

    override suspend fun execute(params: String): BaseResponseV2<List<Pokemon>> {
        return repository.getPokemons(params)
    }
}