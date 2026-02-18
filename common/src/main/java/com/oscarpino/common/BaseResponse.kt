package com.oscarpino.common

data class BaseResponse<T>(val payload:T?, val result: BaseResult)

enum class BaseResult{
    SUCCESSFUL,
    ERROR
}

sealed interface BaseResponseV2<T>{
    data class BaseResultSuccessful<T>(val result:T): BaseResponseV2<T>
    data class BaseError<T>(val error:String): BaseResponseV2<T>
}