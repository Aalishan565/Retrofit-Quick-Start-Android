package com.retrofitpoc.interfaces;

import com.retrofitpoc.model.FlowerModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by aalishan on 22/11/16.
 */

public interface FlowerApi {
    @GET("/feeds/flowers.json")
    Call<List<FlowerModel>> getFlowers();

}
