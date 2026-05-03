package com.aphamogged.pokedex.Screen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.aphamogged.pokedex.Componente.CardPokemon
import com.aphamogged.pokedex.Componente.Header
import com.aphamogged.pokedex.Componente.Pokebola
import com.aphamogged.pokedex.Componente.TentatNovamente
import com.aphamogged.pokedex.Componente.Voltar
import com.aphamogged.pokedex.Pokemon.PokemonViewModel
import com.aphamogged.pokedex.R
import com.aphamogged.pokedex.model.Pokemon
import com.aphamogged.pokedex.model.PokemonEspeciesGen
import com.aphamogged.pokedex.model.PokemonGen
import com.aphamogged.pokedex.model.TipoPokemon
import com.aphamogged.pokedex.service.RetrofitFactory
import kotlinx.coroutines.launch

@Composable
fun HomePokedex( navController: NavController, viewModel: PokemonViewModel,id : String) {

    var nomePokemon by remember{
        mutableStateOf("")
    }
    if (viewModel.pokemons.isEmpty()) {
        LaunchedEffect(id) {
            viewModel.listaPokemon(id)
        }
    }
      val  pokemons = viewModel.pokemons

    // Define a lista que será exibida
      val listaExibida = if (nomePokemon.trim().isNotEmpty()) {
             viewModel.pesquisaPokemon(nomePokemon)
            } else {
                  pokemons
            }

    Column(
        modifier= Modifier
            .fillMaxSize()
            .background(Color.White)
            .safeDrawingPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {

        if (viewModel.listaStatus == true && pokemons.isEmpty()) {
            Log.e("Estado", viewModel.listaStatus.toString())
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
        else if(viewModel.listaStatus == false ){
            TentatNovamente(){
                viewModel.listaPokemon(id)
            }
        }
        else {
            Header(navController)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)
                    .clip(shape = RoundedCornerShape(10.dp))
                    .border(width = 3.dp, color = Color.Red, shape = RoundedCornerShape(10.dp))
                    .background(Color.White),
                Arrangement.SpaceBetween
            ) {
                OutlinedTextField(
                    modifier = Modifier.weight(2f),
                    value = nomePokemon,
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,

                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black,

                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent
                    ),
                    onValueChange = {
                        nomePokemon = it
                    }
                )
                IconButton(
                    onClick = {
//                            pokemons = viewModel.pesquisaPokemon(nomePokemon)
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Pesquisar pokemon",
                        tint = Color.Red
                    )
                }
            }
        LazyVerticalGrid(
            modifier = Modifier.padding(10.dp),
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ){


            items(listaExibida.filter {
                it.numero != null
            }.sortedBy { it.numero?.toInt() }){

                if (!it.tipos.isNullOrEmpty()){
                val colorPokemon = TipoPokemon.valueOf("${it.tipos[0].type.name.uppercase()}");

                if (it.name != null && it.numero != null && it.img != null){
                    CardPokemon(nome = it.name,viewModel, numero = it.numero,cor = colorPokemon,img = it.img){
                        navController.navigate("pokemon/${it.numero}")
                    }
                  }
                }

            }
        }
        }
    }

}
