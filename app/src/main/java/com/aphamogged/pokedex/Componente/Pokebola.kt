package com.aphamogged.pokedex.Componente

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.aphamogged.pokedex.R

@Composable
fun Pokebola(tamanho: Int) {
    Image(
        painter = painterResource(R.drawable.pokebola),
        contentDescription = "Pokebola",
        modifier = Modifier.size(tamanho.dp)
    )
}