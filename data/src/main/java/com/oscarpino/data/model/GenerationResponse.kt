package com.oscarpino.data.model

import com.google.gson.annotations.SerializedName

data class GenerationResponse(

        @SerializedName("name") val generation:GenerationRemote

)