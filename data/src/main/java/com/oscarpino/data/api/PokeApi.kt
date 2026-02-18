package com.oscarpino.data.api

import com.oscarpino.common.Constants
import com.oscarpino.data.model.GenerationDetailResponse
import com.oscarpino.data.model.GenerationResponse
import com.oscarpino.data.model.PokemonDetailResponse
import com.oscarpino.data.model.PokemonsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeApi {

    @GET(Constants.ALL_POKEMONS_BY_NAME)
    suspend fun getPokemonDetail(@Path("name") pokemonName:String): Response<PokemonDetailResponse>

    @GET(Constants.ALL_GENERATIONS)
    suspend fun getAllGenerations(): Response<GenerationResponse>

    //@GET("api/v2/generation/{path}")
    @GET(Constants.ALL_POKEMONS_BY_GENERATION_ID)
    suspend fun getGenerationDetail(@Path("id") generationName:String):Response<GenerationDetailResponse>

    // ALL_POKEMONS_BY_GENERATION_ID="api/v2/generation/{id}/"
    @GET(Constants.ALL_POKEMONS_BY_GENERATION_ID)
    suspend fun getPokemons(@Path("id") generationId:String): Response<PokemonsResponse>
}

