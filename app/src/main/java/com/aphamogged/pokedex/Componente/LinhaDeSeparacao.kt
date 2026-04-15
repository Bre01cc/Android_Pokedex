package com.aphamogged.pokedex.Componente

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SeparacaoLinha(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .background(Color(229, 224, 224, 255))
            .width(1.dp)
            .fillMaxHeight()
    ) {}
}