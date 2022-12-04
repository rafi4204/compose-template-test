package com.composetemplatetest.core.usecases.user

import com.composetemplatetest.arch.extensions.useCaseFlow
import com.composetemplatetest.core.data.repositories.UserRepository
import com.composetemplatetest.injection.qualifiers.DefaultDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val userRepository: UserRepository,
    @DefaultDispatcher private val coroutineDispatcher: CoroutineDispatcher
) {

    fun login(email: String, password: String) =
        useCaseFlow(coroutineDispatcher) {
            userRepository.login(email, password)
            userRepository.getUser()
        }
}