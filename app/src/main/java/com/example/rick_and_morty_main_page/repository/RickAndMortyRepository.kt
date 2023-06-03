package com.example.rick_and_morty_main_page.repository

import com.example.rick_and_morty_main_page.model.ResultsList

interface RickAndMortyRepository {
    suspend fun getRickAndMortyData(page: Int): List<ResultsList?>?
}