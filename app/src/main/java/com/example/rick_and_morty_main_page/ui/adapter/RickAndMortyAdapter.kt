package com.example.rick_and_morty_main_page.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rick_and_morty_main_page.model.ResultsList
import com.example.rickandmorty.R

class RickAndMortyAdapter() : RecyclerView.Adapter<RickAndMortyViewHolder>() {

    private val data = mutableListOf<ResultsList?>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RickAndMortyViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.item_rick_and_morty_character, parent, false)
        return RickAndMortyViewHolder(parent)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: RickAndMortyViewHolder, position: Int) {
        val listItem = data[position]
        holder.onBind(listItem)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(items: List<ResultsList?>) {
        data.clear()
        data.addAll(items)
        notifyDataSetChanged()
    }
}