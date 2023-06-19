package com.example.rick_and_morty_main_page.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.common.mvvm.BaseFragment
import com.example.detailed_page.ui.DetailedFragment
import com.example.rick_and_morty_main_page.ui.adapter.RickAndMortyAdapter
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.FragmentRickAndMortyMainPageBinding
import com.example.search_page.ui.SearchFragment
import com.example.utils.extentions.replaceScreen
import com.example.utils.ui.EndlessScrollListener
import org.koin.androidx.viewmodel.ext.android.viewModel

class RickAndMortyFragment : BaseFragment(R.layout.fragment_rick_and_morty_main_page) {

    private val viewModel: RickAndMortyViewModel by viewModel()
    private lateinit var binding: FragmentRickAndMortyMainPageBinding

    private val adapter: RickAndMortyAdapter by lazy {
        RickAndMortyAdapter { item ->
            replaceScreen(DetailedFragment.newInstance(item))
            print(item)
        }
    }

    private val layoutManager: LinearLayoutManager by lazy {
        LinearLayoutManager(context)
    }

    private val scrollListener: EndlessScrollListener by lazy {
        EndlessScrollListener(layoutManager) { _, page ->
            viewModel.setCurrentPage(page)
            viewModel.getRickAndMortyData()
            viewModel.insertDataToDb(page)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRickAndMortyMainPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun bind() {
        with(viewModel) {

//            observe(viewModel.rickAndMortyData) { rickAndMortyData ->
//                rickAndMortyData?.let { adapter.setData(it) }
//                Timber.d("DATA =========>>>>>>>>> $rickAndMortyData")
//            }

            observe(listData) {
                adapter.setData(it)
            }

            observe(isLoading) { isLoading ->
                binding.progressBar.isVisible = isLoading
            }

            observe(pagingState) { pagingState ->
                adapter.setPagingState(pagingState)
            }

            observe(isResetScrollListener) { isReset ->
                if (isReset) scrollListener.reset()
            }
        }
    }


    override fun initViews(view: View) {
        with(binding) {
            recyclerView.layoutManager = layoutManager
            recyclerView.setHasFixedSize(true)
            recyclerView.adapter = adapter
            adapter.onAttachedToRecyclerView(recyclerView)
            recyclerView.addOnScrollListener(scrollListener)
            searchPageTextView.setOnClickListener {
                replaceScreen(SearchFragment())
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.recyclerView.layoutManager = null
    }

}