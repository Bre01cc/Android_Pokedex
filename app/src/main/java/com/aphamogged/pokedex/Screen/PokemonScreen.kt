package com.aphamogged.pokedex.Screen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.aphamogged.pokedex.Componente.CardInfoPokemon
import com.aphamogged.pokedex.Componente.Pokebola
import com.aphamogged.pokedex.Componente.Voltar
import com.aphamogged.pokedex.Pokemon.PokemonViewModel
import com.aphamogged.pokedex.R
import androidx.compose.runtime.LaunchedEffect
import com.aphamogged.pokedex.Componente.TentatNovamente
import com.aphamogged.pokedex.Componente.TipoPokemonButton
import com.aphamogged.pokedex.model.TipoPokemon

@Composable
fun PokemonPokedex(navController: NavController, viewModel: PokemonViewModel, id : Int) {

    if (viewModel.pokemon == null){
        LaunchedEffect(id) {
            viewModel.buscarPokemon(id.toString())
        }
    }
    val pokemon = viewModel.pokemon

    if (viewModel.listaStatus == true && pokemon == null) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    }
    else if(viewModel.listaStatus == false){
        TentatNovamente(){
            viewModel.buscarPokemon(id.toString())
        }
    }
    else{
        var colorPokemon by remember {
            mutableStateOf<TipoPokemon?>(TipoPokemon.UNKNOWN)
        }
        if(pokemon?.tipos != null){
            colorPokemon =  TipoPokemon.valueOf("${pokemon?.tipos[0]?.type?.name?.uppercase()}")
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .safeDrawingPadding()
                .background(Color(colorPokemon?.colorType ?: TipoPokemon.UNKNOWN.colorType))
                .padding(vertical = 10.dp),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .zIndex(0f),

                ){
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    Arrangement.End,
                    Alignment.Top,

                    ) {
                    Pokebola(280,R.drawable.pokebola_logo,0.5F)
                }

            }
            Column(
                modifier = Modifier.padding(vertical = 10.dp),
                verticalArrangement = Arrangement.spacedBy(50.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth()
                        .padding(horizontal = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Voltar(navController)
                        if (pokemon?.name != null){
                            Text(
                                text = "${pokemon.name}",
                                fontSize = 24.sp,
                                fontWeight = FontWeight(700),
                                color = Color.White
                            )
                        }
                    }
                    if (pokemon?.numero != null){
                        Text(
                            text = "#${pokemon.numero}",
                            fontSize = 20.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Start
                        )
                    }

                }
                Box(
                    modifier = Modifier.fillMaxWidth()
                        .padding(10.dp),
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .zIndex(999f)
                    ){
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Top
                        ) {
                            if (pokemon?.img != null){
                                AsyncImage(
                                    model = pokemon!!.img,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .width(225.dp)
                                        .zIndex(1f)
                                        .offset(
                                            y = -100.dp
                                        )
                                )
                            }
                        }
                    }
                    Box( modifier = Modifier.fillMaxWidth()
                        .padding(vertical = 35.dp)
                        .zIndex(1f)){
                        CardInfoPokemon(
                            pokemon!!,
                            colorPokemon?.colorType ?: TipoPokemon.UNKNOWN.colorType)
                    }
                }
            }
        }
    }

}