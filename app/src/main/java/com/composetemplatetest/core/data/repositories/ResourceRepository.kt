package com.composetemplatetest.core.data.repositories

import com.composetemplatetest.arch.data.Repository
import com.composetemplatetest.arch.extensions.mapSuccess
import com.composetemplatetest.core.data.network.Api
import com.composetemplatetest.core.data.network.dtos.toEntity
import com.composetemplatetest.core.domain.model.ResourceDetails
import com.composetemplatetest.core.pagination.model.Resource
import javax.inject.Inject

class ResourceRepository @Inject constructor(
    private val api: Api,
) : Repository() {

    suspend fun getResources(page: Int, pageSize: Int): List<Resource> {
        return api.getResources(page, pageSize)
            .mapSuccess { response -> response.map { it.toEntity() } }
    }

    suspend fun getResourcesDetails(id: Int): ResourceDetails {
        return api.getResourcesDetails(id)
            .mapSuccess {
                it[0].toEntity()
            }
    }


}