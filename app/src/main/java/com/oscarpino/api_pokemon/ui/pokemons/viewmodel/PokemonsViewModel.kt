package com.oscarpino.api_pokemon.ui.pokemons.viewmodel

import androidx.lifecycle.viewModelScope
import com.oscarpino.api_pokemon.ui.pokemons.intent.PokemonIntent
import com.oscarpino.api_pokemon.ui.pokemons.intent.PokemonIntent.GetPokemonsByGeneration
import com.oscarpino.api_pokemon.ui.pokemons.state.PokemonState
import com.oscarpino.common.BaseViewModel
import com.oscarpino.domain.usecase.GetAllPokemonsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonsViewModel @Inject constructor(private val getAllPokemonsUseCase: GetAllPokemonsUseCase) :
    BaseViewModel<PokemonState, PokemonIntent>() {

    override val initialState: PokemonState
        get() = PokemonState()

    override fun sendIntent(intent: PokemonIntent) {
        handleIntent(intent)
    }

    override fun handleIntent(intent: PokemonIntent) {
        when (intent) {
            is GetPokemonsByGeneration -> {
                getAllPokemons(intent.generationId)
            }
        }
    }

    private fun getAllPokemons(generationId: Int) {
        viewModelScope.launch {
            val response =
                getAllPokemonsUseCase.execute(GetAllPokemonsUseCase.Params(generationId = generationId))
        }
    }
}