package com.kakadurf.hw_sem2.presentation.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.transition.TransitionInflater
import com.kakadurf.hw_sem2.R
import com.kakadurf.hw_sem2.databinding.FragmentExtendedInformationBinding
import com.kakadurf.hw_sem2.domain.Character
import com.kakadurf.hw_sem2.domain.Quote
import com.kakadurf.hw_sem2.presentation.view.adapters.QuotesAdapter
import com.kakadurf.hw_sem2.presentation.view_model.ExtendedScreenViewModel
import kotlinx.android.synthetic.main.fragment_extended_information.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class ExtendedCharacterInfoFragment:  Fragment(), CoroutineScope, ExtendedView{
    companion object{
        fun createIndexed(id: String): ExtendedCharacterInfoFragment {
            return ExtendedCharacterInfoFragment()
                .apply {
                arguments = Bundle().apply {putString("id",id)}
            }
        }
    }
    override val coroutineContext: CoroutineContext = Dispatchers.IO
    private var characterId: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedElementEnterTransition = (TransitionInflater.from(context).inflateTransition(R.transition.transition))

        characterId = arguments?.getString("id")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        binding =
            activity?.let { DataBindingUtil.setContentView(it, R.layout.fragment_extended_information) }
        return inflater.inflate(R.layout.fragment_extended_information,container,false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(this)
            .get(ExtendedScreenViewModel::class.java).apply {
            characterInfo.observe(viewLifecycleOwner, Observer {
                inflateCharacterData(it)
            })
            characterQuotes.observe(viewLifecycleOwner, Observer {
                inflateQuotesData(it)
            })
        }
        characterId?.let {
            viewModel.getCharacter(it)
            viewModel.getQuotes(it)
        }
    }
    @SuppressLint("SetTextI18n")
     override fun inflateCharacterData(character: Character){
        launch(Dispatchers.Main){
            character.let {
                binding?.character = it
            }
        }
    }
     override fun inflateQuotesData(quotes: List<Quote>){
        launch(Dispatchers.Main){
            rv_quotes.layoutManager = LinearLayoutManager(context)
            rv_quotes.adapter =
                QuotesAdapter(quotes)
        }
    }
    private var binding: FragmentExtendedInformationBinding ? = null
}