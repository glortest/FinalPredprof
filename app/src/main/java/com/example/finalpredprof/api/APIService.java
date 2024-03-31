package com.example.finalpredprof.api;



import com.example.finalpredprof.api.models.AllJson;
import com.example.finalpredprof.api.models.Data;
import com.example.finalpredprof.api.models.DataPost;
import com.example.finalpredprof.api.models.InfPost;
import com.example.finalpredprof.api.models.Message;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface APIService {
    @Headers("x-auth-token: ppo_11_14883")
    @GET("ppo_it_final")
    Call<AllJson> getData(@Query("day") int day, @Query("month") int month, @Query("year") int year);


    @POST("ppo_it_final")
    @Headers({"x-auth-token: ppo_11_14883",
            "Content-Type: application/json"})
    Call<Message> request(@Body DataPost dataPost);

}
