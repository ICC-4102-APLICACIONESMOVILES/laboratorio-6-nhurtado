package com.example.ing.myapplication;

import android.arch.persistence.room.Room;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class answer_template extends AppCompatActivity {
    private FormDatabase formDatabase;
    private static final String DATABASE_NAME = "forms_db";
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private Forms f;
    private FormLocation fl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer_template);
        formDatabase = Room.databaseBuilder(getApplicationContext(),
                FormDatabase.class, DATABASE_NAME)
                .allowMainThreadQueries()
                .build();
        setContentView(R.layout.activity_answer_template);
        Integer id = Integer.valueOf(getIntent().getStringExtra("Form_ID"));
        f = formDatabase.daoAccess().fetchOneFormsbyFormId(id);
        fl = formDatabase.daoAccess().fetchAnswerbyFormId(id);
        tv1 = (TextView) findViewById(R.id.textView);
        tv2 = (TextView) findViewById(R.id.textView1);
        tv3 = (TextView) findViewById(R.id.textView2);
        tv1.setText("Nombre: " + f.getFormName());
        if (fl != null) {
            tv2.setText("Latitud: " + fl.getLat());
            tv3.setText("Longitud: "+ fl.getLon());
        }
        else {
            tv2.setText("No se ha guardado ubicación \n de este formulario aún.");
            tv3.setText("");
        }
    }
}
