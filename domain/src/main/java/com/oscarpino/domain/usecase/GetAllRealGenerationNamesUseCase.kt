package com.oscarpino.domain.usecase

import com.oscarpino.common.BaseResponseV2
import com.oscarpino.domain.repository.PokeRepository
import javax.inject.Inject

class GetAllRealGenerationNamesUseCase @Inject constructor(private val repository: PokeRepository
)
{
}
