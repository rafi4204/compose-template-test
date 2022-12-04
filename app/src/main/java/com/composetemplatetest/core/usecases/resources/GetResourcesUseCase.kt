package com.composetemplatetest.core.usecases.resources

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.composetemplatetest.core.data.repositories.ResourceRepository
import com.composetemplatetest.core.pagination.db.AppDatabase
import com.composetemplatetest.core.pagination.mediator.ResourceMediator
import com.composetemplatetest.core.pagination.mediator.ResourceMediator.Companion.DEFAULT_PAGE_SIZE
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
class GetResourcesUseCase @Inject constructor(
    private val resourceRepository: ResourceRepository,
    private val appDatabase: AppDatabase,
) {
    operator fun invoke() =
        Pager(
            config = PagingConfig(pageSize = DEFAULT_PAGE_SIZE),
            remoteMediator = ResourceMediator(resourceRepository, appDatabase)
        ) {
            appDatabase.getResourceDao().getAllResources()
        }.flow

}