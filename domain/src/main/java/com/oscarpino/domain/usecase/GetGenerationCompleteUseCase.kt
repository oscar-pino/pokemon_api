package com.oscarpino.domain.usecase

import com.oscarpino.common.BaseResponseV2
import com.oscarpino.common.BaseUseCase
import com.oscarpino.domain.model.GenerationComplete
import com.oscarpino.domain.repository.PokeRepository
import javax.inject.Inject

class GetGenerationCompleteUseCase @Inject constructor(private val repository: PokeRepository):
    BaseUseCase<BaseResponseV2<GenerationComplete>>(){

    override suspend fun execute(): BaseResponseV2<GenerationComplete> {
        return repository.getGenerations()
    }
}