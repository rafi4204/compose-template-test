package com.composetemplatetest.core.data.network.dtos

import com.composetemplatetest.core.pagination.model.Resource

fun ResourceDto.toEntity(): Resource {
    return Resource(
        id = id,
        name = name
    )
}