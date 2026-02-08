package com.oscarpino.data.api

import com.oscarpino.data.model.PokemonDetailResponse
import com.oscarpino.data.model.PokemonsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeApi {
    @GET("api/v2/generation/{path}/")
    suspend fun getPokemons(@Path("path") generationId:Int): Response<PokemonsResponse>

    @GET("api/v2/pokemon/{name}/")
    suspend fun getPokemonDetail(@Path("name") pokemonName:String): Response<PokemonDetailResponse>
}