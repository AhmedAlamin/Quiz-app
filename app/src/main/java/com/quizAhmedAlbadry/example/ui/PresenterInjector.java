package com.quizAhmedAlbadry.example.ui;

import com.quizAhmedAlbadry.example.ui.discussion.QuizDiscussionContract;
import com.quizAhmedAlbadry.example.ui.discussion.QuizDiscussionPresenter;
import com.quizAhmedAlbadry.example.ui.home.HomeContract;
import com.quizAhmedAlbadry.example.ui.home.HomePresenter;
import com.quizAhmedAlbadry.example.ui.notification.NotificationContract;
import com.quizAhmedAlbadry.example.ui.notification.NotificationPresenter;
import com.quizAhmedAlbadry.example.ui.profile.ProfileContract;
import com.quizAhmedAlbadry.example.ui.profile.ProfilePresenter;
import com.quizAhmedAlbadry.example.ui.quizattempt.AttemptQuizContract;
import com.quizAhmedAlbadry.example.ui.quizattempt.AttemptQuizPresenter;
import com.quizAhmedAlbadry.example.ui.quizdetails.QuizDetailsContract;
import com.quizAhmedAlbadry.example.ui.quizdetails.QuizDetailsPresenter;
import com.quizAhmedAlbadry.example.ui.signin.SignInContract;
import com.quizAhmedAlbadry.example.ui.signin.SignInPresenter;

/**
 * Encapsulates creation of all Presenters
 */
public class PresenterInjector {

    public static void injectSignInPresenter(SignInContract.View signInView) {
        new SignInPresenter(signInView);
    }

    public static void injectProfilePresenter(ProfileContract.View profileView) {
        new ProfilePresenter(profileView);
    }

    public static void injectHomePresenter(HomeContract.View homeView) {
        new HomePresenter(homeView);
    }

    public static void injectQuizDiscussionPresenter(QuizDiscussionContract.View quizDiscussionView) {
        new QuizDiscussionPresenter(quizDiscussionView);
    }

    public static void injectNotificationPresenter(NotificationContract.View notificationView) {
        new NotificationPresenter(notificationView);
    }

    public static void injectQuizDetailsPresenter(QuizDetailsContract.View quizDetailsView) {
        new QuizDetailsPresenter(quizDetailsView);
    }

    public static void injectQuizAttemptPresenter(AttemptQuizContract.View view) {
        new AttemptQuizPresenter(view);
    }
}
