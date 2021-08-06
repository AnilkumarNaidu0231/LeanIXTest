package com.leanix.leanixtest.network

import com.leanix.leanixtest.model.OutputResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ConnectionApi {
    @Headers("Content-Type: application/json")
    @POST("graphql/")
    suspend fun getMissionList(@Body body: String): Response<OutputResponse>
}