package com.kurantsou.moziotestproject.models;

/**
 * Created by artem on 07.07.2017.
 */

public class TestAnswers {
    private boolean migrainesAns;
    private boolean sexAns;
    private int ageAns;
    private boolean drugsAns;

    public TestAnswers() {
    }

    public boolean getMigrainesAns() {
        return migrainesAns;
    }

    public void setMigrainesAns(boolean migrainesAns) {
        this.migrainesAns = migrainesAns;
    }

    public boolean getSexAns() {
        return sexAns;
    }

    public void setSexAns(boolean sexAns) {
        this.sexAns = sexAns;
    }

    public int getAgeAns() {
        return ageAns;
    }

    public void setAgeAns(int ageAns) {
        this.ageAns = ageAns;
    }

    public boolean getDrugsAns() {
        return drugsAns;
    }

    public void setDrugsAns(boolean drugsAns) {
        this.drugsAns = drugsAns;
    }
}
