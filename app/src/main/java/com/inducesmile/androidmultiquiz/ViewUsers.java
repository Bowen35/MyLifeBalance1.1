package com.inducesmile.androidmultiquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.inducesmile.androidmultiquiz.adapters.ClientRecyclerAdapter;
import com.inducesmile.androidmultiquiz.database.DBHandler;
import com.inducesmile.androidmultiquiz.entities.Client;

import java.util.ArrayList;
import java.util.List;

public class ViewUsers extends AppCompatActivity {

    private RecyclerView recyclerViewClients;
    private List<Client> listClients;
    private ClientRecyclerAdapter clientRecyclerAdapter;
    private DBHandler dbh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_users);

        recyclerViewClients = (RecyclerView) findViewById(R.id.recyclerViewClient);
        listClients = new ArrayList<>();
        clientRecyclerAdapter = new ClientRecyclerAdapter(listClients);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewClients.setLayoutManager(mLayoutManager);
        recyclerViewClients.setItemAnimator(new DefaultItemAnimator());
        recyclerViewClients.setHasFixedSize(true);
        recyclerViewClients.setAdapter(clientRecyclerAdapter);
        dbh = new DBHandler(ViewUsers.this);

        listClients.clear();
        listClients.addAll(dbh.getAllClient());
    }
}
