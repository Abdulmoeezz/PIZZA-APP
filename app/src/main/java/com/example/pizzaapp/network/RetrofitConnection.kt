package com.example.pizzaapp.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitConnection {


    companion object{

        var retrofit: Retrofit? = null
        var okHttpClient: OkHttpClient? = null

        fun connect(): Retrofit {
            okHttpClient = OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .connectTimeout(300000, TimeUnit.SECONDS)
                .writeTimeout(300000, TimeUnit.SECONDS)
                .build()
            retrofit = Retrofit.Builder().baseUrl("http://ec2-18-216-19-81.us-east-2.compute.amazonaws.com/api/v1/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create()).build()


            return retrofit as Retrofit
        }
    }

}