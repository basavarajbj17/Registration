package com.assign.registration;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

/**
 * Created by pawnish on 5/29/2017.
 */

public class JobType {

    @SerializedName("JobType")
    private String jobType;

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }
}
