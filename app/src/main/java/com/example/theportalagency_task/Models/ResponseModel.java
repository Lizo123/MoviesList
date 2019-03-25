package com.example.theportalagency_task.Models;

import java.util.ArrayList;

public class ResponseModel {


    ArrayList<MovieModel> results;

    public ResponseModel(ArrayList<MovieModel> results) {
        this.results = results;
    }

    public ArrayList<MovieModel> getMovieModels() {
        return results;
    }
}
