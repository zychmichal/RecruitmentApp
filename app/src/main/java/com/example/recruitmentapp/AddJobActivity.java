package com.example.recruitmentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

@SuppressLint("Registered")
public class AddJobActivity extends AppCompatActivity {

    Button btn_create;
    EditText et_jobTitle, et_companyName, et_location,
            et_description, et_salaryFrom, et_salaryTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_create = findViewById(R.id.btn_create);
        et_companyName = findViewById(R.id.et_companyName);
        et_description = findViewById(R.id.et_description);
        et_jobTitle = findViewById(R.id.et_jobTitle);
        et_location = findViewById(R.id.et_location);
        et_salaryFrom = findViewById(R.id.et_salaryFrom);
        et_salaryTo = findViewById(R.id.et_salaryTo);

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

                DataBaseHelper dataBaseHelper = new DataBaseHelper(AddJobActivity.this);

                boolean success = dataBaseHelper.addOne(jobOfferModel);

                Toast.makeText(AddJobActivity.this, "Success= " + success, Toast.LENGTH_SHORT).show();


            }
        });

    }
}
