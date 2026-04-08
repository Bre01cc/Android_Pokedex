package com.aphamogged.pokedex

import Screen.InicioPokedex
import android.R.attr.contentDescription
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.content.MediaType.Companion.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aphamogged.pokedex.ui.theme.PokedexTheme
import kotlin.io.encoding.Base64
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PokedexTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomePokedex(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun HomePokedex(modifier: Modifier = Modifier) {
    var nomePokemon by remember{
        mutableStateOf("")
    }
    Column(
        modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(206, 31, 31, 255))
            .padding(horizontal = 50.dp, vertical = 20.dp),

            horizontalArrangement = Arrangement.spacedBy(15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.pokebola),
                contentDescription = "Pokebola",
                modifier = Modifier.size(35.dp)
            )
            Text(
                text = "Pokédex",
                color = Color.White,
                fontSize = 32.sp
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .padding(horizontal = 10.dp)
                .border(width = 1.dp, Color.Red, shape = RoundedCornerShape(10.dp))
        ) {
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = nomePokemon,
                colors = TextFieldDefaults.colors(
                    Color.White,
                    Color.White,
                ),
                onValueChange = {
                 nomePokemon = it
                }
            )
            Button(
                onClick = {}
            ) {

            }


        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
        ) {

            Card() {
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                        Text(
                            text = "0009"
                        )

                    Image(
                        painter = painterResource(R.drawable.pokebola),
                        contentDescription = "Pokebola",
                        modifier = Modifier.size(35.dp)
                    )

                        Text(
                            text = "Nome",
                            color =
                        )

                }


            }
        }

    }

}
