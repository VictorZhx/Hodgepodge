package com.victor.hodgepodge.sightvision.net

import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

/**
 * Created by victor on 17-9-28.
 */
public interface NewsService {

    // ok
    @FormUrlEncoded
    @POST("/toutiao/index?")
    fun queryNewsList(@Field("key") key: String, @Field("type") type: String): Call<ResponseBody> // http://v.juhe.cn/toutiao/index?type=top&key=APPKEY

    // ok
    @FormUrlEncoded
    @POST("/toutiao/index?")
    fun queryNewsList1(@FieldMap param: Map<String, String>): Call<ResponseBody> // http://v.juhe.cn/toutiao/index?type=top&key=APPKEY

    @POST("/toutiao/index?")
    fun queryNewsList(@Body param: Map<String, String>): Call<ResponseBody> // http://v.juhe.cn/toutiao/index?type=top&key=APPKEY

    //    @Headers("Content-Type: application/json","Accept: application/json")
    @POST("/toutiao/index?")
    fun queryNewsList2(@Body bodyParam: RequestBody): Call<ResponseBody> // http://v.juhe.cn/toutiao/index?type=top&key=APPKEY

    @GET("/toutiao/index?")
    fun queryNewsListByGet(@Query("key") key: String, @Query("type") type: String): Call<ResponseBody> // http://v.juhe.cn/toutiao/index?type=top&key=APPKEY
}