package com.oscarpino.common

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

abstract class BaseViewModel<S,I>: ViewModel() {

    abstract val initialState:S
    protected val _state = MutableStateFlow<S>(initialState)
    val state: StateFlow<S> =_state

    abstract fun sendIntent(intent:I)
    abstract fun handleIntent(intent:I)

    protected fun setState(state:S){
        _state.update {
            state
        }
    }
}