package com.aphamogged.pokedex.model

data class PokemonEspeciesGen (
    val name: String,
    val url: String,
)

data class Pokemon(
    val name: String,
    val img: String,
    val numero: String
)

data class PokemonGen(
    val pokemon_species: List<PokemonEspeciesGen>
)

data class PokemonResponse(
    val sprites: Sprites
)

data class Sprites (
    val front_default: String
)
