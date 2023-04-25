package com.alessandrofarandagancio.geckowrapper.api.gecko.model

import com.google.gson.annotations.SerializedName


/*
{
  "gecko_says": "(V3) To the Moon!"
}
 */
data class Ping(@SerializedName("gecko_says") val ping: String) {
}