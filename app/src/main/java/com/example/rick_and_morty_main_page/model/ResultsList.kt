package com.example.rick_and_morty_main_page.model

data class ResultsList(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: OriginData,
    val location: LocationData,
    val image: String,
    val episode: List<String>,
)
