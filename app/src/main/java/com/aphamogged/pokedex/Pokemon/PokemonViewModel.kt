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
import com.aphamogged.pokedex.model.PokemonResponse
import com.aphamogged.pokedex.model.PokemonSpecie
import com.aphamogged.pokedex.service.RetrofitFactory
import com.google.gson.Gson
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch
import kotlinx.serialization.descriptors.StructureKind

class PokemonViewModel : ViewModel(){
    private var _pokemons by mutableStateOf(emptyList<Pokemon>())
    val pokemons  get() = _pokemons


    private var _listaStatus by mutableStateOf(true)
    val listaStatus get() = _listaStatus

    private  var _pokemon by  mutableStateOf<Pokemon?>(null)

    val pokemon get() = _pokemon
    private var _imgPokemons by mutableStateOf(mutableListOf<String>())

    val imgPokemons get() = _imgPokemons



    fun listaPokemon(){
        viewModelScope.launch {
            try {
                var response = RetrofitFactory().getPokemonService().getPokemonByRegion("1")


                val lista =  response.pokemon_species.map{
                    async {
                        val numero = numberPokemon(it.url)

                        val pokemon =  buscarDadosPokemon(numero)
                        Log.e("Teste", pokemon!!.abilities.toString())
                        Pokemon(
                            numero = numero,
                            name = formatarNome(pokemon!!.forms!![0].name) ,
                            img = pokemon!!.sprites!!.front_default!!,
                            tipos = pokemon!!.types!!,
                            status = pokemon!!.stats!!,
                            weight = formatarNumeroPoke(pokemon!!.weight.toString()),
                            height = formatarNumeroPoke(pokemon!!.height.toString()),
                            abilities = pokemon!!.abilities
                        )
                    }
                }
                _listaStatus = false
                _pokemons = lista.awaitAll()

            }catch (e : Exception){
                Log.e("Erro", e.message ?: "Erro na requisição da geração")
            }
        }
    }

   suspend fun buscarDadosPokemon(numero: String): PokemonResponse?{
        return try {
            RetrofitFactory()
                .getPokemonService()
                .getDataByNumberPokemon(numero)

        }catch (e: Exception){
            Log.e("Teste", e.message ?: "Erro na requisição do pokemon")
            null
            }
        }

    suspend fun buscarDadosEspecie(numero: String): PokemonSpecie?{
        return try {
            RetrofitFactory()
                .getPokemonService()
                .getDataByNumberEspecies(numero)

        }catch (e: Exception){
            Log.e("Teste", e.message ?: "Erro na requisição do pokemon")
            null
        }
    }

    fun numberPokemon(url: String): String{
         return url.removeSuffix("/").split("/").last()
        }

    fun buscarPokemon(numero: String){
        viewModelScope.launch {
            try {
//                Log.e("Teste", numero)
                var dadosPokemon = buscarDadosPokemon(numero)
                var dadosEspecies = buscarDadosEspecie(numero)
                _pokemon = Pokemon(
                    name =formatarNome(dadosPokemon!!.forms!![0].name),
                    img = dadosPokemon!!.sprites.front_default,
                    numero = numero,
                    tipos = dadosPokemon!!.types,
                    status = dadosPokemon!!.stats,
                    weight = formatarNumeroPoke(dadosPokemon!!.weight.toString()),
                    height = formatarNumeroPoke(dadosPokemon!!.height.toString()),
                    abilities = dadosPokemon!!.abilities,
                    pokemonSpecie = dadosEspecies!!
                )
            }catch (e : Exception){
                Log.e("Teste", e.message ?: "Erro na busca do pokemon")
                }
            }

         }
    fun formatarNumeroPoke(numero: String) : String{
        var numeroDecimal = numero.toDouble()/100
        var  numeroFormatado = numeroDecimal.toString().replace(".",",")

        return  numeroFormatado
    }

    fun formatarNome(name : String): String{
        var nomeFormatado = name[0].uppercase() + name.substring(1)
        return  nomeFormatado
    }

    fun pesquisaPokemon (nome: String) : List<Pokemon>{
         return   _pokemons.filter {
                 pokemon ->
             pokemon.name.startsWith(nome,ignoreCase = true)
    }
    }
}








