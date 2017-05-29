package com.assign.registration;

import com.google.gson.annotations.SerializedName;

/**
 * Created by pawnish on 5/29/2017.
 */

public class EducationalQualification {

    @SerializedName("Qualification")
    private String qualification;

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
}
