package com.oscarpino.common

data class BaseResponse<T>(val payload:T ?,val result: BaseResult)

enum class BaseResult{
    SUCCESSFUL,
    ERROR
}