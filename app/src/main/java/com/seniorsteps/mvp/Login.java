package com.seniorsteps.mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.seniorsteps.mvp.Base.MyBaseActivity;

public class Login extends MyBaseActivity
        implements LoginContract.View{

    EditText username,password;
    Button login;
    LoginContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        intitView();
        presenter = new LoginPresenter(this);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameString  = username.getText().toString();
                String passwordString = password.getText().toString();
                presenter.Login(usernameString,passwordString);
            }
        });

    }

    private void intitView() {
        username =findViewById(R.id.user_name);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
    }

    @Override
    public void ShowMessage(String Message) {
        ShowMessage("",Message);

    }

    @Override
    public void ShowProgressBar() {
        showProgressBar();
    }

    @Override
    public void HideProgressBar() {
        hideProgressBar();
    }
}
