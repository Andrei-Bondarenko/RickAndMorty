package com.example.rick_and_morty_main_page.repository.local_repository

import com.example.rick_and_morty_main_page.db.dao.CharactersDao
import com.example.rick_and_morty_main_page.db.model.DatabaseConverter
import com.example.rick_and_morty_main_page.model.ResultsList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import timber.log.Timber

class MainLocalRepository(
    private val charactersDao: CharactersDao
) : LocalRepository {

    override suspend fun getCharacters(): Flow<List<ResultsList>> {
        Timber.d("==================== LOX")
        val characters = charactersDao.getAll()
        return characters.map { DatabaseConverter.fromDatabase(it) }
    }

    override suspend fun insertCharacters(characters: List<ResultsList?>) {
        Timber.d("==================== LOX")
        val characterEntity = DatabaseConverter.toDatabase(characters)
        charactersDao.insertAll(characterEntity)
    }
}