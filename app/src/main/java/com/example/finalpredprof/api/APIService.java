package com.example.finalpredprof.api;



import com.example.finalpredprof.api.models.AllJson;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface APIService {
    @Headers("X-Auth-Token: ppo_10_31993")
    @GET(".")
    Call<AllJson> getData(@Query("day") Integer day, @Query("month") Integer month, @Query("year") Integer year);
}
