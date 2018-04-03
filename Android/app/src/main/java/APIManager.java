package com.example.abhishekkoranne.engineersbook;

/**
 * Created by Abhishek Koranne on 04-03-2018.
 */

import com.google.gson.JsonElement;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface APIManager {
    @FormUrlEncoded
    @POST(Constant.URL_LOGIN)
    Call<Map<String, Object>> login(@FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST(Constant.URL_REGISTER)
    Call<Map<String, Object>> register(@FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST(Constant.URL_GET_DETAIL)
    Call<Map<String, Object>> getDetails(@FieldMap Map<String, String> params);

//    @GET("/getarticle/1/7")
//    Map<String, Object> getArticles(@Query("page") int page, @Query("size") int size, Callback<Map<String, Object>> callback);

    @GET(Constant.URL_GET_ARTICLES)
    Call<Map<String, Object>> getArticle(@Query("page") int page, @Query("size") int size);

    @GET(Constant.URL_GET_DOUBT)
    Call<Map<String, Object>> getdoubtlist(@Query("page") int page, @Query("size") int size);

    @GET(Constant.URL_GET_COMMENTS)
    Call<Map<String, Object>> getComment(@Query("page") int page, @Query("size") int size);

    // Add all your api calls here...
}