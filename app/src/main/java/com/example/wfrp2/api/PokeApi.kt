package com.example.wfrp2.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface PokeApi {
    @GET("pokemon")
    fun getPoKemonList() :Call<PokemonResponse>
}
