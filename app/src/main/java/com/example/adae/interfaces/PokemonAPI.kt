package com.example.adae.interfaces

import retrofit2.Call
import com.example.adae.models.Pokemon
import retrofit2.http.GET
import retrofit2.http.Path


interface PokemonAPI {
    @GET("")
    fun findPokedex()

    @GET("pokemon/")
    fun findPokemon(id : String) : Call<List<Pokemon>>

    @GET("pokemon/{dexNumOrName}/")
    fun getPokemonByDexNumOrName(@Path("dexNumOrName") dexNumOrName: String?): Call<Pokemon>
}
