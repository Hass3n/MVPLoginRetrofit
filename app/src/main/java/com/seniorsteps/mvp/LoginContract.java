package com.seniorsteps.mvp;

import com.seniorsteps.mvp.API.Responses.User;

public class LoginContract {

    public interface View{
       void ShowProgressBar();
       void ShowMessage(String message);
       void HideProgressBar();
    }
    public interface Presenter{
      void  Login(String username,String password);
      void LoginResponse(User user);
    }
    public interface Model{
       void Login(String username,String password);
    }
}
