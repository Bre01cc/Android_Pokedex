package com.aphamogged.pokedex.Componente

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage
import com.aphamogged.pokedex.Pokemon.PokemonViewModel
import com.aphamogged.pokedex.R

@Composable
fun CardPokemon(nome : String, numero: String , img: String , onClick: () -> Unit) {

        Card(
            modifier = Modifier
                .width(200.dp)
                .height(200.dp)
                .clickable { onClick() }
                .border(width = 1.dp, Color.Red, shape = RoundedCornerShape(10.dp)),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
        ) {
            Column(
                modifier = Modifier.fillMaxWidth()
                    .fillMaxHeight(),

                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    modifier = Modifier
                        .padding(horizontal = 5.dp)
                        .fillMaxWidth(),
                    textAlign = TextAlign.End,
                    text = "#$numero"
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    AsyncImage(
                        model = img,
                        contentDescription = null,
                        modifier = Modifier.size(120.dp)

                    )
                }
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp)
                        .background(Color.Red),
                    textAlign = TextAlign.Center,
                    text = "$nome",
                    fontSize = 16.sp,
                    color = Color.White
                )
            }

        }
    }
