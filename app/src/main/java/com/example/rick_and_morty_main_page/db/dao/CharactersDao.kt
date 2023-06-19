package com.example.rick_and_morty_main_page.db.dao

import androidx.room.*
import com.example.rick_and_morty_main_page.db.model.CharacterEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CharactersDao {

    @Query("SELECT * FROM character")
    fun getAll(): Flow<List<CharacterEntity>>

    @Insert(entity = CharacterEntity::class, onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(characters: List<CharacterEntity>)



}