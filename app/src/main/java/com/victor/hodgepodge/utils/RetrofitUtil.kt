package com.victor.hodgepodge.utils

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.victor.hodgepodge.constants.NetId
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by victor on 17-9-28.
 */
object RetrofitUtil {

    private val client = OkHttpClient.Builder()
            .addNetworkInterceptor(StethoInterceptor())
            .build()

    val retrofit = Retrofit.Builder()
            .baseUrl(NetId.BASE_URL_JH_JOKE)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

    fun getRetrofit(baseUrl: String): Retrofit {
        return retrofit.newBuilder().baseUrl(baseUrl).build()
    }
}