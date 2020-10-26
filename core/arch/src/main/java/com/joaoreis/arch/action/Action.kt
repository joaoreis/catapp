package com.joaoreis.arch.action

import androidx.lifecycle.LiveData
import com.joaoreis.arch.LiveDataFactory

class Action<Action : ViewAction> {

    private val _action: SingleLiveEvent<Action> = LiveDataFactory.createSingleLiveEvent()
    val action: LiveData<Action> = _action

    fun sendAction(action: () -> Action) {
        _action.value = action()
    }
}
