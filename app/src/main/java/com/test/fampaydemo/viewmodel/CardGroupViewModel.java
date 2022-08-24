package com.test.fampaydemo.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.test.fampaydemo.data.datasource.CardGroupNetworkSource;
import com.test.fampaydemo.data.repository.CardGroupRepository;

public class CardGroupViewModel extends ViewModel {
    private final CardGroupRepository cardGroupRepository = new CardGroupRepository();
    private final MutableLiveData<CardGroupNetworkSource.CardGroupsResponse> cardGroups = cardGroupRepository.getCardGroups();

    public LiveData<CardGroupNetworkSource.CardGroupsResponse> getCardGroups() {
        return cardGroups;
    }

    public void syncCardGroups() {
        cardGroupRepository.syncCardGroups();
    }
}
