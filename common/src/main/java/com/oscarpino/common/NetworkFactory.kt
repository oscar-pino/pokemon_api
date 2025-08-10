package com.oscarpino.common

import okhttp3.OkHttpClient
import retrofit2.Retrofit

class NetworkFactory {
    companion object{

        fun makeRetrofit(baseUrl:String): Retrofit{
            return Retrofit.Builder().client(makeHttpClient()).baseUrl(baseUrl).build()
        }

        fun makeHttpClient(): OkHttpClient{
            return OkHttpClient.Builder().build()
        }
    }
}