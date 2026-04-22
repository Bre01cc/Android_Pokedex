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
import com.aphamogged.pokedex.model.PokemonEspeciesGen
import com.aphamogged.pokedex.model.PokemonGen
import com.aphamogged.pokedex.service.RetrofitFactory
import com.google.gson.Gson
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch

class PokemonViewModel : ViewModel(){
    private var _pokemons by mutableStateOf(emptyList<Pokemon>())
    val pokemons  get() = _pokemons

    private var _imgPokemons by mutableStateOf(mutableListOf<String>())

    val imgPokemons get() = _imgPokemons


     fun listaPokemon(){
        viewModelScope.launch {
            try {
                var response = RetrofitFactory().getPokemonService().getPokemonByRegion("1")


              val lista =  response.pokemon_species.map{
                  async {
                      val numero = numberPokemon(it.url)

                      val img = try {
                          var sprites = RetrofitFactory()
                              .getPokemonService()
                              .getDataByNumberPokemon(numero)
                          sprites.sprites.front_default
                      }catch (e: Exception){
                          Log.e("Errro", e.message ?: "Erro na requisição da imagem")
                      }

                      Pokemon(
                          numero = numero,
                          name = it.name,
                          img = img.toString()
                      )
                  }
                }

                _pokemons = lista.awaitAll()

            }catch (e : Exception){
                Log.e("Errro", e.message ?: "Erro na requisição da geração")
            }
        }
    }
    fun numberPokemon(url: String): String{
       return url.removeSuffix("/").split("/").last()
    }

}

