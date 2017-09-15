package com.example.student.lab05_workshop1;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("LAB05");


        FragmentManager f = getSupportFragmentManager();
        f.beginTransaction()
                .replace(R.id.container, new BlankFragment().newInstance("Access From Activity"))
                .commit();


        Button btn = (Button) findViewById(R.id.btnAccess);
        btn.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
               FragmentManager f = getSupportFragmentManager();
                f.beginTransaction()
                        .replace(R.id.container, new BlankFragment().newInstance("From Activity"))
                        .commit();
            }
        });

    }


}
