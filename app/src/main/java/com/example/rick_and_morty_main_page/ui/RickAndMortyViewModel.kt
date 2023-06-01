package com.example.rick_and_morty_main_page.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rick_and_morty_main_page.interactor.RickAndMortyInteractor
import com.example.rick_and_morty_main_page.model.ResultsList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.concurrent.CancellationException

class RickAndMortyViewModel(
    private val interactor: RickAndMortyInteractor
) : ViewModel() {

    private val _rickAndMortyData = MutableStateFlow<List<ResultsList?>?>(null)
    val rickAndMortyData = _rickAndMortyData.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()


    fun getRickAndMortyData(characters: String) {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                val currencyInfoData = interactor.getCurrencyInfoData(characters)
                _rickAndMortyData.emit(currencyInfoData)
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