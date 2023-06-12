package com.example.rick_and_morty_main_page.ui

import com.example.common.mvvm.BaseViewModel
import com.example.rick_and_morty_main_page.interactor.RickAndMortyInteractor
import com.example.rick_and_morty_main_page.model.ResultsList
import com.example.utils.ui.PagingState
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.concurrent.CancellationException

class RickAndMortyViewModel(
    private val interactor: RickAndMortyInteractor
) : BaseViewModel() {

    private var pagingJob: Job? = null
    private var paginationEnded: Boolean = false

    private val _rickAndMortyData = MutableStateFlow<List<ResultsList?>>(mutableListOf())
    val rickAndMortyData = _rickAndMortyData.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    private val _pagingState: MutableStateFlow<PagingState> = MutableStateFlow(PagingState.Idle)
    val pagingState = _pagingState.asStateFlow()

    private val _isResetScrollListener = MutableStateFlow(false)
    val isResetScrollListener = _isResetScrollListener.asStateFlow()

    private val _page = MutableStateFlow(1)

    init {
        getRickAndMortyData()
    }

    fun getRickAndMortyData() {
        if (paginationEnded) return
        _pagingState.value = PagingState.Loading
        pagingJob?.cancel()
        pagingJob = launch {
            try {
                _isLoading.value = true
                val characterData = interactor.getRickAndMortyData(_page.value)
                Timber.d("VIEWMODEL DATA ==========  $characterData")
                val list = _rickAndMortyData.value.toMutableList()
                list.addAll(characterData)
                _rickAndMortyData.value = list
            } catch (e: CancellationException) {
                Timber.e(e.message)
            } catch (t: Throwable) {
                Timber.e(t.message)
            } finally {
                _isLoading.value = false
                _pagingState.value = PagingState.Idle
            }
        }
    }

    fun setCurrentPage(page: Int) {
        _page.value = page
    }

}