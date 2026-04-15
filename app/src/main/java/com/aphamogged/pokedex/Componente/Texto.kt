package com.aphamogged.pokedex.Componente

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp

@Composable
fun Texto(texto: String, cor:Color, tamanho:Int) {
    Text(
        text =  "${texto}",
        color = cor,
        fontSize = tamanho.sp
    )
}