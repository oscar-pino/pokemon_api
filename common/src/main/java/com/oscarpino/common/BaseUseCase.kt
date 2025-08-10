package com.oscarpino.common

abstract class BaseUseCase<R> {
    abstract suspend fun execute():R
}

abstract class BaseUseCaseWithParam<P,R>(){
    abstract suspend fun execute(params:P):R

}
