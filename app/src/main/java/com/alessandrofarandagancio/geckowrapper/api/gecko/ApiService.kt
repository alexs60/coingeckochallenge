package com.alessandrofarandagancio.geckowrapper.api.gecko

import com.alessandrofarandagancio.geckowrapper.api.gecko.model.Coin
import com.alessandrofarandagancio.geckowrapper.api.gecko.model.Ping
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("v3/coins/list")
    suspend fun getAllCoins(): List<Coin>

    @GET("v3/ping")
    suspend fun ping(): Ping

}