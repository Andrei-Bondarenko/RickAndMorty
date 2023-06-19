package com.example.rick_and_morty_main_page.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "character")
data class CharacterEntity(
    @PrimaryKey
    val id: Int?,
    @ColumnInfo(name = "name")
    val name: String?,
    @ColumnInfo(name = "status")
    val status: String?,
    @ColumnInfo(name = "species")
    val species: String?,
    @ColumnInfo(name = "type")
    val type: String?,
    @ColumnInfo(name = "image")
    val image: String?,
    @ColumnInfo(name = "gender")
    val gender: String?,
    @ColumnInfo(name = "location")
    val location: String?
)
