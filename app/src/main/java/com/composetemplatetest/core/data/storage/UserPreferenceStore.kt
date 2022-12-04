package com.composetemplatetest.core.data.storage

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.composetemplatetest.arch.data.SharedPreferenceDataStore
import com.composetemplatetest.core.domain.model.User
import javax.inject.Inject

class UserPreferenceStore @Inject constructor(
    dataStore: DataStore<Preferences>
) : SharedPreferenceDataStore<User>(dataStore, User.serializer())