package com.aphamogged.pokedex.Componente

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CardInfoPokemon(modifier: Modifier = Modifier) {
    Card (
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 45.dp, horizontal = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(15.dp)
            ) {
               TipoPokemon(cor = Color.White, tipo = "Grama")
                TipoPokemon(cor = Color.White, tipo = "Grama")

            }

            Text(
                text = "About",
                color = Color.Green,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Row(
                modifier = Modifier.fillMaxWidth().weight(0.190f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Column(
                    modifier = Modifier.fillMaxHeight().padding(top = 3.dp),
                    Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier
                    ) {
                        Text(
                            text =  "6,9 Kg",
                            color = Color.Black
                        )
                    }
                    Text(
                        text = "Weigtht",
                        color = Color.Black,
                        fontSize = 12.sp
                    )
                }
                SeparacaoLinha()
                Column(
                    modifier = Modifier.fillMaxHeight().padding(top = 3.dp),
                    Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row() {
                        Text(
                            text = "0,7 m",
                            color = Color.Black
                        )
                    }
                    Text(
                        text = "Height",
                        color = Color.Black,
                        fontSize = 12.sp
                    )
                }
                SeparacaoLinha()
                Column(
                    modifier = Modifier.fillMaxHeight().padding(top = 3.dp),
                    Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Chlorophyll",
                        color = Color.Black
                    )
                    Text(
                        text = "Overgraw",
                        color = Color.Black
                    )
                    Text(
                        text = "Moves",
                        color = Color.Black,
                        fontSize = 12.sp
                    )
                }
            }
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "There is a plant seed on its back right from the day this Pokémon is born. The seed slowly grows larger.",
                textAlign = TextAlign.Start,
                color = Color.Black
            )
            Column(
                modifier = Modifier.weight(0.525F),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Text(
                    text =  "Base Stats",
                    color = Color.Green,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp),
                    horizontalArrangement = Arrangement.spacedBy(5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier.fillMaxHeight(),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Texto(texto = "HP",Color.Green, tamanho = 16)
                        Texto(texto = "HP",Color.Green, tamanho = 16)
                        Texto(texto = "HP",Color.Green, tamanho = 16)
                        Texto(texto = "HP",Color.Green, tamanho = 16)
                        Texto(texto = "HP",Color.Green, tamanho = 16)
                        Texto(texto = "HP",Color.Green, tamanho = 16)

                    }
                    SeparacaoLinha()
                    Row() {
                        Column(
                            modifier = Modifier
                                .fillMaxHeight()
                                .weight(1F)
                                .padding(horizontal = 5.dp),
                            verticalArrangement = Arrangement.SpaceBetween
                        ) {
                            NivelAtributo(49)
                            NivelAtributo(49)
                            NivelAtributo(49)
                            NivelAtributo(49)
                            NivelAtributo(49)
                            NivelAtributo(49)


                        }

                    }
                }
            }
        }


    }
}