package com.example.adae.interfaces

import android.telecom.Call
import retrofit2.http.GET

import com.example.adae.models.Pokemon

interface PokemonAPI {
    @GET("pokeapi.co/api/v2/")
    fun findPokedex()

    @GET("pokeapi.co/api/v2/pokemon/")
    fun findPokemon(id : String) : Call

    @GET("")
    fun findAttack(id : String) : Call
}