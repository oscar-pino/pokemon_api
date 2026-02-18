package com.oscarpino.api_pokemon.ui.pokemons.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.oscarpino.api_pokemon.ui.pokemons.intent.PokemonIntent
import com.oscarpino.api_pokemon.ui.pokemons.viewmodel.PokemonsViewModel
import com.oscarpino.api_pokemon.ui.theme.orangeDark
import com.oscarpino.domain.model.Generation

@Composable
fun PokemonScreen(
    modifier: Modifier = Modifier,
    pokemonsViewModel: PokemonsViewModel = hiltViewModel()
) {

    val state by pokemonsViewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        pokemonsViewModel.sendIntent(PokemonIntent.GetGenerationsIntent)
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = orangeDark)
    ) {

        Generations(
            generations = state.generationComplete.generations,
            onClickGeneration = { generation->
                pokemonsViewModel.sendIntent(PokemonIntent.GetPokemonsByGeneration(generation))
            }
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            itemsIndexed(state.pokemonList) { index, pokemon ->
                PokemonItem(pokemon)
            }
        }
    }
}


@Composable
fun Generations(
    generations: List<Generation>,
    onClickGeneration: (Generation) -> Unit
) {
    val state = rememberLazyListState()
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        items(
            items = generations,
            itemContent = { generation ->
                Button(
                    shape = RoundedCornerShape(16.dp),
                    onClick = {
                        onClickGeneration(generation)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.primary,RoundedCornerShape(16.dp))
                        .padding(8.dp)
                ) {
                    Text(
                        color = Color.White,
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center,
                        text = generation.realName
                    )
                }
            }
        )
    }
}

