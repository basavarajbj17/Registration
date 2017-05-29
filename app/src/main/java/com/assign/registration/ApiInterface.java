package com.assign.registration;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiInterface {

    @GET("getMasterData")
    Call<DisplayData> getMasterData();

    @Headers("Content-Type: application/json")
    @POST("profile")
    Call<JsonObject> setUserInformation(@Body UserInfo userInfo);
}
