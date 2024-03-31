package com.example.finalpredprof.api;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.finalpredprof.api.models.AllJson;
import com.example.finalpredprof.api.models.Data;
import com.example.finalpredprof.api.models.DataPost;
import com.example.finalpredprof.api.models.InfPost;
import com.example.finalpredprof.api.models.Message;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ContrillerPost implements Runnable{
    public static final String BASE_URL = "https://olimp.miet.ru/";
    @Override
    public void run() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        // пример работы
        APIService apiService = retrofit.create(APIService.class);


        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        InfPost r = new InfPost(1, arr);
        DataPost dp = new DataPost(r, "10-39-92");
        Call<Message> call = apiService.request(dp);
        call.enqueue(new Callback<Message>() {
            @Override
            public void onResponse(@NonNull Call<Message> call, @NonNull Response<Message> response) {
                assert response.body() != null;
                Log.d("qwertyuio", response.body().getMessage());
            }

            @Override
            public void onFailure(Call<Message> call, Throwable t) {

            }
        });
    }
}
