package com.oscarpino.domain.usecase

import com.oscarpino.domain.repository.PokeRepository
import javax.inject.Inject

class GetAllGenerationNamesUseCase @Inject constructor(private val repository: PokeRepository)

    {

    var names: MutableList<String> = mutableListOf()

        suspend fun getPGenerationNames(): List<String> {

            (1 until 10).forEach {

               names.add(repository.getGenerationName(it).payload?.generationName.toString())
            }

            return names
        }
    }