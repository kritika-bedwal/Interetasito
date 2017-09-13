package com.example.akshay.parth;

import java.io.Serializable;

/**
 * Created by akshay on 10/9/17.
 */

public class JobSeekerInfo implements Serializable {

    private String Title;
    private String Description;
    private String phnNo;
    private String name;
    private String address;
    private String Segment;

    public JobSeekerInfo(){

    }
    public JobSeekerInfo(String title){
        Title=title;
        Description="This is for a plumber job";
        phnNo="8968923902";
        name="Akshay";
        address="haveli ke piche";
        Segment="nothing";



    }

    public void setTitleUser(String title) {
        Title = title;
    }

    public void setDescriptionUser(String description) {
        Description = description;
    }

    public void setPhnNoUser(String phnNo) {
        this.phnNo = phnNo;
    }

    public void setNameUser(String name) {
        this.name = name;
    }

    public void setAddressUser(String address) {
        this.address = address;
    }

    public String getTitleUser() {
        return Title;
    }

    public String getDescriptionUser() {
        return Description;
    }

    public String getPhnNoUser() {
        return phnNo;
    }

    public String getNameUser() {
        return name;
    }

    public String getAddressUser() {
        return address;
    }
}
