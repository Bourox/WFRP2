package com.example.wfrp2.api

import com.example.wfrp2.Presentation.List.Pokemon


data class  PokemonResponse(
    val count : Int,
    val next : String,
    val results : List<Pokemon>
)