package com.example.rick_and_morty_main_page.interactor

import com.example.rick_and_morty_main_page.model.ResultsList
import com.example.rick_and_morty_main_page.repository.RickAndMortyRepository

class RickAndMortyInteractor (
    private val RickAndMortyRepository: RickAndMortyRepository,
) {
    suspend fun getCurrencyInfoData(characters: String): List<ResultsList> {
        return RickAndMortyRepository.getRickAndMortyData(characters)
    }
}