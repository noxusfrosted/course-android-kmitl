package com.example.noxusfrosted.moneyflow;

import android.arch.persistence.room.Room;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ToggleButton;

public class AddActivity extends AppCompatActivity{

    MoneyDB moneyDB;
    String type = "INCOME";
    EditText editTextOrder, editTextAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        ToggleButton toggleButton = findViewById(R.id.toggleType);
        toggleButton.setChecked(false);

        moneyDB = Room.databaseBuilder(this, MoneyDB.class, "MONEY").build();


        editTextOrder = findViewById(R.id.editTextOrder);
        editTextAmount = findViewById(R.id.editTextAmount);



    }



    public void onSubmit(View view){

        new AsyncTask<Void, Void, MoneyInfo>() {
            @Override
            protected MoneyInfo doInBackground(Void... voids) {
                MoneyInfo moneyInfo = new MoneyInfo();
                moneyInfo.setType(type);
                moneyInfo.setOrder(editTextOrder.getText().toString());
                moneyInfo.setAmount(editTextAmount.getText().toString());

                moneyDB.getMoneyInfoDAO().insert(moneyInfo);

                return null;
            }
        }.execute();
        finish();


    }

    public void changeType(View view){

        boolean checked =  ((ToggleButton) view).isChecked();
        if(checked){
            type = "EXPENSE";

        }else {
            type = "INCOME";
        }
    }



}
