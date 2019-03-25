package com.example.theportalagency_task.MainList;

import com.example.theportalagency_task.Models.MovieModel;

import java.util.ArrayList;

public interface MainListContract {

    public interface presenter
    {
       void CallApi();

    }

    public interface View
    {
        void showProgressbar(Boolean check);
        void BindView(ArrayList<MovieModel> movieModels);
    }
}
