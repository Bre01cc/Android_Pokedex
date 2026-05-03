package com.aphamogged.pokedex.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.aphamogged.pokedex.Componente.Header
import com.aphamogged.pokedex.Pokemon.PokemonViewModel
import com.aphamogged.pokedex.R
import com.aphamogged.pokedex.model.Regiao

@Composable
fun Regioes(navController: NavController, viewModel: PokemonViewModel) {

    val regioes = listOf(
        Regiao("Kanto", R.drawable.kanto, Color(0xFFEF5350)),
        Regiao("Johto", R.drawable.johto, Color(0xFFFFD54F)),
        Regiao("Hoenn", R.drawable.hoenn, Color(0xFF2ECC71)),
        Regiao("Sinnoh", R.drawable.sinnoh, Color(0xFF616161)),
        Regiao("Unova", R.drawable.unova, Color(0xFF212121)),
        Regiao("Kalos", R.drawable.kalos, Color(0xFF1E88E5)),
        Regiao("Alola", R.drawable.alola, Color(0xFF5C6BC0)),
        Regiao("Galar", R.drawable.galar, Color(0xFFEF5350)),
        Regiao("Paldea", R.drawable.paldea, Color(0xFFD32F2F))
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .safeDrawingPadding(),
        verticalArrangement = Arrangement.spacedBy(35.dp)
    ){
         Header(navController)

        LazyVerticalGrid(
            modifier = Modifier.padding(10.dp),
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ){

            items(9){
                index ->
                Card(
                    modifier = Modifier
                        .width(200.dp)
                        .height(200.dp)
                        .clickable {
                            navController.navigate("home/${(index+1).toString()}")
                        }
                        .border(width = 1.dp, regioes[index].cor, shape = RoundedCornerShape(10.dp)),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth()
                            .fillMaxHeight(),

                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(regioes[index].img) ,
                                contentDescription = null,
                                modifier = Modifier.size(170.dp)

                            )
                        }
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(30.dp)
                                .background(regioes[index].cor),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "${regioes[index].nome}",
                                fontSize = 16.sp,
                                color = Color.White
                            )
                        }

                    }

                }
            }
        }
    }

}