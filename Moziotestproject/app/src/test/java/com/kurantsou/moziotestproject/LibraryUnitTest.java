package com.kurantsou.moziotestproject;

import com.kurantsou.models.*;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by artem on 07.07.2017.
 */

public class LibraryUnitTest{
    @Test
    public void testResultTest() throws Exception {
        TestAnswers answers = new TestAnswers();

        answers.setAge(10);
        answers.setHasMigraines(true);
        answers.setMale(true);
        answers.setUseDrugs(true);

        Assert.assertEquals(ToddsSyndromeTest.getResult(answers), 100);

        answers.setAge(20);
        answers.setHasMigraines(false);
        answers.setMale(false);
        answers.setUseDrugs(false);

        Assert.assertEquals(ToddsSyndromeTest.getResult(answers), 0);

        answers.setAge(10);
        answers.setHasMigraines(false);
        answers.setMale(false);
        answers.setUseDrugs(false);

        Assert.assertEquals(ToddsSyndromeTest.getResult(answers), 25);

        answers.setAge(20);
        answers.setHasMigraines(true);
        answers.setMale(false);
        answers.setUseDrugs(false);

        Assert.assertEquals(ToddsSyndromeTest.getResult(answers), 25);

        answers.setAge(20);
        answers.setHasMigraines(false);
        answers.setMale(true);
        answers.setUseDrugs(false);

        Assert.assertEquals(ToddsSyndromeTest.getResult(answers), 25);

        answers.setAge(20);
        answers.setHasMigraines(false);
        answers.setMale(false);
        answers.setUseDrugs(true);

        Assert.assertEquals(ToddsSyndromeTest.getResult(answers), 25);

        answers.setAge(20);
        answers.setHasMigraines(true);
        answers.setMale(true);
        answers.setUseDrugs(false);

        Assert.assertEquals(ToddsSyndromeTest.getResult(answers), 50);

        answers.setAge(10);
        answers.setHasMigraines(false);
        answers.setMale(false);
        answers.setUseDrugs(true);

        Assert.assertEquals(ToddsSyndromeTest.getResult(answers), 50);

    }
}
