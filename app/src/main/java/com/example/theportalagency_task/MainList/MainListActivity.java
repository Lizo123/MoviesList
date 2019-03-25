package com.example.theportalagency_task.MainList;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.example.theportalagency_task.Models.MovieModel;
import com.example.theportalagency_task.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainListActivity extends AppCompatActivity implements MainListContract.View {


    @BindView(R.id.recycler)
    RecyclerView recycler;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;


    MainListAdapter mainListAdapter;

    MainListPresenter mainListPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mainListPresenter = new MainListPresenter(this);
        mainListPresenter.CallApi();

    }

    @Override
    public void showProgressbar(Boolean check) {

        if(!check)
            progressBar.setVisibility(View.GONE);
        else
            progressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void BindView(ArrayList<MovieModel> movieModels) {

        mainListAdapter = new MainListAdapter(this,movieModels);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recycler.setLayoutManager(linearLayoutManager);
        recycler.setAdapter(mainListAdapter);
    }
}
