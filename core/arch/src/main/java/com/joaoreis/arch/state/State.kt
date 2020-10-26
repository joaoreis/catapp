package com.joaoreis.arch.state

import androidx.lifecycle.LiveData
import com.joaoreis.arch.LiveDataFactory

class State<State : ViewState>(initialState: State) {

    private val _state = LiveDataFactory.createMutableLiveData(initialState)
    val state: LiveData<State> = _state

    fun setState(state: (State) -> State) {
        // As we always set a initial state and setter is private and
        // always set a non null value, value can never be null.
        _state.value = state(_state.value!!)
    }
}
