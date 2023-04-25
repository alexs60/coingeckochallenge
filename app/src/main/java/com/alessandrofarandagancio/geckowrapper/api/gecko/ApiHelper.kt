package com.alessandrofarandagancio.geckowrapper.api.gecko

import com.alessandrofarandagancio.geckowrapper.api.gecko.model.Coin
import com.alessandrofarandagancio.geckowrapper.api.gecko.model.Ping
import retrofit2.Call

interface ApiHelper {

    suspend fun getAllCoins(): List<Coin>

    suspend fun ping(): Ping
}