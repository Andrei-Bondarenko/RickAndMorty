package com.example.search_page.di

import com.example.common.InjectionModule
import com.example.rick_and_morty_main_page.api.RickAndMortyApi
import com.example.search_page.api.SearchApi
import com.example.search_page.interactor.SearchInteractor
import com.example.search_page.repository.SearchRemoteRepository
import com.example.search_page.repository.SearchRepository
import com.example.search_page.ui.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit

object SearchModule : InjectionModule {

    override fun create() = module {
        single { get<Retrofit>().create(SearchApi::class.java) }
        single { SearchRemoteRepository(get()) } bind SearchRepository::class
        factoryOf(::SearchInteractor)

        viewModelOf(::SearchViewModel)

    }
}