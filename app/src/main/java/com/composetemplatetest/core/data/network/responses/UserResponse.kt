package com.composetemplatetest.core.data.network.responses

import com.composetemplatetest.core.data.network.dtos.UserDto
import kotlinx.serialization.Serializable

@Serializable
data class UserResponse(
    val data: UserDto
)