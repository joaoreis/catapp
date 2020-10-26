package com.joaoreis.arch

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.joaoreis.arch.action.Action
import com.joaoreis.arch.action.ViewAction
import com.joaoreis.arch.state.State
import com.joaoreis.arch.state.ViewState

abstract class ViewModel<State : ViewState, Action : ViewAction>(
    initialState: State
) : ViewModel() {

    private val viewModelState = State(initialState)
    private val viewModelAction = Action<Action>()

    val state: LiveData<State> = viewModelState.state

    val action: LiveData<Action> = viewModelAction.action

    protected fun setState(state: (State) -> State) {
        viewModelState.setState(state)
    }

    protected open fun sendAction(action: () -> Action) {
        viewModelAction.sendAction(action)
    }
}
