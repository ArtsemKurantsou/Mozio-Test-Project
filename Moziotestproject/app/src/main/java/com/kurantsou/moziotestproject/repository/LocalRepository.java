package com.kurantsou.moziotestproject.repository;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.kurantsou.moziotestproject.models.TestAnswers;

/**
 * Created by artem on 07.07.2017.
 */

public class LocalRepository implements AnswersRpository {

    private final String ANSWERS_KEY = "key_answers";
    private final String SHARED_PREFS_FILE = "mozo_test_project_shared_prefs";

    /**
     * Stored answers object in shared preferences
     *
     * @param context - Context, used for getting preferences
     * @param answers - Answers object to be stored
     */
    @Override
    public void storeAnswers(Context context, TestAnswers answers) {
        if (answers == null)
            return;
        SharedPreferences prefs = context.getSharedPreferences(SHARED_PREFS_FILE, Context.MODE_PRIVATE);
        if (prefs == null) return;
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String serializedAnswers = gson.toJson(answers);
        editor.putString(ANSWERS_KEY, serializedAnswers);
        editor.apply();
    }

    /**
     * Get stored answers from shared preferences
     *
     * @param context - Context, used for getting preferences
     * @return - Answers that was stored in the preferences or null if nothing is stored
     */
    @Override
    public TestAnswers getStoredAnswers(Context context) {
        if (context == null)
            return null;
        SharedPreferences prefs = context.getSharedPreferences(SHARED_PREFS_FILE, Context.MODE_PRIVATE);
        if (prefs == null)
            return null;
        String soredAnswers = prefs.getString(ANSWERS_KEY, null);
        if (soredAnswers == null || soredAnswers.isEmpty())
            return null;
        Gson gson = new Gson();
        return gson.fromJson(soredAnswers, TestAnswers.class);
    }
}
