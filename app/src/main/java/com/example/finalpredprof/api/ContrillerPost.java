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
    int count;
    List<Integer> arr;
    String date;

    public ContrillerPost(int count, List<Integer> arr, String date) {
        this.count = count;
        this.arr = arr;
        this.date = date;
    }

    public static final String BASE_URL = "https://olimp.miet.ru/";
    @Override
    public void run() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        // пример работы
        APIService apiService = retrofit.create(APIService.class);



        InfPost r = new InfPost(count, arr);
        DataPost dp = new DataPost(r, date);
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
