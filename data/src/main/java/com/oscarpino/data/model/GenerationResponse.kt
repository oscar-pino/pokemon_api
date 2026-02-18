package com.oscarpino.data.model

import com.google.gson.annotations.SerializedName

data class GenerationResponse(
        val count:Int,
        @SerializedName("results") val results:List<GenerationRemote>
)

