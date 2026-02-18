package com.oscarpino.api_pokemon.ui.pokemons.viewmodel

import androidx.lifecycle.viewModelScope
import com.oscarpino.api_pokemon.ui.pokemons.intent.PokemonIntent
import com.oscarpino.api_pokemon.ui.pokemons.intent.PokemonIntent.GetPokemonsByGeneration
import com.oscarpino.api_pokemon.ui.pokemons.state.PokemonState
import com.oscarpino.common.BaseResponseV2
import com.oscarpino.common.BaseResult
import com.oscarpino.common.BaseViewModel
import com.oscarpino.domain.model.GenerationComplete
import com.oscarpino.domain.model.Pokemon
import com.oscarpino.domain.usecase.GetAllPokemonsUseCase
import com.oscarpino.domain.usecase.GetGenerationCompleteUseCase
import com.oscarpino.domain.usecase.GetPokemonDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonsViewModel @Inject constructor(

    private val getAllPokemonsUseCase: GetAllPokemonsUseCase,
    private val getPokemonDetailUseCase: GetPokemonDetailUseCase,
    private val getGenerationCompleteUseCase: GetGenerationCompleteUseCase

) :
    BaseViewModel<PokemonState, PokemonIntent>() {

    override val initialState: PokemonState
        get() = PokemonState()

    override fun sendIntent(intent: PokemonIntent) {
        handleIntent(intent)
    }

    override fun handleIntent(intent: PokemonIntent) {
        when (intent) {
            is GetPokemonsByGeneration -> {
                getAllPokemons(intent.generation.name)
            }

            is PokemonIntent.GetGenerationsIntent -> {
               getGenerationComplete()
            }
        }
    }

    private fun getAllPokemons(generationName: String) {

        viewModelScope.coroutineContext.cancelChildren()

        viewModelScope.launch {

            _state.update {
                it.copy(pokemonList = emptyList())
            }


            val pokemonResponse =
                getAllPokemonsUseCase.execute(generationName)

            when (pokemonResponse) {

                is BaseResponseV2.BaseResultSuccessful -> {

                    pokemonResponse.result.forEach {  pokemon->
                        getPokemonDetail(pokemon)
                    }
                }

                else -> {

                }

            }
        }
    }

    private fun getGenerationComplete() {
        viewModelScope.launch {
            val response = getGenerationCompleteUseCase.execute()
            when (response) {
                is BaseResponseV2.BaseResultSuccessful<GenerationComplete> -> {

                    _state.update {
                        it.copy(
                           generationComplete = response.result
                        )
                    }
                }

                is BaseResponseV2.BaseError<GenerationComplete> -> {

                }
            }
        }
    }


    private fun getPokemonDetail(pokemon: Pokemon) {
        viewModelScope.launch {
            val response = getPokemonDetailUseCase.execute(pokemon)

            when (response.result) {
                BaseResult.SUCCESSFUL -> {
                    val pokemonResponse = response.payload

                    pokemonResponse?.let { pokemonRemote ->
                        _state.update {
                            it.copy(pokemonList = it.pokemonList + pokemonRemote)
                        }
                    }
                }

                else -> {

                }
            }
        }
    }
}