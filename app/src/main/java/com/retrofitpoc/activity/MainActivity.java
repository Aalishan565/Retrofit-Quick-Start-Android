package com.retrofitpoc.activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.retrofitpoc.R;
import com.retrofitpoc.adapter.FlowerAdapter;
import com.retrofitpoc.interfaces.FlowerApi;
import com.retrofitpoc.model.FlowerModel;
import com.retrofitpoc.network.CommunicationManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private ProgressDialog mProgressDialog;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager linearLayoutManager;
    private FlowerAdapter mFlowerAdapter;
    public static final String FLOWER_URL = "http://services.hanselandpetal.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_flowers);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setMessage("Loading...");
        mProgressDialog.setIndeterminate(false);
        mProgressDialog.show();
        mProgressDialog.setCancelable(false);
        callWebservice();
    }

    private void callWebservice() {


        Call<List<FlowerModel>> repos = CommunicationManager.getInstanceGetRequest().getFlowers();
        repos.enqueue(new Callback<List<FlowerModel>>() {
            @Override
            public void onResponse(Call<List<FlowerModel>> call, Response<List<FlowerModel>> response) {
                mProgressDialog.dismiss();
                if (response.isSuccessful()) {
                    List<FlowerModel> flowerList = response.body();
                    mFlowerAdapter = new FlowerAdapter(MainActivity.this, flowerList);
                    mRecyclerView.setAdapter(mFlowerAdapter);
                }

            }

            @Override
            public void onFailure(Call<List<FlowerModel>> call, Throwable t) {
                mProgressDialog.dismiss();
            }
        });

    }
}
