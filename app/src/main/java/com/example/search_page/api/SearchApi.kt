package com.example.search_page.api

import com.example.rick_and_morty_main_page.api.model.RickAndMortyDataResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchApi {

    @GET("api/character")
    suspend fun getSearchedData(
        @Query("name") name: String
    ): RickAndMortyDataResponse?

}