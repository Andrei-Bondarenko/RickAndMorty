package com.example.detailed_page.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.common.mvvm.BaseFragment
import com.example.rick_and_morty_main_page.model.ResultsList
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.FragmentDetailedPageBinding
import com.example.utils.Arguments
import com.example.utils.extentions.args
import com.example.utils.withArgs

class DetailedFragment: BaseFragment(R.layout.fragment_detailed_page) {

    private lateinit var binding: FragmentDetailedPageBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailedPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        fun newInstance(itemData: ResultsList) = DetailedFragment()
            .withArgs(Arguments.DETAILS to itemData)
    }

//    private val fiveDaysItemData: String? by args(Arguments.CITY_NAME)

}