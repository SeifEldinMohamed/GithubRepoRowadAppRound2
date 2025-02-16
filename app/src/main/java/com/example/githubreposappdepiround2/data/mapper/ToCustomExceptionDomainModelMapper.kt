package com.example.githubreposappdepiround2.data.mapper

import com.example.githubreposappdepiround2.domain.model.CustomExceptionDomainModel
import retrofit2.HttpException
import java.io.IOException
import java.io.InterruptedIOException
import java.net.HttpURLConnection

fun Throwable.toCustomExceptionDomainModel(): CustomExceptionDomainModel {
    return when(this) {
        is InterruptedIOException -> CustomExceptionDomainModel.TimeoutExceptionDomainModel
        is IOException -> CustomExceptionDomainModel.NetworkExceptionDomainModel
        is HttpException -> {
            when(this.code()) {

                HttpURLConnection.HTTP_NOT_FOUND -> CustomExceptionDomainModel.ServiceNotFoundExceptionDomainModel

                HttpURLConnection.HTTP_FORBIDDEN -> CustomExceptionDomainModel.AccessDeniedExceptionDomainModel

                HttpURLConnection.HTTP_UNAVAILABLE -> CustomExceptionDomainModel.ServiceUnavailableExceptionDomainModel

                else -> CustomExceptionDomainModel.UnknownExceptionDomainModel
            }
        }
        else -> CustomExceptionDomainModel.UnknownExceptionDomainModel
    }
}