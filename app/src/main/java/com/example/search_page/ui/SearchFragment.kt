package com.example.search_page.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.doOnAttach
import androidx.core.view.isVisible
import androidx.core.widget.doAfterTextChanged
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.common.mvvm.BaseFragment
import com.example.detailed_page.ui.DetailedFragment
import com.example.rick_and_morty_main_page.ui.adapter.RickAndMortyAdapter
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.FragmentSearchPageBinding
import com.example.search_page.ui.adapter.SearchAdapter
import com.example.utils.extentions.popScreen
import com.example.utils.extentions.replaceScreen
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class SearchFragment : BaseFragment(R.layout.fragment_search_page) {

    private val viewModel: SearchViewModel by viewModel()
    private lateinit var binding: FragmentSearchPageBinding
    private var name = ""

    private val adapter: SearchAdapter by lazy {
        SearchAdapter { item ->
            replaceScreen(DetailedFragment.newInstance(item))
            print(item)
        }
    }

    private val layoutManager: LinearLayoutManager by lazy {
        LinearLayoutManager(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun bind() {
        with(viewModel) {

            observe(viewModel.rickAndMortyData) { rickAndMortyData ->
                rickAndMortyData?.let { adapter.setData(it) }
                Timber.d("DATA =========>>>>>>>>> $rickAndMortyData")
            }
            observe(viewModel.isLoading) { isLoading ->
                binding.progressBar.isVisible = isLoading
            }
        }
    }


    override fun initViews(view: View) {
        with(binding) {

            toolBarSearchPageTitle.setNavigationOnClickListener {
                popScreen()
            }

            recyclerView.layoutManager = layoutManager
            recyclerView.setHasFixedSize(true)
            recyclerView.adapter = adapter
            recyclerView.doOnAttach {
                adapter.onAttachedToRecyclerView(recyclerView)

                nameEditText.doAfterTextChanged {
                    if (!nameEditText.text.isNullOrEmpty()) name = nameEditText.text.toString()
                    viewModel.getSearchedData(name)
                }

            }
        }
    }

        override fun onDestroyView() {
            super.onDestroyView()
            binding.recyclerView.layoutManager = null
        }
    }