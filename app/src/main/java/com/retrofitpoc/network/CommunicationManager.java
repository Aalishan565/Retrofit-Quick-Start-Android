package com.retrofitpoc.network;

import com.retrofitpoc.activity.MainActivity;
import com.retrofitpoc.interfaces.FlowerApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by aalishan on 22/11/16.
 */

public class CommunicationManager {
    public static FlowerApi getInstanceGetRequest() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MainActivity.FLOWER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        FlowerApi service = retrofit.create(FlowerApi.class);
        return service;
    }
}
