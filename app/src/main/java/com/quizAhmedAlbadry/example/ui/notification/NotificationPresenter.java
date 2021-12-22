package com.quizAhmedAlbadry.example.ui.notification;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.quizAhmedAlbadry.example.data.DataHandler;
import com.quizAhmedAlbadry.example.data.DataHandlerProvider;
import com.quizAhmedAlbadry.example.data.models.Notification;
import com.quizAhmedAlbadry.example.data.models.Quiz;
import com.quizAhmedAlbadry.example.data.models.Resource;
import com.quizAhmedAlbadry.example.utils.AppConstants;

import java.util.List;

public class NotificationPresenter implements NotificationContract.Presenter {

    private NotificationContract.View mView;
    private DataHandler mDataHandler;

    public NotificationPresenter(NotificationContract.View view) {
        this.mView = view;
        this.mDataHandler = DataHandlerProvider.provide();

        mView.setPresenter(this);
    }

    @Override
    public void onTabSwitched(int tabId) {
        // Do nothing
    }

    @Override
    public void fetchNewQuizNotifications() {
        mView.showLoading();
        mDataHandler.fetchQuizzes(5, new DataHandler.Callback<List<Quiz>>() {
            @Override
            public void onResponse(List<Quiz> result) {
                List<Notification> newQuizNotifications = Notification.fromQuizzes(result, true);
                mView.loadNewQuizNotifications(newQuizNotifications);
                mView.hideLoading();
            }

            @Override
            public void onError() {
                mView.showError();
                mView.hideLoading();
            }
        });
    }

    @Override
    public void fetchDeadlineNotifications() {
        mDataHandler.fetchQuizzes(5, new DataHandler.Callback<List<Quiz>>() {
            @Override
            public void onResponse(List<Quiz> result) {
                List<Notification> newQuizNotifications = Notification.fromQuizzes(result, false);
                mView.loadDeadlineNotifications(newQuizNotifications);
                mView.hideLoading();
            }

            @Override
            public void onError() {
                mView.showError();
                mView.hideLoading();
            }
        });
    }

    @Override
    public void fetchResources() {
        mDataHandler.fetchResources(0, 0, new DataHandler.Callback<List<Resource>>() {
            @Override
            public void onResponse(List<Resource> result) {
                List<Notification> resourceNotifications = Notification.fromResources(result);
                mView.loadResourceNotifications(resourceNotifications);
                mView.hideLoading();
            }

            @Override
            public void onError() {
                mView.hideLoading();
            }
        });
    }

    @Override
    public void start(@Nullable Bundle extras) {
        if(extras != null && extras.containsKey(AppConstants.NOTIFICATION_TYPE_RESOURCES)){
            mView.showResourcesTab();
        }
    }

    @Override
    public void destroy() {
        this.mView = null;
        this.mDataHandler = null;
    }
}
