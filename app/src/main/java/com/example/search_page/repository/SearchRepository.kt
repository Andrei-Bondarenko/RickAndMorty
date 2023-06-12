package com.example.search_page.repository

import com.example.rick_and_morty_main_page.model.ResultsList

interface SearchRepository {
    suspend fun getSearchedData(name: String): List<ResultsList?>?
}