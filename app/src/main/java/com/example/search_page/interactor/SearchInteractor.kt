package com.example.search_page.interactor

import com.example.rick_and_morty_main_page.model.ResultsList
import com.example.search_page.repository.SearchRepository

class SearchInteractor (
    private val searchRepository: SearchRepository
) {
    suspend fun getSearchedData(name: String): List<ResultsList?>? {
        return searchRepository.getSearchedData(name)
    }
}