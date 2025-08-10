package com.oscarpino.api_pokemon.di

import com.oscarpino.data.api.PokeApi
import com.oscarpino.data.repository.PokeRepositoryImpl
import com.oscarpino.domain.repository.PokeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DataModule {
    @Provides
    fun provideRepository(pokeApi: PokeApi): PokeRepository{
        return PokeRepositoryImpl(pokeApi)
    }
}