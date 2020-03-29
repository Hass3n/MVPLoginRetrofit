package com.seniorsteps.mvp;

import com.seniorsteps.mvp.API.ApiManager;
import com.seniorsteps.mvp.API.Responses.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginModel implements LoginContract.Model {

    LoginContract.Presenter presenter;

    public LoginModel(LoginContract.Presenter presenter){
        this.presenter = presenter;
    }
    @Override
    public void Login(String username, String password) {

        ApiManager.getAPIs().Login(username,password)
                .enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        if("success".equals(response.body().getStatus())){
                            presenter.LoginResponse(response.body().getData());
                        }else presenter.LoginResponse(null);
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {
                        presenter.LoginResponse(null);
                    }
                });
    }
}
