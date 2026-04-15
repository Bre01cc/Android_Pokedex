package com.aphamogged.pokedex.Componente

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight

@Composable
fun TipoPokemon(tipo: String, cor : Color) {
    Button(onClick = {}) {
        Text(
            text = "$tipo",
            color = cor,
            fontWeight = FontWeight.Bold
        )
    }
}