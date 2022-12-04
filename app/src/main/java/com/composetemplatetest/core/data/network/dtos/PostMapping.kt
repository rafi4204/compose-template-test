package com.composetemplatetest.core.data.network.dtos

import com.composetemplatetest.core.domain.model.Post

fun PostDto.toEntity(): Post {
    return Post(
        id = id,
        title = title,
        body = body
    )
}