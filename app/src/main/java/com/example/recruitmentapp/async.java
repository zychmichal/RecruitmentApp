package com.example.recruitmentapp;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

public class async extends AsyncTask<JobOfferModel, Void, Boolean> {
    Context context;
    DataBaseHelper db;
    Boolean result;
    async(Context ct){
        context = ct;
        db = new DataBaseHelper(ct);
    }



    @Override
    protected Boolean doInBackground(JobOfferModel... jobOfferModels) {
        JobOfferModel jobOffer = jobOfferModels[0];
        result = db.addOne(jobOffer);
        return result;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        Toast.makeText(context, "Data Inserted: "+aBoolean, Toast.LENGTH_LONG).show();
    }
}
