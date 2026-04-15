package com.aphamogged.pokedex.Screen

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.aphamogged.pokedex.R

@Composable
fun PokemonPokedex(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green),
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
                Image(
                    painter = painterResource(R.drawable.pokebola_logo),
                    contentDescription = "Pokebola",
                    modifier = Modifier.size(280.dp),
                    alpha = 0.5f
                )
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
                    IconButton(
                        onClick = {
                            navController.popBackStack()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Voltar para home",
                            tint = Color.White,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                    Text(
                        text = "Pikachu",
                        fontSize = 24.sp,
                        fontWeight = FontWeight(700),
                        color = Color.White
                    )

                }
                Text(
                    text = "#001",
                    fontSize = 12.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Start
                )
            }
            Column(
                modifier = Modifier.fillMaxWidth()
                    .padding(10.dp)
                    .background(Color.Transparent),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(R.drawable.pokebola),
                    contentDescription = "Pokemon",
                    modifier = Modifier
                        .size(70.dp)
                        .zIndex(1f)
                        .offset(y = 20.dp),

                    )
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
                            Button(onClick = {}) {
                                Text(
                                    text = "Tipo1",
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            Button(onClick = {}) {
                                Text(
                                    text = "Tipo1",
                                    color = Color.White
                                )
                            }
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
                            Row(
                                modifier = Modifier.background(Color(229, 224, 224, 255)).width(1.dp).fillMaxHeight()
                            ) {}
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
                            Row(
                                modifier = Modifier.background(Color(229, 224, 224, 255)).width(1.dp).fillMaxHeight()
                            ) {}
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
                                    Text(
                                        text =  "HP",
                                        color = Color.Green
                                    )
                                    Text(
                                        text = "ATK",
                                        color = Color.Green
                                    )
                                    Text(
                                        text = "DEF",
                                        color = Color.Green
                                    )
                                    Text(
                                        text = "SATK",
                                        color = Color.Green
                                    )
                                    Text(
                                        text = "SDEF",
                                        color = Color.Green
                                    )
                                    Text(
                                        text = "SPD",
                                        color = Color.Green
                                    )
                                }
                                Row(
                                    modifier = Modifier.background(Color(229, 224, 224, 255)).width(1.dp).fillMaxHeight()
                                ) {}
                                Row() {
                                    Column(
                                        modifier = Modifier
                                            .fillMaxHeight()
                                            .weight(1F)
                                            .padding(horizontal = 5.dp),
                                        verticalArrangement = Arrangement.SpaceBetween
                                    ) {
                                        Row(
                                            verticalAlignment = Alignment.CenterVertically,
                                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                                        ) {
                                            Text(
                                                text = "045",
                                                color = Color.Black
                                            )
                                            Column(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .height(10.dp)
                                                    .clip(RoundedCornerShape(10.dp))
                                                    .background(Color.Green),
                                            ) {
                                                Column(
                                                    modifier = Modifier
                                                        .width(20.dp)
                                                        .background(Color.Green)
                                                        .fillMaxHeight()
                                                ) { }
                                            }
                                        }
                                        Row(
                                            verticalAlignment = Alignment.CenterVertically,
                                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                                        ) {
                                            Text(
                                                text = "045",
                                                color = Color.Black
                                            )
                                            Column(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .height(10.dp)
                                                    .clip(RoundedCornerShape(10.dp))
                                                    .background(Color(229, 224, 224, 255))
                                            ) {
                                                Column(
                                                    modifier = Modifier
                                                        .width(20.dp)
                                                        .background(Color.Green)
                                                        .fillMaxHeight()

                                                ) { }
                                            }
                                        }


                                    }

                                }
                            }
                        }
                    }


                }

            }
        }
    }
}