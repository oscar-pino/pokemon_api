package com.oscarpino.data.repository

import com.oscarpino.common.BaseResponse
import com.oscarpino.common.BaseResponseV2
import com.oscarpino.common.BaseResult
import com.oscarpino.data.api.PokeApi
import com.oscarpino.data.mapper.toPokemon
import com.oscarpino.domain.model.Generation
import com.oscarpino.domain.model.GenerationComplete
import com.oscarpino.domain.model.Pokemon
import com.oscarpino.domain.repository.PokeRepository

class PokeRepositoryImpl(private val api: PokeApi) : PokeRepository {

    override suspend fun getGenerations(): BaseResponseV2<GenerationComplete> {
        return try {
            val response = api.getAllGenerations()
            when (response.code()) {
                200 -> {
                    response.body()?.let {

                        BaseResponseV2.BaseResultSuccessful(
                            result = GenerationComplete(
                                count = it.count,
                                generations = it.results.map {
                                    Generation(
                                        name = it.name,
                                        realName = getGenerationDetail(it.name)
                                    )
                                }
                            )
                        )

                    } ?: run {
                        BaseResponseV2.BaseError(error = "payload nulo")
                    }
                }

                else -> {
                    BaseResponseV2.BaseError(error = "http code error")
                }
            }

        } catch (e: Exception) {
            BaseResponseV2.BaseError(error = e.toString())
        }
    }

    override suspend fun getPokemons(generationName: String): BaseResponseV2<List<Pokemon>> {

        return try {

            val response = api.getPokemons(generationName)

            when (response.code()) {
                200 -> {

                    response.body()?.let {
                        BaseResponseV2.BaseResultSuccessful(
                            result = it.pokemonSpecies.toPokemon()
                        )
                    } ?: run {
                        BaseResponseV2.BaseError(error = "payload null")
                    }
                }

                else -> {
                    BaseResponseV2.BaseError(error = "error http code")
                }
            }
        } catch (e: Exception) {
            BaseResponseV2.BaseError(error = e.message ?: "")
        }
    }

    override suspend fun getpokemonDetail(pokemon: Pokemon): BaseResponse<Pokemon> {
        return try {
            val response = api.getPokemonDetail(pokemon.name)
            when (response.code()) {
                200 -> {
                    response.body()?.let { pokemonRemote ->
                        val newPokemon = pokemon
                        newPokemon.apply {
                            image = pokemonRemote.sprite.front_default
                        }
                        BaseResponse(newPokemon, BaseResult.SUCCESSFUL)
                    } ?: run {
                        BaseResponse(null, BaseResult.ERROR)
                    }
                }

                else -> BaseResponse<Pokemon>(null, BaseResult.ERROR)
            }

        } catch (e: Exception) {
            BaseResponse<Pokemon>(null, BaseResult.ERROR)
        }
    }

    private suspend fun getGenerationDetail(
        generationName: String
    ): String {
        return try {
            val response = api.getGenerationDetail(generationName)

            when (response.code()) {
                200 -> {
                    response.body()?.let {
                        it.region.generationName.replaceFirstChar { it.uppercase() }
                    } ?: run {
                        ""
                    }
                }

                else -> {
                    ""
                }
            }
        } catch (e: Exception) {
            ""
        }
    }
}