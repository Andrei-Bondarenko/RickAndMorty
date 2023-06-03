package com.example.rick_and_morty_main_page.api.model

data class ResultsListResponse(
    val id: Int?,
    val name: String?,
    val status: String?,
    val species: String?,
    val type: String?,
    val gender: String?,
    val origin: OriginDataResponse?,
    val location: LocationDataResponse?,
    val image: String?,
    val episode: List<String>?,
)
