package com.nd.mvpcore.controllers;

/**
 * Created by liy on 2015/8/25.
 */
public class UserController extends BaseUiController<UserController.UserUi, UserController.UserUiCallbacks> {


    public interface UserUiCallbacks {
        void onTitleChanged(String newTitle);

        boolean isUsernameValid(String username);

        boolean isPasswordValid(String password);

        boolean isEmailValid(String email);

        void login(String username, String password);

        void createUser(String username, String password, String email);

        void requestReLogin();
    }

    public interface UserUi extends BaseUiController.Ui<UserUiCallbacks> {
        void showLoadingProgress(boolean visible);

        void showError(Error error);
    }

    @Override
    protected void onInited() {
        super.onInited();
    }


    @Override
    protected UserUiCallbacks createUiCallbacks(UserUi ui) {
        return new UserUiCallbacks() {
            @Override
            public void onTitleChanged(String newTitle) {

            }

            @Override
            public boolean isUsernameValid(String username) {
                return false;
            }

            @Override
            public boolean isPasswordValid(String password) {
                return false;
            }

            @Override
            public boolean isEmailValid(String email) {
                return false;
            }

            @Override
            public void login(String username, String password) {

            }

            @Override
            public void createUser(String username, String password, String email) {

            }

            @Override
            public void requestReLogin() {

            }
        };
    }

}
