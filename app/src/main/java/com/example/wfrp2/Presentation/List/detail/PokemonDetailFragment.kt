package com.example.wfrp2.Presentation.List.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.wfrp2.Presentation.List.Singletons
import com.example.wfrp2.Presentation.List.api.PokemonDetailResponse
import com.example.wfrp2.Presentation.List.api.PokemonListResponse
import com.example.wfrp2.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class PokemonDetailFragment : Fragment() {
    private lateinit var  textViewName: TextView

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pokemon_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textViewName= view.findViewById(R.id.pokemon_detail_name)
        callApi()
        }

    private fun callApi() {
        Singletons.pokeApi.getPokemonDetail("1").enqueue(object : Callback<PokemonDetailResponse>{
            override fun onFailure(
                call: Call<PokemonDetailResponse>,
                t: Throwable) {

            }

            override fun onResponse(
                call: Call<PokemonDetailResponse>,
                response: Response<PokemonDetailResponse>
            ) {
                if(response.isSuccessful && response.body() !=null){
                    textViewName.text = response.body()!!.name
                }
            }

        })

        }
}
