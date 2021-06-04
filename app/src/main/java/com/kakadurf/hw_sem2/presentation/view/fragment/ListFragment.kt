package com.kakadurf.hw_sem2.presentation.view.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.kakadurf.hw_sem2.R
import com.kakadurf.hw_sem2.presentation.models.CharacterDTO
import com.kakadurf.hw_sem2.presentation.view.adapters.CharacterAdapter
import com.kakadurf.hw_sem2.presentation.view.interfaces.ListView
import com.kakadurf.hw_sem2.presentation.view_model.CharacterViewModel
import kotlinx.android.synthetic.main.fragment_character_list.recyclerView_main
import kotlinx.android.synthetic.main.fragment_character_list.searchView_main

class ListFragment : Fragment(), ListView {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_character_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("hi", "observing")
        val viewModel = ViewModelProvider(this)
            .get(CharacterViewModel::class.java).apply {
                list.observe(
                    viewLifecycleOwner,
                    Observer {
                        onDataFetch(it)
                    }
                )
            }
        onChoice = {
            val action =
                ListFragmentDirections.actionListFragmentToExtendedCharacterInfoFragment(it)
            findNavController().navigate(action)
        }
        viewModel.findCharacters()
        searchView_main.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                val text = searchView_main.query.toString()
                viewModel.list.value?.find {
                    it.name.contains(text)
                }?.id?.let { onChoice(it) }
                    ?: Toast.makeText(activity, "no such character", Toast.LENGTH_LONG).show()
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
    }

    override fun onDataFetch(list: List<CharacterDTO>) {
        Log.d("hi", "onFetch")
        recyclerView_main.layoutManager = LinearLayoutManager(context)
        recyclerView_main.adapter =
            CharacterAdapter(list) { id: String ->
                onChoice(id)
            }
    }

    override fun onSearchDataFetch(id: String) {
        onChoice(id)
    }

    fun setOnClickListener(onChoice: (String) -> Unit) {
        this.onChoice = onChoice
    }

    private var onChoice: ((String) -> Unit) = {}
}
