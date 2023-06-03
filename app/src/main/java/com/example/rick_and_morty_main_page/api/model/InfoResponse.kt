package com.example.rick_and_morty_main_page.api.model

data class InfoResponse(
    val count: Int?,
    val pages: Int?,
    val next: String?,
    val prev: String?
)