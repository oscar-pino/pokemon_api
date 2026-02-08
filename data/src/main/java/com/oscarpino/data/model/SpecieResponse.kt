package com.oscarpino.data.model

import com.google.gson.annotations.SerializedName

data class SpecieResponse(
    @SerializedName("name") val name:String,
    @SerializedName("url") val url:String
)