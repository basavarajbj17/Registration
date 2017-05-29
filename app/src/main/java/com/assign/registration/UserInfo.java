package com.assign.registration;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class UserInfo {
    @SerializedName("name")
    public String name;

    @SerializedName("gender")
    public String gender;

    @SerializedName("phoneNumber")
    public String phoneNumber;

    @SerializedName("emailId")
    public String emailId;

    @SerializedName("jobType")
    public String jobType;

    @SerializedName("photoBitmap")
    public String photoBitmap;

    @SerializedName("address")
    public String address;

    @SerializedName("latitude")
    public String latitude;

    @SerializedName("longitude")
    public String longitude;

    @SerializedName("educaitonalQualification")
    public List<String> educaitonalQualification = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getPhotoBitmap() {
        return photoBitmap;
    }

    public void setPhotoBitmap(String photoBitmap) {
        this.photoBitmap = photoBitmap;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public List<String> getEducaitonalQualification() {
        return educaitonalQualification;
    }

    public void setEducaitonalQualification(List<String> educaitonalQualification) {
        this.educaitonalQualification = educaitonalQualification;
    }
}
