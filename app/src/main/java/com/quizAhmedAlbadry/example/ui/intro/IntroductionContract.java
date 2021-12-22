package com.quizAhmedAlbadry.example.ui.intro;

import com.quizAhmedAlbadry.example.ui.BasePresenter;
import com.quizAhmedAlbadry.example.ui.BaseView;

/**
 * Introduction screen contract. Keeps Introduction View and Presenter interfaces in one place.
 *
 * @Author kaushald
 */
public interface IntroductionContract {

    /**
     * Introduction view
     */
    interface View extends BaseView<Presenter> {

    }

    /**
     * Introduction presenter
     */
    interface Presenter extends BasePresenter {

    }

}
