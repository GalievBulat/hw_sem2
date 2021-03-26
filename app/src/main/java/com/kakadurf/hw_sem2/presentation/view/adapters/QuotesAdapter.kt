package com.kakadurf.hw_sem2.presentation.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kakadurf.hw_sem2.R
import com.kakadurf.hw_sem2.domain.Quote
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.view_quote.*

class QuotesAdapter(private val itemList : List<Quote>) : RecyclerView.Adapter<QuoteHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteHolder {
        return QuoteHolder.builder(
            parent
        )
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: QuoteHolder, position: Int) {
        holder.bind(itemList[position])
    }

}
class QuoteHolder( override val containerView: View) : RecyclerView.ViewHolder(containerView),
    LayoutContainer {
    companion object{
        fun builder(parent: ViewGroup) : QuoteHolder {
            return QuoteHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.view_quote,
                    parent,
                    false
                )
            )
        }
    }
    fun bind(q: Quote){
        tv_quote_text.text = q.text
    }

}