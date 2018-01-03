package com.victor.hodgepodge.home.mvp;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.victor.hodgepodge.base.BaseInterceptor;
import com.victor.hodgepodge.home.entity.JokeResult;
import com.victor.hodgepodge.home.net.JokeService;
import com.victor.hodgepodge.utils.RetrofitUtil;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by victor on 17-9-24.
 */

public class JokeInterceptor extends BaseInterceptor {

    private static final String TAG = "JokeInterceptor";

    public void getJokeCollections(String key, int page, int pagesize, String sort, String time) {


        JokeService jokeService = RetrofitUtil.INSTANCE.getRetrofit().create(JokeService.class);
        Call<ResponseBody> jokeCollections = jokeService.getJokeCollections(key, page, pagesize, sort, time);


        jokeCollections.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

//                Log.i(TAG, " onResponse --> : " + response.toString());


                try {
//                    Log.d(TAG, " onResponse--> string : " + response.body().string());
//                    JSONObject jsonObject = new JSONObject(response.body().string());

                    JokeResult jokeResult = new Gson().fromJson(response.body().string(), JokeResult.class);

                    HomeEvent homeEvent = new HomeEvent(HomeEventType.INSTANCE.getTYPE_JOKE_LIST_SUCCESS());

                    Bundle bundle = new Bundle();
                    bundle.putParcelable(HomeConstants.INSTANCE.getPARAM_KEY_RESULT(), jokeResult);
                    homeEvent.setBundle(bundle);
                    post(homeEvent);

                    Log.d(TAG, " onResponse--> jokeResult : " + jokeResult);
                } catch (Exception e) {
                    Log.d(TAG, " e--> : ");
                    e.printStackTrace();
                }


            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                HomeEvent homeEvent = new HomeEvent(HomeEventType.INSTANCE.getTYPE_JOKE_LIST_ERROR());

                post(homeEvent);
            }
        });

//        Call<JokeResult> jokeCollections2 = jokeService.getJokeCollections2(key, page, pagesize, sort, time);
//        jokeCollections2.enqueue(new Callback<JokeResult>() {
//            @Override
//            public void onResponse(Call<JokeResult> call, Response<JokeResult> response) {
//
//                JokeResult body = response.body();
//
//                EventBus eventBus = new EventBus();
//
//
//                eventBus.post(eventBus);
//
//            }
//
//            @Override
//            public void onFailure(Call<JokeResult> call, Throwable t) {
//
//            }
//        });

    }

}
