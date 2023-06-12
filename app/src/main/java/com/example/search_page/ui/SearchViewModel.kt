package com.example.search_page.ui

import androidx.lifecycle.viewModelScope
import com.example.common.mvvm.BaseViewModel
import com.example.rick_and_morty_main_page.model.ResultsList
import com.example.search_page.interactor.SearchInteractor
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.concurrent.CancellationException

class SearchViewModel(
    private val interactor: SearchInteractor
    ) : BaseViewModel() {


        private val _rickAndMortyData = MutableStateFlow<List<ResultsList?>?>(null)
        val rickAndMortyData = _rickAndMortyData.asStateFlow()

        private val _isLoading = MutableStateFlow(false)
        val isLoading = _isLoading.asStateFlow()


        fun getSearchedData(name: String) {
            viewModelScope.launch {
                try {
                    _isLoading.value = true
                    val searchedData = interactor.getSearchedData(name)
                    Timber.d("VIEWMODEL DATA ==========  $searchedData")
                    _rickAndMortyData.emit(searchedData)
                } catch (t: Throwable) {
                    Timber.e(t.message)
                } catch (e: CancellationException) {
                    Timber.e(e.message)
                } finally {
                    _isLoading.value = false
                }
            }
        }
    }