package com.composetemplatetest.core.data.network.dtos

import com.composetemplatetest.core.domain.model.User

fun UserDto.toUser(): User {
    return User(
        email = email,
        firstName = firstName,
        lastName = lastName,
        avatar = avatar
    )
}