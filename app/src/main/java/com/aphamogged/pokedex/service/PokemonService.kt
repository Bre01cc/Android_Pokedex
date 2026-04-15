package com.aphamogged.pokedex.service

import com.aphamogged.pokedex.model.Pokemon
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonService {
    @GET("https://pokeapi.co/api/v2/pokemon/?offset=0&limit=10")
    suspend fun getPokemonByRegion(
//        @Path(value = "inicio") inicio: String,
//        @Path(value = "fim") fim: String
    ): List<Pokemon>
}

