package com.oscarpino.api_pokemon.ui.pokemons.viewmodel

import androidx.lifecycle.viewModelScope
import com.oscarpino.api_pokemon.ui.pokemons.intent.PokemonIntent
import com.oscarpino.api_pokemon.ui.pokemons.intent.PokemonIntent.GetPokemonsByGeneration
import com.oscarpino.api_pokemon.ui.pokemons.state.PokemonState
import com.oscarpino.common.BaseResult
import com.oscarpino.common.BaseViewModel
import com.oscarpino.domain.model.Pokemon
import com.oscarpino.domain.usecase.GetAllPokemonsUseCase
import com.oscarpino.domain.usecase.GetPokemonDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.oscarpino.common.Params
import com.oscarpino.domain.usecase.GetAllGenerationNamesUseCase

@HiltViewModel
class PokemonsViewModel @Inject constructor(

    private val getAllPokemonsUseCase: GetAllPokemonsUseCase,
    private val getPokemonDetailUseCase: GetPokemonDetailUseCase,
    private val getAllGenerationNamesUseCase: GetAllGenerationNamesUseCase

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
                getAllPokemons(intent.generationId)
            }
        }
    }

    public fun getAllPokemons(generationId: Int) {

        viewModelScope.launch {

            val pokemonResponse =
                getAllPokemonsUseCase.execute(Params(generationId = generationId))

            val names = getAllGenerationNamesUseCase.getPGenerationNames()

            when (pokemonResponse.result) {

                BaseResult.SUCCESSFUL -> {

                    val pokemons = pokemonResponse.payload ?: emptyList()

                    _state.update { currentState ->
                        currentState.copy(
                            pokemonList = pokemons,
                            generationNames = names
                        )
                    }
                }

                else -> {
                    // Manejar error si quieres
                }
            }
        }
    }


    private fun getPokemonDetail(pokemon: Pokemon) {
        viewModelScope.launch {
            val response = getPokemonDetailUseCase.execute(pokemon)
            when(response.result){
                BaseResult.SUCCESSFUL -> {
                    val pokemonResponse = response.payload

                    pokemonResponse?.let { pokemonRemote->
                        _state.update {
                            it.copy(pokemonList = it.pokemonList.map {
                                if (it.name == pokemonRemote.name){
                                    it.copy(image = pokemonRemote.image)
                                }else{
                                    it.copy()
                                }
                            })
                        }
                    }
                }
                else -> {

                }
            }
        }
    }
}