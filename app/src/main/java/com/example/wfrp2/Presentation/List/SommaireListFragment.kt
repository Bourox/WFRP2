package com.example.wfrp2.Presentation.List

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wfrp2.R
import com.example.wfrp2.api.PokeApi
import com.example.wfrp2.api.PokemonResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class SommaireListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    private val adapter= SommaireAdapter(listOf())

    private val layoutManager = LinearLayoutManager(context)
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sommaire_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.sommaire_recyclerview)
        recyclerView.apply {
            layoutManager = this@SommaireListFragment.layoutManager
            adapter = this@SommaireListFragment.adapter

        }

        val retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val pokeApi: PokeApi = retrofit.create(PokeApi::class.java)

        pokeApi.getPoKemonList().enqueue(object: Callback<PokemonResponse>{
            override fun onFailure(call: Call<PokemonResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<PokemonResponse>, response: Response<PokemonResponse>) {
                if(response.isSuccessful && response.body() !=null){
                    val pokemonResponse : PokemonResponse =response.body()!!
                    adapter.updateList(pokemonResponse.results)

                }
            }

        })




    }

}