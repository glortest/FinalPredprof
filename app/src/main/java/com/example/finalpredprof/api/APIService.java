package com.example.finalpredprof.api;



import com.example.finalpredprof.api.models.AllJson;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface APIService {
    @Headers("X-Auth-Token: ppo_11_14883")
    @GET("ppo_it_final")
    Call<AllJson> getData(@Query("day") String day, @Query("month") String month, @Query("year") String year);
}
