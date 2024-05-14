package com.xheghun.kotlincoroutines.data.model

class Result<out T>(val value: T?, val throwable: Throwable?) {
}