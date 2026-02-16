package com.oscarpino.data.mapper

import com.oscarpino.data.model.GenerationRemote
import com.oscarpino.domain.model.GenerationDomain

fun GenerationRemote.toGenerationDomain(): GenerationDomain{

    return GenerationDomain(generationName = this.generationName)
}