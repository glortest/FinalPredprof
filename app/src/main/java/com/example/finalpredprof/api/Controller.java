package com.example.finalpredprof.api;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


import android.os.Handler;

import com.example.finalpredprof.api.models.AllJson;
import com.example.finalpredprof.api.models.Data;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Controller implements Runnable {
    public static final String BASE_URL = "https://olimp.miet.ru/";
    public static MutableLiveData<Data> data;
    int day;
    int month;
    int year;
    public Controller(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public void run() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        // пример работы
        APIService apiService = retrofit.create(APIService.class);

        data = new MutableLiveData<Data>();

        apiService.getData(day, month, year).enqueue(new Callback<AllJson>() {
            @Override
            public void onResponse(@NonNull Call<AllJson> call, @NonNull Response<AllJson> response) {
                data.postValue(response.body().getData());
                assert response.body() != null;

                Log.d("dfghjkjhgfghjhgfghjkjhgbhnm", response.body().getData().getDate().getDescription());

            }

            @Override
            public void onFailure(@NonNull Call<AllJson> call, @NonNull Throwable t) {
                Log.d("Something Wrong", call.toString());
            }
        });
    }
}
