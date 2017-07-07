package com.kurantsou.moziotestproject.repository;

import android.content.Context;

import com.kurantsou.moziotestproject.models.TestAnswers;

/**
 * Created by artem on 07.07.2017.
 */

public interface AnswersRpository {
    void storeAnswers(Context context, TestAnswers answers);
    TestAnswers getStoredAnswers(Context context);
}
