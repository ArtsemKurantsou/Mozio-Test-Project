package com.kurantsou.models;

/**
 * Created by artem on 07.07.2017.
 */

public class ToddsSyndromeTest {
    private static final int MAX_SCROE = 4; // max score that user can get
    private static final int AGE = 15; // age

    /**
     * Calculate test result
     *
     * @param answers - answers of the test
     * @return test result in percents
     */
    public static int getResult(TestAnswers answers) {
        int score = 0;

        if (answers.getHasMigraines())
            score++;
        if (answers.getMale())
            score++;
        if (answers.getAge() <= AGE)
            score++;
        if (answers.getUseDrugs())
            score++;

        return score * 100 / MAX_SCROE;
    }
}
