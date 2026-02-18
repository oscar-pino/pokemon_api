package com.oscarpino.data.model

import com.google.gson.annotations.SerializedName

data class GenerationDetailResponse(@SerializedName("main_region") val region: RegionRemote)

data class RegionRemote(
    @SerializedName("name") val generationName: String
)