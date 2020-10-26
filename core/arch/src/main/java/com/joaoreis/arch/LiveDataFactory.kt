package com.joaoreis.arch

import androidx.lifecycle.MutableLiveData
import com.joaoreis.arch.action.SingleLiveEvent
import com.joaoreis.arch.action.ViewAction
import com.joaoreis.arch.state.ViewState

object LiveDataFactory {

    fun <T : ViewState> createMutableLiveData(initialState: T): MutableLiveData<T> {
        return MutableLiveData<T>().apply {
            value = initialState
        }
    }

    fun <T : ViewAction> createSingleLiveEvent(): SingleLiveEvent<T> {
        return SingleLiveEvent()
    }
}
