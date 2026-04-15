package com.aphamogged.pokedex.Componente

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun Voltar(navController: NavController) {
    IconButton(
        onClick = {
            navController.popBackStack()
        }
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Voltar para inicio",
            tint = Color.White,
            modifier = Modifier.size(30.dp)
        )
    }
}