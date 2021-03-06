package com.quizAhmedAlbadry.example.utils;

public class AppConstants {

    public static final String QUESTION_SINGLE_CHOICE = "single-choice";
    public static final String QUESTION_MULTIPLE_CHOICE = "multiple-choice";
    public static final String QUESTION_SUBJECTIVE_TYPE = "subjective";

    public AppConstants() {
        // Prevents accidental initialization
    }

    // Notification Keys
    public static final String KEY_TITLE = "title";
    public static final String KEY_DESCRIPTION = "description";
    public static final String KEY_FROM = "sender";
    public static final String KEY_TYPE = "type";
    public static final String KEY_ACTION = "action";
    public static final String KEY_EXTRA_1 = "extra_1";
    public static final String KEY_EXTRA_2 = "extra_2";

    // Notification Types
    public static final String NOTIFICATION_TYPE_QUIZ = "quiz";
    public static final String NOTIFICATION_TYPE_DEADLINE = "deadline";
    public static final String NOTIFICATION_TYPE_RESOURCES = "resources";
    public static final String NOTIFICATION_TYPE_DISCUSSION = "discussion";
    public static final String NOTIFICATION_TYPE_ANNOUNCEMENTS = "announcements";
}
