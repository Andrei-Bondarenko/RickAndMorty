package com.example.rick_and_morty_main_page.interactor

import com.example.rick_and_morty_main_page.model.ResultsList
import com.example.rick_and_morty_main_page.repository.RickAndMortyRepository

class RickAndMortyInteractor (
    private val rickAndMortyRepository: RickAndMortyRepository,
) {
    suspend fun getRickAndMortyData(page: Int): List<ResultsList?> {
        return rickAndMortyRepository.getRickAndMortyData(page)
    }
}