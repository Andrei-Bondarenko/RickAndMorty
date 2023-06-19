package com.example.rick_and_morty_main_page.db.model

import com.example.rick_and_morty_main_page.model.LocationData
import com.example.rick_and_morty_main_page.model.ResultsList
import okhttp3.internal.cacheGet

object DatabaseConverter {

    fun fromDatabase(characterEntity: List<CharacterEntity>) =
        characterEntity.map {
            ResultsList(
                id = it.id,
                name = it.name,
                status = it.status,
                species = it.species,
                type = it.type,
                gender = it.gender,
                origin = null,
                location = fromDatabase(it.location),
                image = it.image,
                episode = null
            )
        }

    fun toDatabase(characters: List<ResultsList?>) =
        characters.map {
            CharacterEntity(
                id = it?.id,
                name = it?.name,
                status = it?.status,
                species = it?.species,
                type = it?.type,
                image = it?.image,
                gender = it?.gender,
                location = it?.location?.name

            )
        }

    private fun fromDatabase(locationData: String?): LocationData {
        return LocationData(
            name = locationData,
            url = null
        )
    }

}