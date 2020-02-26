package com.example.loginmvp.Presenter;

import com.example.loginmvp.Model.LoginInteractor;
import com.example.loginmvp.View.LoginView;

public class LoginPresenterImpl  implements LoginPresenter, LoginInteractor.OnLoginFinishedListener {
    private LoginView loginView;
    private LoginInteractor loginInteractor;
    public LoginPresenterImpl(LoginView loginView, LoginInteractor loginInteractor) {
        this.loginView = loginView;
        this.loginInteractor = loginInteractor;
    }
    @Override
    public void validateCredentials(String username, String password) {
        loginView.showProgress();
        loginInteractor.login(username,password,this);
    }
    @Override
    public void onUsernameError() {
        loginView.setUserNameError();
        loginView.HideProgress();
    }
    @Override
    public void onPasswordError() {
        loginView.setPasswordError();
        loginView.HideProgress();
    }
    @Override
    public void onSuccess() {
        loginView.HideProgress();
        loginView.navigateToHome();
    }
}

