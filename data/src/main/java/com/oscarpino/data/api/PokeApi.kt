package com.oscarpino.data.api

import com.oscarpino.common.Constants
import com.oscarpino.data.model.PokemonDetailResponse
import com.oscarpino.data.model.PokemonsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeApi {

    @GET(Constants.ALL_POKEMONS_BY_GENERATION)
    suspend fun getPokemons(@Path("id") generationId:Int): Response<PokemonsResponse>

    @GET(Constants.ALL_POKEMONS_BY_NAME)
    suspend fun getPokemonDetail(@Path("name") pokemonName:String): Response<PokemonDetailResponse>
}