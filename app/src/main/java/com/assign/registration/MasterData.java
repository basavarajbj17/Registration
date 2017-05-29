package com.assign.registration;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MasterData {

    @SerializedName("EducationalQualification")
    private List<EducationalQualification> educationalQualification = null;

    @SerializedName("JobTypes")
    private List<JobType> jobTypes = null;

    public List<EducationalQualification> getEducationalQualification() {
        return educationalQualification;
    }

    public void setEducationalQualification(List<EducationalQualification> educationalQualification) {
        this.educationalQualification = educationalQualification;
    }

    public List<JobType> getJobTypes() {
        return jobTypes;
    }

    public void setJobTypes(List<JobType> jobTypes) {
        this.jobTypes = jobTypes;
    }
}

