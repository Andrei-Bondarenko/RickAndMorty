package com.example.rick_and_morty_main_page.repository.local_repository

import com.example.rick_and_morty_main_page.db.model.CharacterEntity
import com.example.rick_and_morty_main_page.model.ResultsList
import kotlinx.coroutines.flow.Flow

interface LocalRepository {

    suspend fun getCharacters(): Flow<List<ResultsList>>

    suspend fun insertCharacters(characters: List<ResultsList?>)
}