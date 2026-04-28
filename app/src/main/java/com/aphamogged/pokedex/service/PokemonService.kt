package com.aphamogged.pokedex.service

import com.aphamogged.pokedex.model.PokemonGen
import com.aphamogged.pokedex.model.PokemonResponse
import com.aphamogged.pokedex.model.PokemonSpecie
import com.aphamogged.pokedex.model.Sprites
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonService {
    @GET("generation/{regiao}")
    suspend fun getPokemonByRegion(
        @Path(value = "regiao") regiao: String,
    ): PokemonGen

    @GET("pokemon/{numeroPokedex}")
    suspend fun getDataByNumberPokemon(
        @Path(value = "numeroPokedex") numeroPokedex: String,
    ): PokemonResponse

    @GET("pokemon-species/{numeroPokedex}")
    suspend fun getDataByNumberEspecies(
        @Path(value = "numeroPokedex") numeroPokedex: String,
    ): PokemonSpecie
}

