package com.northcoders.fruityvice.model;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.northcoders.fruityvice.service.ApiService;
import com.northcoders.fruityvice.service.RetrofitInstance;

import java.util.*;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FruitRepository {

    private ArrayList<Fruit> fruits = new ArrayList<>();
    private MutableLiveData<List<Fruit>> mutableLiveData = new MutableLiveData<List<Fruit>>();
    private Application application;

    public MutableLiveData<List<Fruit>> getMutableLiveData() {

        ApiService apiService = RetrofitInstance.getService();
        Call<List<Fruit>> call = apiService.getAllFruits();

        call.enqueue(new Callback<List<Fruit>>() {
            @Override
            public void onResponse(Call<List<Fruit>> call, Response<List<Fruit>> response) {
                List<Fruit> fruits = response.body();
                mutableLiveData.setValue(fruits);
            }

            @Override
            public void onFailure(Call<List<Fruit>> call, Throwable t) {
                Log.e("HTTP Failure", Objects.requireNonNull(t.getMessage()));
            }
        });

        return mutableLiveData;
    }
}
