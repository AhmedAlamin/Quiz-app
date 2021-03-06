package com.quizAhmedAlbadry.example.ui.profile;

import android.graphics.Bitmap;
import android.support.annotation.Nullable;

import com.quizAhmedAlbadry.example.ui.BasePresenter;
import com.quizAhmedAlbadry.example.ui.BaseView;

/**
 * Profile screen contract. Keeps profile View and Presenter interfaces in one place.
 *
 * @Author kaushald
 */
public interface ProfileContract {

    /**
     * Profile view
     */
    interface View extends BaseView<Presenter> {

        void loadUserPic(String picUrl);

        void loadUserName(String userName);

        void loadSlackHandle(String slackHandle);

        void loadEmailAddress(String emailAddress);

        void loadUserTrack(String userTrack);

        void onPictureUploadError();

        void onSaveError();

        void onProfileSaved();

    }

    /**
     * Profile presenter
     */
    interface Presenter extends BasePresenter {

        void saveProfile(@Nullable Bitmap picture, String slackHandle, String courseTrack);

        void saveProfile(@Nullable String pictureUrl, String username, String slackHandle, String courseTrack);

    }

}
