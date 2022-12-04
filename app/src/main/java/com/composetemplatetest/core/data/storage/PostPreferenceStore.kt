package com.composetemplatetest.core.data.storage

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.composetemplatetest.arch.data.SharedPreferenceDataStore
import com.composetemplatetest.core.domain.model.Post
import javax.inject.Inject

class PostPreferenceStore @Inject constructor(
    dataStore: DataStore<Preferences>
) : SharedPreferenceDataStore<Post>(dataStore, Post.serializer())