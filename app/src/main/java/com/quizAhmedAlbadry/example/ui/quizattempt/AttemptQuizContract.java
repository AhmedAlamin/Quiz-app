package com.quizAhmedAlbadry.example.ui.quizattempt;

import com.quizAhmedAlbadry.example.data.models.Question;
import com.quizAhmedAlbadry.example.ui.BasePresenter;
import com.quizAhmedAlbadry.example.ui.BaseView;

/**
 * Quiz screen contract. Keeps Quiz View and Presenter interfaces in one place.
 *
 * @Author kaushald
 */
public interface AttemptQuizContract {

    String KEY_QUIZ_ID = "quiz_identifier";

    /**
     * Quiz View
     */
    interface View extends BaseView<Presenter> {

        void enablePreviousButton();

        void disablePreviousButton();

        void showSubmitButton();

        void showNextButton();

        void loadQuestion(Question question);

        void loadQuestionForReview(Question question, Question attemptedQuestion);

        void loadAttemptedStatusText(int currentQuestionNumber, int totalQuestions);

        void loadTitle(String quizTitle);

        void loadResultSummary(int score, int total, double percentage);

        void showError();

        void showInvalidInput();

        void showSubmitConfirmation();

        void dismissView();

    }

    /**
     * Quiz Presenter
     */
    interface Presenter extends BasePresenter {
        void onNextClicked();

        void onReviewClicked();

        void onPreviousClicked();

        void onSubmitClicked();
    }

}
