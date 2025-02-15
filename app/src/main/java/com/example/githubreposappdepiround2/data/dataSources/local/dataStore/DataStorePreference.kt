package com.example.githubreposappdepiround2.data.dataSources.local.dataStore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.example.githubreposappdepiround2.data.Constants.Companion.PREFERENCES_IS_FIRST_TIME
import com.example.githubreposappdepiround2.data.Constants.Companion.PREFERENCES_NAME
import kotlinx.coroutines.flow.first

class DataStorePreference(private val context: Context) {
    private val isFirstTimeKey = booleanPreferencesKey(PREFERENCES_IS_FIRST_TIME)
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
        name = PREFERENCES_NAME
    )

    suspend fun saveIsFirstTimeEnterApp(isFirstTime:Boolean){
        context.dataStore.edit { mutablePreferences ->
            mutablePreferences[isFirstTimeKey] = isFirstTime
        }
    }

    suspend fun readIsFirstTimeEnterApp(): Boolean {
        return context.dataStore.data.first()[isFirstTimeKey] ?: true
    }
}