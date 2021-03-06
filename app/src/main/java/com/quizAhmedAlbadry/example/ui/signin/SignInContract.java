package com.quizAhmedAlbadry.example.ui.signin;

import android.net.Uri;

import com.quizAhmedAlbadry.example.ui.BasePresenter;
import com.quizAhmedAlbadry.example.ui.BaseView;

/**
 * Sign In Contract contract. Keeps SignIn Screen View and Presenter interfaces in one place.
 *
 * @Author kaushald
 */
public interface SignInContract {

    /**
     * SignIn View
     */
    interface View extends BaseView<Presenter> {

        void loginSuccess();

        void loginFailure(int statusCode, String message);

        void startSignIn();

        void navigateToProfile();
    }

    /**
     * SignIn Presenter
     */
    interface Presenter extends BasePresenter {

        void handleLoginRequest();

        void handleLoginSuccess(String email, String displayName, Uri photoUrl);

        void handleLoginFailure(int statusCode, String message);
    }

}
