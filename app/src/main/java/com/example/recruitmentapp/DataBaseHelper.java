package com.example.recruitmentapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String JOB_OFFER_TABLE = "JOB_OFFER_TABLE";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_JOB_TITLE = "JOB_TITLE";
    public static final String COLUMN_COMPANY_NAME = "COMPANY_NAME";
    public static final String COLUMN_LOCATION = "LOCATION";
    public static final String COLUMN_SALARY_FROM = "SALARY_FROM";
    public static final String COLUMN_SALARY_TO = "SALARY_TO";
    public static final String COLUMN_DESCRIPTION = "DESCRIPTION";

    public DataBaseHelper(@Nullable Context context) {
        super(context, "jobOffer.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + JOB_OFFER_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_JOB_TITLE + " TEXT, " + COLUMN_COMPANY_NAME + " TEXT, " + COLUMN_LOCATION + " TEXT, " + COLUMN_SALARY_FROM + " INT, " + COLUMN_SALARY_TO + " INT, " + COLUMN_DESCRIPTION + " TEXT)";

        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean addOne(JobOfferModel jobOfferModel){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_JOB_TITLE , jobOfferModel.getJobTitle());
        cv.put(COLUMN_COMPANY_NAME, jobOfferModel.getCompanyName());
        cv.put(COLUMN_LOCATION, jobOfferModel.getLocation());
        cv.put(COLUMN_SALARY_FROM, jobOfferModel.getSalaryFrom());
        cv.put(COLUMN_SALARY_TO, jobOfferModel.getSalaryTo());
        cv.put(COLUMN_DESCRIPTION, jobOfferModel.getDescription());

        long insert = db.insert(JOB_OFFER_TABLE, null, cv);
        if(insert == -1){
            return false;
        }
        else {
            return true;
        }
    }

    public List<JobOfferModel> getAllJobOffers() {

        List<JobOfferModel> returnList = new ArrayList<>();

        String queryString = "SELECT * FROM " + JOB_OFFER_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(queryString, null);

        if(cursor.moveToFirst()) {
            do {
                int customerID = cursor.getInt(0);
                String jobOffer = cursor.getString(1);
                String companyName = cursor.getString(2);
                String location = cursor.getString(3);
                int salaryFrom = cursor.getInt(4);
                int salaryTo = cursor.getInt(5);
                String description = cursor.getString(6);

                JobOfferModel newJobOffer = new JobOfferModel(customerID, jobOffer, companyName, location, salaryFrom, salaryTo, description);
                returnList.add(newJobOffer);

            } while(cursor.moveToNext());
        }
        else {

        }

        cursor.close();
        db.close();
        return returnList;




    }


}
