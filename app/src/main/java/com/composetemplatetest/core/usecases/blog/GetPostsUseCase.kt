package com.composetemplatetest.core.usecases.blog

import com.composetemplatetest.arch.extensions.useCaseFlow
import com.composetemplatetest.core.data.repositories.PostRepository
import com.composetemplatetest.injection.qualifiers.DefaultDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetPostsUseCase @Inject constructor(
    private val postRepository: PostRepository,
    @DefaultDispatcher private val coroutineDispatcher: CoroutineDispatcher
) {
    fun getPosts() = useCaseFlow(coroutineDispatcher) {
        postRepository.getPosts()
    }
}