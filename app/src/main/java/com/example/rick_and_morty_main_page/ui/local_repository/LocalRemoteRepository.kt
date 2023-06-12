package com.example.rick_and_morty_main_page.ui.local_repository

import android.content.SharedPreferences
import com.example.rick_and_morty_main_page.api.RickAndMortyApi
import com.example.rick_and_morty_main_page.ui.model.ParametersList

class LocalRemoteRepository(
    private val sharedPreferences: SharedPreferences,
    private val api: RickAndMortyApi
)
//    : LocalRepository
{

//    override suspend fun getLocalData(page: Int): List<ParametersList?> {
//        val rickAndMortyData = api.getRickAndMortyData(page)
//        val editor = sharedPreferences.edit()
//         editor.apply {
//
//         }
//    }
}