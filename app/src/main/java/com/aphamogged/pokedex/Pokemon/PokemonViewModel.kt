package com.aphamogged.pokedex.Pokemon

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.aphamogged.pokedex.model.Pokemon
import com.aphamogged.pokedex.service.RetrofitFactory
import kotlinx.coroutines.launch

class PokemonViewModel : ViewModel(){
   private var _pokemons by mutableStateOf(listOf<Pokemon>())
    val pokemons  get() = _pokemons


    fun listaPokemon(){
        viewModelScope.launch {
            try {
                var response = RetrofitFactory().getPokemonService().getPokemonByRegion()

              _pokemons = response


            }catch (e : Exception){
                Log.e("Errro", e.message ?: "")
            }
        }
    }
}