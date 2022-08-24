package com.test.fampaydemo.data.datasource;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;
import com.test.fampaydemo.data.model.CardGroup;
import com.test.fampaydemo.network.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CardGroupNetworkSource {
    private final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://run.mocky.io/v3/")
            .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create()))
            .build();
    private final ApiService apiService = retrofit.create(ApiService.class);
    private MutableLiveData<CardGroupsResponse> cardGroupsLiveData = new MutableLiveData<>();

    public MutableLiveData<CardGroupsResponse> getCardGroups() {
        return cardGroupsLiveData;
    }

    public void syncCardGroups() {
        Call<CardGroupsResponse> call = apiService.getCardsData();
        call.enqueue(new Callback<CardGroupsResponse>() {
            @Override
            public void onResponse(@NonNull Call<CardGroupsResponse> call, @NonNull Response<CardGroupsResponse> response) {
                cardGroupsLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<CardGroupsResponse> call, @NonNull Throwable t) {

            }
        });
    }

    public static class CardGroupsResponse {
        private List<CardGroup> cardGroups;

        public List<CardGroup> getCardGroups() {
            return cardGroups;
        }
    }
}