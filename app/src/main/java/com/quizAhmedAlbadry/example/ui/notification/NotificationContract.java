package com.quizAhmedAlbadry.example.ui.notification;

import com.quizAhmedAlbadry.example.data.models.Notification;
import com.quizAhmedAlbadry.example.ui.BasePresenter;
import com.quizAhmedAlbadry.example.ui.BaseView;

import java.util.List;

/**
 * Notification screen contract. Keeps Notification View and Presenter interfaces in one place.
 *
 * @Author kaushald
 */
public interface NotificationContract {

    /**
     * Notification Screen view
     */
    interface View extends BaseView<Presenter> {
        void loadNewQuizNotifications(List<Notification> newQuizNotifications);

        void loadDeadlineNotifications(List<Notification> deadlineNotifications);

        void loadResourceNotifications(List<Notification> resourceNotifications);

        void showError();

        void showResourcesTab();
    }

    /**
     * Notification Screen presenter
     */
    interface Presenter extends BasePresenter {
        void onTabSwitched(int tabId);
        void fetchNewQuizNotifications();
        void fetchDeadlineNotifications();
        void fetchResources();
    }

}
