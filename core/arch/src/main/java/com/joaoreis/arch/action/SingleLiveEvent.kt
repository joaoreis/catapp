package com.joaoreis.arch.action

import androidx.annotation.MainThread
import androidx.annotation.Nullable
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import java.util.concurrent.atomic.AtomicBoolean

class SingleLiveEvent<T> : MutableLiveData<T>() {

    private val pending = AtomicBoolean(false)

    @MainThread
    override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {
        if (hasObservers()) {
            removeObservers(owner)
        }

        super.observe(owner, Observer { data ->
            if (pending.compareAndSet(true, false)) {
                observer.onChanged(data)
            }
        })
    }

    @MainThread
    override fun setValue(@Nullable value: T?) {
        pending.set(true)
        super.setValue(value)
    }

    /**
     * Used for cases where T is Void, to make calls cleaner.
     */
    @MainThread
    fun call() {
        value = null
    }
}
