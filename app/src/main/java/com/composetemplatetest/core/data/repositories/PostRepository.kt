package com.composetemplatetest.core.data.repositories

import com.composetemplatetest.arch.data.Repository
import com.composetemplatetest.arch.extensions.mapSuccess
import com.composetemplatetest.core.data.network.Api
import com.composetemplatetest.core.data.network.dtos.toEntity
import com.composetemplatetest.core.data.storage.PostPreferenceStore
import com.composetemplatetest.core.domain.model.Post
import javax.inject.Inject

class PostRepository @Inject constructor(
    private val api: Api,
    private val postPreferenceStore: PostPreferenceStore
) : Repository() {

    suspend fun getPosts(): List<Post> {
        return api.getPosts()
            .mapSuccess { list -> list.map { it.toEntity() } }
            .also { postPreferenceStore.addAll(it) }
    }
}