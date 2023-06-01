package com.example.rick_and_morty_main_page.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.common.mvvm.BaseFragment
import com.example.rick_and_morty_main_page.ui.adapter.RickAndMortyAdapter
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.FragmentRickAndMortyMainPageBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class RickAndMortyFragment : BaseFragment(R.layout.fragment_rick_and_morty_main_page) {
    private val viewModel: RickAndMortyViewModel by viewModel()
    private lateinit var binding: FragmentRickAndMortyMainPageBinding
    private var character = " "

    private val adapter: RickAndMortyAdapter = RickAndMortyAdapter()

    private val layoutManager: LinearLayoutManager by lazy {
        LinearLayoutManager(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRickAndMortyMainPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {

            viewModel.getRickAndMortyData(characters = character)

            observe(viewModel.rickAndMortyData) { rickAndMortyData ->
                rickAndMortyData?.let { adapter.setData(it) }
            }

            observe(viewModel.isLoading) { isLoading ->
                progressBar.isVisible = isLoading
            }
        }
    }
}