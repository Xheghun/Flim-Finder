package com.xheghun.kotlincoroutines.contextProvider

import kotlin.coroutines.CoroutineContext

interface CoroutineContextProvider {
    fun context(): CoroutineContext
}