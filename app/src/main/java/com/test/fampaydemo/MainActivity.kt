package com.test.fampaydemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.test.fampaydemo.adapter.CardGroupsAdapter
import com.test.fampaydemo.viewmodel.CardGroupViewModel

class MainActivity : AppCompatActivity() {
    private val cardGroupViewModel = CardGroupViewModel();
    private lateinit var cardGroupsRecyclerView: RecyclerView;
    private val cardGroupsAdapter = CardGroupsAdapter(emptyList());

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

        cardGroupViewModel.cardGroups.observe(this) { cardGroupsResponse ->
            cardGroupsAdapter.setData(cardGroupsResponse.cardGroups);
        }

        cardGroupViewModel.syncCardGroups()
    }

    private fun initViews() {
        cardGroupsRecyclerView = findViewById(R.id.card_groups_recycler_view)
        cardGroupsRecyclerView.layoutManager = LinearLayoutManager(this)
        cardGroupsRecyclerView.adapter = cardGroupsAdapter
    }
}