package com.example.utils.ui

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private const val VISIBLE_THRESHOLD = 5

class EndlessScrollListener(
    private val layoutManager: LinearLayoutManager,
    private val loadNextPage: (totalItems: Int, page: Int) -> Unit,
) : RecyclerView.OnScrollListener() {

    private var isLoading = true
    private var totalLoadedItems = 0

    private var currentPage = 1

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        val visibleItemCount = layoutManager.childCount
        val totalItemCount = layoutManager.itemCount
        val firstVisibleItem = layoutManager.findFirstVisibleItemPosition()

        if (totalItemCount > totalLoadedItems) {
            isLoading = false
            totalLoadedItems = totalItemCount
            return
        }

        val shouldLoadMore = totalItemCount - visibleItemCount <= firstVisibleItem + VISIBLE_THRESHOLD
        if (!isLoading && shouldLoadMore) {
            currentPage++
            loadNextPage(totalItemCount, currentPage)
            isLoading = true
        }
    }

    fun reset() {
        isLoading = false
        totalLoadedItems = 0
        currentPage = 1
    }
}