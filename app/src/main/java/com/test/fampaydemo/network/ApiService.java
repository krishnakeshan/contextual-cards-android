package com.test.fampaydemo.network;

import com.test.fampaydemo.data.datasource.CardGroupNetworkSource;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("fefcfbeb-5c12-4722-94ad-b8f92caad1ad")
    Call<CardGroupNetworkSource.CardGroupsResponse> getCardsData();
}