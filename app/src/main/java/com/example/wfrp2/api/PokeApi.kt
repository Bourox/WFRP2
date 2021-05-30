package com.example.wfrp2.api

import retrofit2.Call
import retrofit2.http.GET




interface PokeApi {
    @GET("Pokemon")
    fun getPoKemonList(): Call<PokemonResponse>
}
