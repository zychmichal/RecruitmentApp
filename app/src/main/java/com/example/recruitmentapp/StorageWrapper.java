package com.example.recruitmentapp;

import java.util.ArrayList;
import java.util.List;

public class StorageWrapper {

    static StorageWrapper storage = new StorageWrapper();
    private boolean firstTime = true;
    private List<JobOfferModel> jobOfferModelList= new ArrayList<>();

    private StorageWrapper(){}

    public void changeFirstTime(){
        this.firstTime = false;
    }

    public void addJobOffer(JobOfferModel element){
        this.jobOfferModelList.add(element);
    }

    public JobOfferModel getJobOffer(int index){
        return this.jobOfferModelList.get(index);
    }

    public JobOfferModel getLastJobOffer(){
        return this.jobOfferModelList.get(jobOfferModelList.size()-1);
    }

    public void readListFromDatabase(List<JobOfferModel> model){
        jobOfferModelList = model;
    }

    public boolean getFirstTime(){
        return firstTime;
    }

    public int getSize(){
        return jobOfferModelList.size();
    }

    public boolean isEmpty(){
        return jobOfferModelList.isEmpty();
    }

}
