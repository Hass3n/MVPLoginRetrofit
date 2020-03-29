package com.seniorsteps.mvp;

import com.seniorsteps.mvp.API.Responses.User;

public class LoginPresenter implements LoginContract.Presenter {

    LoginContract.View view;
    LoginContract.Model model;
    public LoginPresenter(LoginContract.View view){
        this.view = view;
        model = new LoginModel(this);

    }

    @Override
    public void Login(String username, String password) {
        view.ShowProgressBar();
        model.Login(username,password);
    }

    @Override
    public void LoginResponse(User user) {

        view.HideProgressBar();
        if(user==null){
            view.ShowMessage("login failed");
        }else {
            view.ShowMessage("login success");
        }
    }
}
