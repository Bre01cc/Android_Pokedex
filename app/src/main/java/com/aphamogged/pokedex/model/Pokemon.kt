package com.aphamogged.pokedex.model

import android.R
import kotlinx.serialization.descriptors.StructureKind

//dados de uma geração
data class PokemonEspeciesGen (
    val name: String,
    val url: String,
)

// dados do pokemon
data class Pokemon(
    val name: String,
    val img: String,
    val numero: String,
    val abilities: List<AbilitySlot>,
    val tipos : List<Types>,
    val status : List<Status>,
    val height : String,
    val weight : String
)
//especies de pokemons de uma geração
data class PokemonGen(
    val pokemon_species: List<PokemonEspeciesGen>
)


// Resposta da busca pelo id do pokemon com seus dados
data class PokemonResponse(
    val sprites: Sprites,
    val forms : List<Forms>,
    val abilities: List<AbilitySlot>,
    val types : List<Types>,
    val stats : List<Status>,
    val height : Int,
    val weight : Int
)
data class AbilitySlot(
    val ability: Ability,
    val is_hidden: Boolean,
    val slot: Int
)
data class Ability(
    val name: String,
    val url: String
)

data class Forms(
    val name: String,
    val url : String
)

// Acessando objeto que guarda stat
data class Status(
    val base_stat : Int,
    val effort : Int,
    val stat : Stat
)

// Acessando objeto que guarda o nome do status
data class Stat (
    val name : String,
    val url : String
)

data class TypeInfo(
    val name : String,
    val url : String
)

// Acessando
data class Types(
    val slot : Int,
    val type: TypeInfo
)
data class Sprites (
    val front_default: String
)


data class PokemonEspicies(
    val flavor_text_entries: List<DescricaoGamesPoke>
)

data class DescricaoGamesPoke(
    val flavor_text : String
)
