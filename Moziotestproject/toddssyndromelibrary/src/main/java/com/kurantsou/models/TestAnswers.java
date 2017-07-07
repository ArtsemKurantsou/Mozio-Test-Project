package com.kurantsou.models;

/**
 * Created by artem on 07.07.2017.
 */

public class TestAnswers {
    private boolean isHasMigraines;
    private boolean isMale;
    private int age;
    private boolean isUseDrugs;

    public TestAnswers() {
    }

    /**
     * Get migraines answer
     * @return true if user have it, otherwise false
     */
    public boolean getHasMigraines() {
        return isHasMigraines;
    }

    /**
     * Set migraines answer
     * @param hasMigraines - true if user have it
     */
    public void setHasMigraines(boolean hasMigraines) {
        this.isHasMigraines = hasMigraines;
    }

    /**
     * Get user sex
     * @return - true if user is male, false if female
     */
    public boolean getMale() {
        return isMale;
    }

    /**
     * Set user sex
     * @param male - true if user is male, false if female
     */
    public void setMale(boolean male) {
        this.isMale = male;
    }

    /**
     * Get user age
     * @return - user age
     */
    public int getAge() {
        return age;
    }

    /**
     * Set user age
     * @param age - user age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Get use drugs
     * @return - true if user use hallucinogenic drugs, otherwise - false
     */
    public boolean getUseDrugs() {
        return isUseDrugs;
    }

    /**
     * Set user drugs
     * @param useDrugs - true if user use hallucinogenic drugs otherwise - fasle
     */
    public void setUseDrugs(boolean useDrugs) {
        this.isUseDrugs = useDrugs;
    }
}
