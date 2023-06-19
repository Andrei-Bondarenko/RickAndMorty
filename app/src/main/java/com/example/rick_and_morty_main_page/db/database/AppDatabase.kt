package com.example.rick_and_morty_main_page.db.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.rick_and_morty_main_page.db.dao.CharactersDao
import com.example.rick_and_morty_main_page.db.model.CharacterEntity

@Database(
    entities = [CharacterEntity::class], version = 1
)

abstract class AppDatabase: RoomDatabase() {

    abstract fun getCharacterDao(): CharactersDao

}