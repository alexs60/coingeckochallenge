package com.alessandrofarandagancio.geckowrapper.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.alessandrofarandagancio.geckowrapper.api.gecko.ApiHelper
import com.alessandrofarandagancio.geckowrapper.api.gecko.model.Coin
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class GeckoRepository @Inject constructor(
    private val apiHelper: ApiHelper
) {

    private var _coinsList = MutableLiveData<List<Coin>>()
    val coinsList: LiveData<List<Coin>> get() = _coinsList

    fun getAllCoins() = coinsList

    suspend fun refreshCoins() {
        withContext(Dispatchers.IO) {
            var coins = apiHelper.getAllCoins()
            withContext(Dispatchers.Main) {
                _coinsList.value = coins
            }
        }
    }

}