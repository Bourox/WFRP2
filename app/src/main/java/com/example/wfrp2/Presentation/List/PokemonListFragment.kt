package com.example.wfrp2.Presentation.List

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wfrp2.R
import com.example.wfrp2.Presentation.List.api.PokemonListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class PokemonListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    private val adapter= PokemonAdapter(listOf(), ::onClickedPokemon)

    private val layoutManager = LinearLayoutManager(context)
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pokemon_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.sommaire_recyclerview)

        adapter.listener
        recyclerView.apply {
            layoutManager = this@PokemonListFragment.layoutManager
            adapter = this@PokemonListFragment.adapter

        }

        Singletons.pokeApi.getPoKemonList().enqueue(object : Callback<PokemonListResponse>{

            override fun onFailure(call: Call<PokemonListResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<PokemonListResponse>, response: Response<PokemonListResponse>) {
                if(response.isSuccessful && response.body() !=null){
                    val pokemonListResponse : PokemonListResponse =response.body()!!
                    adapter.updateList(pokemonListResponse.results)

                }
            }

        })




    }
    private fun onClickedPokemon(pokemon: Pokemon) {
        findNavController().navigate(R.id.navigateToPokemonDetailFragment)
    }

}