package com.example.rick_and_morty_main_page.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.doOnAttach
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.common.mvvm.BaseFragment
import com.example.rick_and_morty_main_page.ui.adapter.RickAndMortyAdapter
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.FragmentRickAndMortyMainPageBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class RickAndMortyFragment : BaseFragment(R.layout.fragment_rick_and_morty_main_page) {

    private val viewModel: RickAndMortyViewModel by viewModel()
    private lateinit var binding: FragmentRickAndMortyMainPageBinding
    private var page = 1

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

            binding.recyclerView.doOnAttach {
                binding.recyclerView.layoutManager = layoutManager
            }

            viewModel.getRickAndMortyData(page)


            observe(viewModel.rickAndMortyData) { rickAndMortyData ->
                rickAndMortyData?.let { adapter.setData(it) }
                Timber.d("DATA =========>>>>>>>>> $rickAndMortyData")
            }

            observe(viewModel.isLoading) { isLoading ->
                progressBar.isVisible = isLoading
            }

            recyclerView.setHasFixedSize(true)
            recyclerView.adapter = adapter
            adapter.onAttachedToRecyclerView(recyclerView)
            buttonNextPage.setOnClickListener {
                if (page == 42) Toast.makeText(
                    context,
                    "You are on the last page",
                    Toast.LENGTH_SHORT
                ).show()
                else {
                    page++
                    viewModel.getRickAndMortyData(page)
                }
            }
            buttonPreviousPage.setOnClickListener {
                if (page == 1) Toast.makeText(
                    context,
                    "You are on the first page",
                    Toast.LENGTH_SHORT
                ).show()
                else {
                    page--
                    viewModel.getRickAndMortyData(page)
                }
            }
        }
    }

    override fun onDestroyView() {
        binding.recyclerView.layoutManager = null
        super.onDestroyView()
    }

}