package com.example.rick_and_morty_main_page.interactor

import com.example.rick_and_morty_main_page.model.ResultsList
import com.example.rick_and_morty_main_page.repository.local_repository.MainLocalRepository
import com.example.rick_and_morty_main_page.repository.remote.RickAndMortyRemoteRepository
import kotlinx.coroutines.flow.Flow
import timber.log.Timber

class RickAndMortyInteractor (
    private val remoteRepository: RickAndMortyRemoteRepository,
    private val localRepository: MainLocalRepository
) {
    suspend fun getRickAndMortyData(): Flow<List<ResultsList>> {
        Timber.d("==================== LOX")
        return localRepository.getCharacters()
    }

    suspend fun insertDataToDb(page: Int) {
        Timber.d("==================== LOX")
        val characters = remoteRepository.getRickAndMortyData(page)
        localRepository.insertCharacters(characters)
    }
}