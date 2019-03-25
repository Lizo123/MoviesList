package com.example.theportalagency_task.MainList;


import com.example.theportalagency_task.APIClient;
import com.example.theportalagency_task.APIInterface;
import com.example.theportalagency_task.MainList.MainListActivity;
import com.example.theportalagency_task.MainList.MainListContract;
import com.example.theportalagency_task.Models.ResponseModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainListPresenter implements MainListContract.presenter {


    MainListActivity activity;
    private APIInterface apiInterface;

    public MainListPresenter(MainListActivity activity) {
        this.activity = activity;
    }

    @Override
    public void CallApi() {

        apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<ResponseModel> call = apiInterface.GetMovies();
        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                activity.showProgressbar(false);
                if (response.code() == 200 && response.body() != null) {
                    activity.BindView(response.body().getMovieModels());
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                activity.showProgressbar(false);

            }
        });
    }
}
