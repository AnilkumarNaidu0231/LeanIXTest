package com.leanix.leanixtest.network

import com.leanix.leanixtest.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

object RetrofitInstance {
    lateinit var okHttpClient: OkHttpClient

    val connectionApi: ConnectionApi by lazy {
        if (BuildConfig.DEBUG) {
            okHttpClient = OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build()
        }
        Retrofit
            .Builder()
            .baseUrl(BuildConfig.baseUrl)
            .client(okHttpClient)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ConnectionApi::class.java)
    }

}