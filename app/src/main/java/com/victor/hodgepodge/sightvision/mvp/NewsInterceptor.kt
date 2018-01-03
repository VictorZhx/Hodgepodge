package com.victor.hodgepodge.sightvision.mvp

import android.os.Bundle
import com.google.gson.Gson
import com.victor.hodgepodge.base.BaseInterceptor
import com.victor.hodgepodge.constants.AppConstants
import com.victor.hodgepodge.constants.NetId
import com.victor.hodgepodge.sightvision.SightConstant
import com.victor.hodgepodge.sightvision.entity.NewsResult
import com.victor.hodgepodge.sightvision.net.NewsService
import com.victor.hodgepodge.utils.LOG
import com.victor.hodgepodge.utils.RetrofitUtil
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * Created by victor on 17-9-28.
 */
class NewsInterceptor : BaseInterceptor() {
    private val TAG = "NewsInterceptor"

    public fun queryNews(key: String = AppConstants.REQUEST_KEY_NEWS, type: String = "top") {

        val newsService = RetrofitUtil.getRetrofit(NetId.BASE_URL_JH_NEWS).create(NewsService::class.java)

//        val queryNewsList = newsService.queryNewsList(key, type)

//        val paramMap = mutableMapOf<String, String>()
//        paramMap.put("key", key)
//        paramMap.put("type", type)
////        val queryNewsList = newsService.queryNewsList(paramMap)
//
//        val bodyJson = JSONObject()
//        val result = JSONObject()
//        try {
//            result.put("key", key)
//            result.put("type", type)
//            bodyJson.put("body", result)
//        } catch (e: JSONException) {
//            e.printStackTrace()
//        }
//
//        var ssss = Gson().toJson(bodyJson)
//        // {"key":"top","type":"0259bd31c8119d573195b7c125a66145"}:
//        val bodyParam = RequestBody.create(MediaType.parse("application/x-www-form-urlencoded"), ssss)
//
//        val root = JSONObject()
//        val requestData = JSONObject()
//        try {
//            requestData.put("param3", "string")
//            requestData.put("param4", "string2")
//            root.put("param1", "111")
//            root.put("param2", "222")
//            root.put("data", requestData)
//        } catch (e: JSONException) {
//            e.printStackTrace()
//        }
//
//
//        val requestBody = RequestBody.create(MediaType.parse("application/json"), root.toString())
//
//        var queryNewsList = newsService.queryNewsList2(requestBody)
        val queryNewsList = newsService.queryNewsListByGet(key, type)

        if (LOG.D) {
            LOG.d(TAG, "  --> request url : " + queryNewsList.request().url())
        }

        queryNewsList.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>?, response: Response<ResponseBody>?) {


                if (LOG.D) {
//                    LOG.d(TAG, " onResponse --> : " + response?.body()?.string())
                }
                val newsResult = Gson().fromJson(response?.body()?.string(), NewsResult::class.java)

                val sightEvent = SightEvent(SightConstant.TYPE_NEWS_LIST_SUCCESS)
                val sightBundle = Bundle()
                sightBundle.putParcelable(SightConstant.PARAM_KEY_RESULT, newsResult)
                sightEvent.bundle = sightBundle
                post(sightEvent)

            }

            override fun onFailure(call: Call<ResponseBody>?, t: Throwable?) {
                val sightEvent = SightEvent(SightConstant.TYPE_NEWS_LIST_ERROR)

                post(sightEvent)
            }

        })


    }


}