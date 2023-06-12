package com.example.search_page.repository

import com.example.rick_and_morty_main_page.api.RickAndMortyApi
import com.example.rick_and_morty_main_page.model.ResultsList
import com.example.rick_and_morty_main_page.model.RickAndMortyConverter
import com.example.search_page.api.SearchApi
import timber.log.Timber

class SearchRemoteRepository(
    private val api: SearchApi
): SearchRepository {
    override suspend fun getSearchedData(name: String): List<ResultsList?>? {
        val searchedData = api.getSearchedData(name)
        Timber.d("RICK AND MORTY DATA  ===== $searchedData")
        return RickAndMortyConverter.fromNetwork(searchedData?.results)
    }
}