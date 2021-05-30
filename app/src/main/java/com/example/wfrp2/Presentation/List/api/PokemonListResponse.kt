package com.example.wfrp2.Presentation.List.api

import com.example.wfrp2.Presentation.List.Pokemon


data class  PokemonListResponse(
    val count : Int,
    val next : String,
    val results : List<Pokemon>
)