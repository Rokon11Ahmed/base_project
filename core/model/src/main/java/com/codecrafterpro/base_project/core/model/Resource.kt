package com.codecrafterpro.base_project.core.model

sealed class Resource<T> {
    class Loading<T>(): Resource<T>()
    class Success<T>(val data: T?): Resource<T>()
    class Error<T>(val message: String, val data: T? = null): Resource<T>()
}