package com.victor.hodgepodge.home.net;

import com.victor.hodgepodge.home.entity.JokeResult;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by victor on 17-9-24.
 */

public interface JokeService {

    @GET("joke/content/list.from?")
    Call<ResponseBody> getJokeCollections(@Query("key") String key, @Query("page") int page, @Query("pagesize") int pagesize, @Query("sort") String sort, @Query("time") String time);

    @GET("joke/content/list.from?")
    Call<JokeResult> getJokeCollections2(@Query("key") String key, @Query("page") int page, @Query("pagesize") int pagesize, @Query("sort") String sort, @Query("time") String time);

}
