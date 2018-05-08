package com.example.ing.myapplication;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class QuestionTemplate extends AppCompatActivity {
    private FormDatabase formDatabase;
    private static final String DATABASE_NAME = "forms_db";
    private TextView tv1;
    private TextView tv2;
    private Forms f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        formDatabase = Room.databaseBuilder(getApplicationContext(),
                FormDatabase.class, DATABASE_NAME)
                .allowMainThreadQueries()
                .build();
        setContentView(R.layout.activity_question_template);
        Integer id = Integer.valueOf(getIntent().getStringExtra("Form_ID"));
        f = formDatabase.daoAccess().fetchOneFormsbyFormId(id);
        tv1 = (TextView) findViewById(R.id.textView);
        tv2 = (TextView) findViewById(R.id.textView1);
        tv1.setText("Nombre: "+f.getFormName());
        tv2.setText("Fecha: "+ f.getFormDate());
    }
}
