package com.assign.registration;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by pawnish on 5/29/2017.
 */

public interface ApiInterface {

    @GET("getMasterData")
    Call<DisplayData> getMasterData();

    /*@POST("profile")
    Call<> setUserInformation()*/
}
