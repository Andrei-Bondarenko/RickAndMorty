package com.example.rick_and_morty_main_page.repository

import com.example.rick_and_morty_main_page.api.RickAndMortyApi
import com.example.rick_and_morty_main_page.model.ResultsList
import com.example.rick_and_morty_main_page.model.RickAndMortyConverter
import timber.log.Timber

class RickAndMortyRemoteRepository (
    private val api: RickAndMortyApi
): RickAndMortyRepository {


    override suspend fun getRickAndMortyData(characters: String): List<ResultsList> {
        val rickAndMortyData = api.getRickAndMortyData(characters)
        Timber.d("RICK AND MORTY DATA  ===== $rickAndMortyData")
        return RickAndMortyConverter.fromNetwork(rickAndMortyData.resultsList)
    }

}