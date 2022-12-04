package com.composetemplatetest.core.data.repositories

import com.composetemplatetest.arch.data.Repository
import com.composetemplatetest.arch.extensions.mapSuccess
import com.composetemplatetest.arch.extensions.repoCall
import com.composetemplatetest.core.data.network.Api
import com.composetemplatetest.core.data.network.dtos.toUser
import com.composetemplatetest.core.data.network.responses.TokenResponse
import com.composetemplatetest.core.data.storage.UserPreferenceStore
import com.composetemplatetest.core.domain.model.User
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val api: Api,
    private val userPreferenceStore: UserPreferenceStore
) : Repository() {

    suspend fun login(email: String, password: String): TokenResponse = repoCall {
        api.postLogin(email, password)
    }

    suspend fun getUser(): User {
        return api.getUser()
            .mapSuccess {
                it.data.toUser()
            }.also {
                userPreferenceStore.add(it)
            }
    }
}