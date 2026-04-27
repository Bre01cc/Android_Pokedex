package com.aphamogged.pokedex.Componente

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.aphamogged.pokedex.model.AbilitySlot
import com.aphamogged.pokedex.model.Pokemon

@Composable
fun Status(pokemon: Pokemon, cor : Long) {
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
            Texto(texto = "HP",Color(cor), tamanho = 16)
            Texto(texto = "ATK",Color(cor), tamanho = 16)
            Texto(texto = "DEF",Color(cor), tamanho = 16)
            Texto(texto = "SATK",Color(cor), tamanho = 16)
            Texto(texto = "SDEF",Color(cor), tamanho = 16)
            Texto(texto = "SPD",Color(cor), tamanho = 16)

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
                pokemon.status.forEach {
                    NivelAtributo(it.base_stat,cor)
                }
            }

        }
    }
}