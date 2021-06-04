package com.kakadurf.hw_sem2.presentation.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kakadurf.hw_sem2.R
import com.kakadurf.hw_sem2.presentation.models.CharacterDTO
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.view_character.tv_character_name

class CharacterAdapter(
    private val itemList: List<CharacterDTO>,
    private val onClickListener: (String) -> Unit
) : RecyclerView.Adapter<SpotHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpotHolder {
        return SpotHolder.builder(
            parent
        ).also {
            it.onClickListener = onClickListener
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: SpotHolder, position: Int) {
        holder.bind(itemList[position])
    }
}

class SpotHolder(override val containerView: View) :
    RecyclerView.ViewHolder(containerView),
    LayoutContainer {
    var onClickListener: ((String) -> Unit)? = null

    companion object {
        fun builder(parent: ViewGroup): SpotHolder {
            return SpotHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.view_character,
                    parent,
                    false
                )
            )
        }
    }

    fun bind(characterDTO: CharacterDTO) {
        tv_character_name.text = characterDTO.name
        /*
        tv_tempr.text = characterDTO.id.toString()
        */
        itemView.setOnClickListener { onClickListener?.let { it1 -> it1(characterDTO.id) } }
    }
}
