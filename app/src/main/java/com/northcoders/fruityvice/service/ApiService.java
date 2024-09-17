package com.northcoders.fruityvice.service;

import com.northcoders.fruityvice.model.Fruit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("all")
    Call<List<Fruit>> getAllFruits();
}
