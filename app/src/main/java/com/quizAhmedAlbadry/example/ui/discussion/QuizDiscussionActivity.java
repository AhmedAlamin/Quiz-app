package com.quizAhmedAlbadry.example.ui.discussion;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.quizAhmedAlbadry.example.R;
import com.quizAhmedAlbadry.example.data.models.Comment;
import com.quizAhmedAlbadry.example.data.models.Quiz;
import com.quizAhmedAlbadry.example.ui.PresenterInjector;

import java.util.List;

public class QuizDiscussionActivity extends AppCompatActivity implements
        QuizDiscussionContract.View, View.OnClickListener {

    private QuizDiscussionAdapter mQuizDiscussionAdapter;
    private QuizDiscussionContract.Presenter mPresenter;
    private EditText mDiscussionEditText;
    private RecyclerView mQuizDiscussionRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_discussion);
        initializeUI();

        // Injecting presenter reference
        PresenterInjector.injectQuizDiscussionPresenter(this);

        mPresenter.start(getIntent().getExtras());
    }

    private void initializeUI() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        mDiscussionEditText = findViewById(R.id.quiz_discussion_edit_text);

        findViewById(R.id.quiz_discussion_btn_send).setOnClickListener(this);

        mQuizDiscussionRecyclerView = findViewById(R.id.quiz_discussion_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        mQuizDiscussionRecyclerView.setLayoutManager(linearLayoutManager);

        mQuizDiscussionAdapter = new QuizDiscussionAdapter();

        mQuizDiscussionRecyclerView.setAdapter(mQuizDiscussionAdapter);

    }

    public static void start(Context context, Quiz quiz) {

        Bundle quizBundle = new Bundle();
        //TODO put quiz data in bundle
        Intent quizDiscussionIntent = new Intent(context, QuizDiscussionActivity.class);
        context.startActivity(quizDiscussionIntent, quizBundle);
    }

    @Override
    public void loadComments(List<Comment> discussions) {
        //TODO yet to be implemented
        mQuizDiscussionAdapter.setComments(discussions);
    }

    @Override
    public void onCommentsLoadError() {
        Toast.makeText(this, getString(R.string.something_went_wrong), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loadComment(Comment comment) {
        mDiscussionEditText.setText("");
        mQuizDiscussionAdapter.addComment(comment);
        mQuizDiscussionRecyclerView.smoothScrollToPosition(mQuizDiscussionAdapter.getItemCount());
    }

    @Override
    public void showInvalidInput() {
        Toast.makeText(this, getString(R.string.invalid_input_provided), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPresenter(QuizDiscussionContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void showLoading() {
        //TODO yet to be implemented
    }

    @Override
    public void hideLoading() {
        //TODO yet to be implemented
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.quiz_discussion_btn_send) {
            String userComment = mDiscussionEditText.getText().toString();
            if (!userComment.trim().isEmpty()) {
                mPresenter.onClickedSendComment(mDiscussionEditText.getText().toString());
                mDiscussionEditText.setText("");
            }
        }
    }
}