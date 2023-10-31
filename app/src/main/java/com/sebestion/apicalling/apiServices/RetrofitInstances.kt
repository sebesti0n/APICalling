package com.sebestion.apicalling.apiServices

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstances {

    companion object{


        val retrofit: Retrofit by lazy {
            val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()
            Retrofit.Builder()
                .baseUrl("https://firstserver-production.up.railway.app")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
        }

        val service: ApiServices by lazy {
            retrofit.create(ApiServices::class.java)
        }
    }

}