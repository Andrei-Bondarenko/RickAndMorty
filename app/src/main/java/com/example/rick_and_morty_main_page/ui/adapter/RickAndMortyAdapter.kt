package com.example.rick_and_morty_main_page.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.example.rick_and_morty_main_page.model.ResultsList
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.FragmentDetailedPageBinding

class RickAndMortyAdapter() : RecyclerView.Adapter<RickAndMortyViewHolder>(), View.OnClickListener {

    private val data = mutableListOf<ResultsList?>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RickAndMortyViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.item_rick_and_morty_character, parent, false)
        val inflater = LayoutInflater.from(parent.context)
        val binding = FragmentDetailedPageBinding.inflate(inflater, parent, false)
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

    override fun onClick(v: View?) {
//    val data = v?.tag as ResultsList?
//        when(v.)
    }
}