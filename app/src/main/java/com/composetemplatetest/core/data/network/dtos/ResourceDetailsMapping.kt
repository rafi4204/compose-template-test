package com.composetemplatetest.core.data.network.dtos

import com.composetemplatetest.core.domain.model.ResourceDetails

fun ResourceDetailsDto.toEntity(): ResourceDetails {
    return ResourceDetails(
        id = id,
        name = name,
        imageUrl = imageUrl
    )
}