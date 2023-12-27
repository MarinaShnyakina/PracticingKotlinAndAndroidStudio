package com.example.practicingkotlinandandroidstudio.Words.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.*
import java.io.IOException

private const val LAYOUT_PREFERENCES_NAME = "layout_preferences"

val Context.dataStore : DataStore<Preferences> by preferencesDataStore(
    name = LAYOUT_PREFERENCES_NAME
)

class SettingsDataStore(context: Context) {
    private val IS_LINEAR_LAYOUT_MANAGER = booleanPreferencesKey("is_linear_layout_manager")

        val preferenceFlow: Flow<Boolean> = context.dataStore.data
            .catch {
                if (it is IOException) {
                    it.printStackTrace()
                    emit(emptyPreferences())
                } else {
                    throw  it
                }
            }
            .map { preferences ->
                preferences[IS_LINEAR_LAYOUT_MANAGER] ?: true
            } as Flow<Boolean>

    suspend fun saveLayoutToPreferencesStore(isLinearLayoutManager: Boolean, context: Context) {
        context.dataStore.edit { preferences ->
            preferences[IS_LINEAR_LAYOUT_MANAGER] = isLinearLayoutManager
        }
    }
}