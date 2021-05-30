package com.example.wfrp2.Presentation.List

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wfrp2.R
import java.util.logging.XMLFormatter

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
        val SommaireList : ArrayList<Categorie> = arrayListOf<Categorie>().apply {
            add(Categorie("Races"))
            add(Categorie("Carrières"))
            add(Categorie("Système de jeu"))
            add(Categorie("Reikland"))
        }
        adapter.updateList(SommaireList)
    }

}