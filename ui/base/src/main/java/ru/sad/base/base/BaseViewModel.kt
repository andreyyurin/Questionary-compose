package ru.sad.base.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel<S, DS, E, A> : ViewModel(), CoroutineScope {

    val state: SharedFlow<S> by lazy { stateFlow }

    val dialogState: SharedFlow<DS> by lazy { dialogStateFlow }

    val action: SharedFlow<A> by lazy { actionFlow }

    private val stateFlow =
        MutableSharedFlow<S>(
            replay = 1,
            onBufferOverflow = BufferOverflow.DROP_OLDEST
        )

    private val dialogStateFlow =
        MutableSharedFlow<DS>(
            replay = 1,
            onBufferOverflow = BufferOverflow.DROP_OLDEST
        )

    private val actionFlow = MutableSharedFlow<A>(
        replay = 0,
        onBufferOverflow = BufferOverflow.DROP_OLDEST,
        extraBufferCapacity = 1
    )

    private val scopeJob: Job = SupervisorJob()

    private val errorHandler = CoroutineExceptionHandler { _, throwable ->

    }

    override val coroutineContext: CoroutineContext = scopeJob + Dispatchers.Main + errorHandler

    abstract fun onEvent(event: E)

    protected fun setState(state: S) = stateFlow.tryEmit(state)

    protected fun getStateValueOrNull() = state.replayCache.firstOrNull()

    protected fun setDialogState(dialogState: DS) = dialogStateFlow.tryEmit(dialogState)

    protected fun emitAction(action: A) = actionFlow.tryEmit(action)
}