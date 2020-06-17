package com.example.recruitmentapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

@SuppressLint("Registered")
public class AddJobActivity extends AppCompatActivity {

    Button btn_create;
    EditText et_jobTitle, et_companyName, et_location,
            et_description, et_salaryFrom, et_salaryTo;
    async asy;
    DataBaseHelper db;
    private StorageWrapper wrapper = StorageWrapper.storage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Show the Up button in the action bar.
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        btn_create = findViewById(R.id.btn_create);
        et_companyName = findViewById(R.id.et_companyName);
        et_description = findViewById(R.id.et_description);
        et_jobTitle = findViewById(R.id.et_jobTitle);
        et_location = findViewById(R.id.et_location);
        et_salaryFrom = findViewById(R.id.et_salaryFrom);
        et_salaryTo = findViewById(R.id.et_salaryTo);
        asy = new async(this);
        db = new DataBaseHelper(this);

        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                JobOfferModel jobOfferModel;
                try {
                    jobOfferModel = new JobOfferModel(-1, et_jobTitle.getText().toString(), et_companyName.getText().toString()
                            , et_location.getText().toString(), Integer.parseInt(et_salaryFrom.getText().toString()),
                            Integer.parseInt(et_salaryTo.getText().toString()), et_description.getText().toString());
                    Toast.makeText(AddJobActivity.this, "Job offer has been created", Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    Toast.makeText(AddJobActivity.this, "Error creating job offer", Toast.LENGTH_SHORT).show();
                    jobOfferModel = new JobOfferModel(-1, "error", "error", "error", 0, 0, "error");
                }

                asy.execute(jobOfferModel);
                int newId = wrapper.getLastJobOffer().getId() + 1;
                jobOfferModel.setId(newId);
                wrapper.addJobOffer(jobOfferModel);
                finish();

            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // This ID represents the Home or Up button. In the case of this
            // activity, the Up button is shown. Use NavUtils to allow users
            // to navigate up one level in the application structure. For
            // more details, see the Navigation pattern on Android Design:
            //
            // http://developer.android.com/design/patterns/navigation.html#up-vs-back
            //
            NavUtils.navigateUpTo(this, new Intent(this, ItemListActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
