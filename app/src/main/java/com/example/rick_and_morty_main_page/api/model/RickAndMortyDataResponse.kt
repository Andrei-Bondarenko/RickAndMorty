package com.example.rick_and_morty_main_page.api.model


data class RickAndMortyDataResponse(
    val info: InfoResponse?,
    val results: List<ResultsListResponse?>?
)
