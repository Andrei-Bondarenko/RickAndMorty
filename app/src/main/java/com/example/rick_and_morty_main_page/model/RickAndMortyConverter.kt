package com.example.rick_and_morty_main_page.model

import com.example.rick_and_morty_main_page.api.model.LocationDataResponse
import com.example.rick_and_morty_main_page.api.model.OriginDataResponse
import com.example.rick_and_morty_main_page.api.model.ResultsListResponse

object RickAndMortyConverter {
    fun fromNetwork(response: List<ResultsListResponse?>?): List<ResultsList?>? {
        return response?.map { data ->
            ResultsList(
                id = data?.id,
                name = data?.name,
                status = data?.status,
                species = data?.species,
                type = data?.type,
                gender = data?.gender,
                origin = data?.origin?.let { fromNetwork(it) },
                location = data?.location?.let { fromNetwork(it) },
                image = data?.image,
                episode = data?.episode
            )
        }
    }

    private fun fromNetwork(response: OriginDataResponse?): OriginData? =
        OriginData(
            name = response?.name,
            url = response?.url
        )

    private fun fromNetwork(response: LocationDataResponse?): LocationData? =
        LocationData(
            name = response?.name,
            url = response?.url
        )
}