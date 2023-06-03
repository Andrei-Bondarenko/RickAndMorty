package com.example.rick_and_morty_main_page.api

import com.example.rick_and_morty_main_page.api.model.RickAndMortyDataResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RickAndMortyApi {

    @GET("api/character")
    suspend fun getRickAndMortyData(
        @Query("page") page: Int
    ): RickAndMortyDataResponse?
}