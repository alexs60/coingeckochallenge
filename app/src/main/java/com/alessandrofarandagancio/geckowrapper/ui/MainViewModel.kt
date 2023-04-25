package com.alessandrofarandagancio.geckowrapper.ui

import androidx.lifecycle.ViewModel
import com.alessandrofarandagancio.geckowrapper.repository.AppSettingsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val appSettingsRepository: AppSettingsRepository) :
    ViewModel() {

}