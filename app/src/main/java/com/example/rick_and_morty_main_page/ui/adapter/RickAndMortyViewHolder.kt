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
    private val clickOnItem: (ResultsList?) -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    constructor(
        parent: ViewGroup, onClickItem: (ResultsList?) -> Unit
    ) : this(
    ItemRickAndMortyCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false),
    onClickItem
    )

    fun onBind(item: ResultsList?) {
        with(binding) {
            nameTextView.text = item?.name
            idTextView.text = item?.id?.toString()
            imageViewIconItem.load(item?.image) {
                crossfade(true)
                placeholder(R.drawable.reload_image)
                transformations(CircleCropTransformation())
            }
        }
    itemView.setOnClickListener {
        clickOnItem(item)
    }
    }

}