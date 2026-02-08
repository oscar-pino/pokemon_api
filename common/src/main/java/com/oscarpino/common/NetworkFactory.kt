package com.oscarpino.common

import io.nerdythings.okhttp.profiler.OkHttpProfilerInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkFactory {
    companion object{

        fun makeRetrofit(baseUrl:String): Retrofit{

            return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).client(makeHttpClient()).baseUrl(baseUrl).build()
        }

        fun makeHttpClient(): OkHttpClient{
            return OkHttpClient.Builder()
                .addInterceptor(OkHttpProfilerInterceptor()).build()
        }
    }
}