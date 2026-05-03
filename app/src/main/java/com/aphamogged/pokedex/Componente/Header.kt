package com.aphamogged.pokedex.Componente

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.aphamogged.pokedex.R
import com.aphamogged.pokedex.model.Status

@Composable
fun Header(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(206, 31, 31, 255))
            .padding(horizontal = 10.dp, vertical = 10.dp),

        horizontalArrangement = Arrangement.spacedBy(15.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Voltar(navController)
        Pokebola(35, R.drawable.pokebola, 1F)
        Text(
            text = "Pokédex",
            color = Color.White,
            fontSize = 32.sp
        )
    }
}