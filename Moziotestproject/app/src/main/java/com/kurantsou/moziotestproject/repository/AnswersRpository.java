package com.kurantsou.moziotestproject.repository;

import android.content.Context;

import com.kurantsou.models.TestAnswers;

/**
 * Created by artem on 07.07.2017.
 */

public interface AnswersRpository {
    /**
     * Store user answers
     * @param context - context, used for storage
     * @param answers - user answers
     */
    void storeAnswers(Context context, TestAnswers answers);

    /**
     * Get stored answers
     * @param context - context, used for storage
     * @return user answers
     */
    TestAnswers getStoredAnswers(Context context);
}
