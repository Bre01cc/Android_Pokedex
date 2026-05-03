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
    private var _tentarNovamente by mutableStateOf(false)

    val tentarNovamente get() = _tentarNovamente
    private  var _pokemon by  mutableStateOf<Pokemon?>(null)

    val pokemon get() = _pokemon

    private var _imgPokemons by mutableStateOf(mutableListOf<String>())
    fun listaPokemon(numero: String){
        viewModelScope.launch {
            try {
                if (numero != null && numero.toInt() > 0 && numero != "") {
                    _listaStatus = true
                    var response = RetrofitFactory().getPokemonService().getPokemonByRegion(numero)

                if (response != null ) {

                    val lista = response.pokemon_species.map {
                        async {
                            val numero = numberPokemon(it.url)

                            val pokemon = buscarDadosPokemon(numero)

                            Pokemon(
                                numero = numero,
                                name = formatarNome(pokemon?.forms[0]?.name ?: ""),
                                img = pokemon?.sprites?.front_default ?: "",
                                tipos = pokemon?.types ?: emptyList(),
                                status = pokemon?.stats ?: emptyList(),
                                weight = formatarNumeroPoke(pokemon?.weight?.toString() ?: "0"),
                                height = formatarNumeroPoke(pokemon?.height?.toString() ?: "0"),
                                abilities = pokemon?.abilities ?: emptyList()
                            )
                        }
                    }
                    _pokemons = lista.awaitAll()
                }
                }else{
                    _listaStatus = false
                }

                Log.e("Estado",listaStatus.toString())

            }catch (e : Exception){
                _listaStatus = false
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
                if (numero != null && numero.toInt() > 0 && numero != ""){

                _listaStatus = true

                var dadosPokemon = buscarDadosPokemon(numero)

                var dadosEspecies = buscarDadosEspecie(numero)

                    if (dadosEspecies != null && dadosPokemon != null){

                    var descricao = formatarDescricao(
                        dadosEspecies!!
                            .flavor_text_entries[0]
                            .flavor_text)

                     _pokemon = Pokemon(
                    name =formatarNome(dadosPokemon!!.forms!![0].name),
                    img = dadosPokemon!!.sprites.front_default,
                    numero = numero,
                    tipos = dadosPokemon!!.types,
                    status = dadosPokemon!!.stats,
                    weight = formatarNumeroPoke(dadosPokemon!!.weight.toString()),
                    height = formatarNumeroPoke(dadosPokemon!!.height.toString()),
                    abilities = dadosPokemon!!.abilities,
                    descricao = descricao
                     )}
                }
                else{
                    _listaStatus = false
                }
            }catch (e : Exception){
                _listaStatus = false
                Log.e("Teste", e.message ?: "Erro na busca do pokemon")
                }
            }
         }

    fun formatarDescricao(texto : String) : String{
       return texto.replace("\n", " ").replace("POKéMON","")
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
             pokemon.name!!.startsWith(nome,ignoreCase = true)
    }
    }
}








