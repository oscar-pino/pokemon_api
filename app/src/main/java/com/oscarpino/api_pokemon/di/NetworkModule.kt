package com.oscarpino.api_pokemon.di

import com.oscarpino.common.Constants
import com.oscarpino.common.NetworkFactory
import com.oscarpino.data.api.PokeApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun provideRetrofit(): Retrofit {
        return NetworkFactory.makeRetrofit(Constants.BASE_URL)
    }

    @Provides
    fun provideApiService(retrofit: Retrofit): PokeApi {
        return retrofit.create(PokeApi::class.java)
    }
}