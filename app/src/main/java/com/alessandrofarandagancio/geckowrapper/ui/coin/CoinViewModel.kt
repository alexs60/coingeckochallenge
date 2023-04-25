package com.alessandrofarandagancio.geckowrapper.ui.coin

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.alessandrofarandagancio.geckowrapper.model.UICoin
import com.alessandrofarandagancio.geckowrapper.model.asViewModel
import com.alessandrofarandagancio.geckowrapper.repository.GeckoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class CoinViewModel @Inject constructor(private val geckoRepository: GeckoRepository) :
    ViewModel() {

    val coinListResponse: LiveData<List<UICoin>>
        get() = geckoRepository.getAllCoins().map {
            it.asViewModel()
        }

    fun refreshCoins() {
        viewModelScope.launch {
            try {
                geckoRepository.refreshCoins()
            } catch (networkError: IOException) {
            }
        }
    }

}
