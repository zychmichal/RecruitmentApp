package com.example.recruitmentapp;

public class JobOfferModel {
    private int id;
    private String jobTitle;
    private String companyName;
    private String location;
    private int salaryFrom;
    private int salaryTo;
    private String description;

    public JobOfferModel(int id, String jobTitle, String companyName, String location, int salaryFrom, int salaryTo, String description) {
        this.id = id;
        this.jobTitle = jobTitle;
        this.companyName = companyName;
        this.location = location;
        this.salaryFrom = salaryFrom;
        this.salaryTo = salaryTo;
        this.description = description;
    }

    public JobOfferModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getSalaryFrom() {
        return salaryFrom;
    }

    public void setSalaryFrom(int salaryFrom) {
        this.salaryFrom = salaryFrom;
    }

    public int getSalaryTo() {
        return salaryTo;
    }

    public void setSalaryTo(int salaryTo) {
        this.salaryTo = salaryTo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "JobTitle = " + jobTitle  +
                ",\n companyName = " + companyName +
                ",\n location = " + location  +
                ",\n salaryFrom = " + salaryFrom +
                ",\n salaryTo = " + salaryTo +
                ",\n description = " + description;
    }

}
