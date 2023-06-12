package com.example.search_page.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rick_and_morty_main_page.model.ResultsList
import com.example.rickandmorty.R

class SearchAdapter(
    private val clickOnItem:(ResultsList?) -> Unit
) : RecyclerView.Adapter<SearchViewHolder>() {

    private val data = mutableListOf<ResultsList?>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.item_rick_and_morty_character, parent, false)
        return SearchViewHolder(parent, clickOnItem)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val listItem = data[position]
        holder.onBind(listItem)
    }

    override fun getItemCount() = data.size

    @SuppressLint("NotifyDataSetChanged")
    fun setData(items: List<ResultsList?>) {
        data.clear()
        data.addAll(items)
        notifyDataSetChanged()
    }
}