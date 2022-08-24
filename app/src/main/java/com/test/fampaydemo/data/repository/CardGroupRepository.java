package com.test.fampaydemo.data.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.test.fampaydemo.data.datasource.CardGroupNetworkSource;

public class CardGroupRepository {
    private final CardGroupNetworkSource networkDataSource = new CardGroupNetworkSource();

    public MutableLiveData<CardGroupNetworkSource.CardGroupsResponse> getCardGroups() {
        return networkDataSource.getCardGroups();
    }

    public void syncCardGroups() {
        networkDataSource.syncCardGroups();
    }
}
