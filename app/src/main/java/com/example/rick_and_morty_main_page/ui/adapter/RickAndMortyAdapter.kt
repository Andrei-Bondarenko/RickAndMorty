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
import com.example.utils.ui.PagingState
import timber.log.Timber

class RickAndMortyAdapter(
    private val clickOnItem:(ResultsList?) -> Unit
) : RecyclerView.Adapter<RickAndMortyViewHolder>() {

    private var pagingState: PagingState = PagingState.Idle
    private val noAdditionalItemRequiredState = listOf(PagingState.Idle)

    private val data = mutableListOf<ResultsList?>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RickAndMortyViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.item_rick_and_morty_character, parent, false)
        return RickAndMortyViewHolder(parent, clickOnItem)
    }
    override fun onBindViewHolder(holder: RickAndMortyViewHolder, position: Int) {
        val listItem = data[position]
        holder.onBind(listItem)
    }

    override fun getItemViewType(position: Int): Int = when {
        !stateRequiresExtraItem(pagingState) || position < itemCount - 1 -> R.layout.item_rick_and_morty_character
        pagingState is PagingState.Loading || pagingState is PagingState.InitialLoading -> R.layout.item_progressbar
        else -> R.layout.item_error
    }

    override fun getItemCount() = data.size

    fun setPagingState(newState: PagingState) {
        if (pagingState::class.java == newState::class.java) return
        val shouldHasExtraItem = stateRequiresExtraItem(newState)
        val hasExtraItem = stateRequiresExtraItem(pagingState)

        pagingState = newState

        // since item count is a function - cache its value.
        val count = itemCount
        when {
            hasExtraItem && shouldHasExtraItem -> notifyItemChanged(count - 1)
            hasExtraItem && !shouldHasExtraItem -> notifyItemRemoved(count - 1)
            !hasExtraItem && shouldHasExtraItem -> notifyItemInserted(count)
        }
    }

    private fun stateRequiresExtraItem(state: PagingState) = state !in noAdditionalItemRequiredState



    @SuppressLint("NotifyDataSetChanged")
    fun setData(items: List<ResultsList?>) {
        data.addAll(items)
        notifyDataSetChanged()
    }

//    override fun getItemViewType(position: Int): Int = when {
//        !stateRequiresExtraItem(pagingState) || position < itemCount - 1 -> R.layout.item_list
//        pagingState is PagingState.Loading || pagingState is PagingState.InitialLoading -> R.layout.item_progressbar
//        else -> R.layout.item_error
//    }
}