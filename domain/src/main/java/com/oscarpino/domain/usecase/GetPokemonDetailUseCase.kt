package com.oscarpino.domain.usecase

import com.oscarpino.common.BaseResponse
import com.oscarpino.common.BaseUseCaseWithParam
import com.oscarpino.domain.model.Pokemon
import com.oscarpino.domain.repository.PokeRepository
import javax.inject.Inject

class GetPokemonDetailUseCase @Inject constructor(private val repository: PokeRepository) :

    BaseUseCaseWithParam<Pokemon, BaseResponse<Pokemon>>() {

        override suspend fun execute(params: Pokemon): BaseResponse<Pokemon> {
        return repository.getpokemonDetail(params)
    }
}