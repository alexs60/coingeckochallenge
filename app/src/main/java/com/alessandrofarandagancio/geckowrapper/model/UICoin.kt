package com.alessandrofarandagancio.geckowrapper.model

import com.alessandrofarandagancio.geckowrapper.api.gecko.model.Coin

data class UICoin(val id: String, val symbol: String, val name: String)

fun List<Coin>.asViewModel(): List<UICoin> {
    return map {
        UICoin(
            id = it.id,
            name = it.name,
            symbol = it.symbol
        )
    }
}