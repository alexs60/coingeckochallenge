package com.alessandrofarandagancio.geckowrapper.api.gecko

import com.alessandrofarandagancio.geckowrapper.api.gecko.model.Coin
import com.alessandrofarandagancio.geckowrapper.api.gecko.model.Ping
import retrofit2.Call
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper {

    override suspend fun getAllCoins(): List<Coin> {
        return apiService.getAllCoins()
    }

    override suspend fun ping(): Ping {
        return apiService.ping()
    }

}