package com.example.github_trending.data.utils

import kotlinx.coroutines.flow.*
import com.example.github_trending.domain.core.Resource

inline fun <ResultType, RequestType> networkBoundResource(
    crossinline query: () -> Flow<ResultType>,
    crossinline fetchFromApi: suspend () -> RequestType,
    crossinline saveFetchResult: suspend (RequestType) -> Unit,
    crossinline shouldFetch: (ResultType?) -> Boolean = { true }
) = flow {
    val data = query().firstOrNull()

    val flow = if (shouldFetch(data)) {
        try {
            val fetch = fetchFromApi()
            saveFetchResult(fetch)
            query().map { Resource.Success(it) }
        } catch (throwable: Throwable) {
            throwable.printStackTrace()
            query().map { Resource.Error(throwable, it) }
        }
    } else {
        query().map { Resource.Success(it) }
    }

    emitAll(flow)
}