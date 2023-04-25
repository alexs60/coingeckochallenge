package com.alessandrofarandagancio.geckowrapper.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import com.alessandrofarandagancio.geckowrapper.Settings
import com.alessandrofarandagancio.geckowrapper.datastore.SettingsSerializer
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class AppSettingsRepository @Inject constructor(
    @ApplicationContext private val context: Context,
    private val settingsSerializer: SettingsSerializer
) {

    private val Context.settingsDataStore: DataStore<Settings> by dataStore(
        fileName = "settings.pb",
        serializer = settingsSerializer
    )

}