package com.example.rick_and_morty_main_page.repository

import com.example.rick_and_morty_main_page.api.RickAndMortyApi
import com.example.rick_and_morty_main_page.model.ResultsList
import com.example.rick_and_morty_main_page.model.RickAndMortyConverter
import timber.log.Timber

class RickAndMortyRemoteRepository (
    private val api: RickAndMortyApi
): RickAndMortyRepository {


    override suspend fun getRickAndMortyData(page: Int): List<ResultsList?>? {
        val rickAndMortyData = api.getRickAndMortyData(page)
        Timber.d("RICK AND MORTY DATA  ===== $rickAndMortyData")
        return RickAndMortyConverter.fromNetwork(rickAndMortyData?.results)
    }

}