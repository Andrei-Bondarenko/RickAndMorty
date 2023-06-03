package com.example.rick_and_morty_main_page.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.example.rick_and_morty_main_page.model.ResultsList
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.ItemRickAndMortyCharacterBinding

class RickAndMortyViewHolder(
    private val binding: ItemRickAndMortyCharacterBinding,
) : RecyclerView.ViewHolder(binding.root) {
    constructor(parent: ViewGroup) : this(
        ItemRickAndMortyCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    fun onBind(item: ResultsList?) {

        val description = item?.name

        with(binding) {
            nameTextView.text = item?.name
            statusTextView.text = item?.status
            speciesTextView.text = item?.species
            genderTextView.text = item?.gender
            locationTextView.text = item?.location?.name
            imageViewIconItem.load(item?.image) {
                crossfade(true)
                placeholder(R.drawable.reload_image)
                transformations(CircleCropTransformation())
            }
        }
    }
}