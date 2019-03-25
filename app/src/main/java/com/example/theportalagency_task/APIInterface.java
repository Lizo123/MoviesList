package com.example.theportalagency_task;


import com.example.theportalagency_task.Models.ResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {

    @GET("movie?api_key=ceb888b71023afda704f84975d2642b5")
    Call<ResponseModel> GetMovies();
}
