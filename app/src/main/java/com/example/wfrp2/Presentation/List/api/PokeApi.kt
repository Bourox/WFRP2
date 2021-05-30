package com.example.wfrp2.Presentation.List.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface PokeApi {
    @GET("pokemon")
    fun getPoKemonList() :Call<PokemonListResponse>

    @GET("pokemon/{id}")
    fun getPokemonDetail(@Path("id") id: String): Call<PokemonDetailResponse>
}
