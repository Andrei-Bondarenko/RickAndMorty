package com.example.rick_and_morty_main_page.ui.local_repository

import com.example.rick_and_morty_main_page.model.ResultsList
import com.example.rick_and_morty_main_page.ui.model.ParametersList
 interface LocalRepository {

    suspend fun getLocalData(page: Int): List<ParametersList?>

}