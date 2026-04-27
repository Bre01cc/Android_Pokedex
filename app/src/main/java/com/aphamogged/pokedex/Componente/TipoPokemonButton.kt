package com.aphamogged.pokedex.Componente

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight

@Composable
fun TipoPokemonButton(tipo: String, cor : Long) {
    Button(
        colors = ButtonDefaults.buttonColors(
            Color(cor)
        ),
        onClick = {}
    ) {
        Text(
            text = "$tipo",
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
    }
}