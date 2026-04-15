package com.aphamogged.pokedex.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.aphamogged.pokedex.Componente.Pokebola
import com.aphamogged.pokedex.R
import com.aphamogged.pokedex.model.Pokemon

@Composable
fun InicioPokedex(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(233, 30, 99, 255)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(70.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Busque seus Pokemons",
                fontSize = 32.sp,
                color = Color.White
            )

            Pokebola(125, R.drawable.pokebola,1F)

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 80.dp),
                Arrangement.SpaceBetween
            ) {
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        navController.navigate("home")
                    },
                    colors = ButtonDefaults.buttonColors(
                        Color(43, 134, 175, 255)
                    ),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(
                        text = "Iniciar",
                        fontSize = 16.sp,
                        color = Color.White
                    )
                }

            }
        }



    }
}