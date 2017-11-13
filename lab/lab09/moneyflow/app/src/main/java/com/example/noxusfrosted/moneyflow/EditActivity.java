package com.example.noxusfrosted.moneyflow;

import android.arch.persistence.room.Room;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ToggleButton;

public class EditActivity extends AppCompatActivity{

    MoneyDB moneyDB;
    String type, order, amount;
    EditText editTextOrder, editTextAmount;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        i = getIntent().getIntExtra("id", 0);
        type = getIntent().getStringExtra("type");
        order = getIntent().getStringExtra("order");
        amount = getIntent().getStringExtra("amount");

        moneyDB = Room.databaseBuilder(this, MoneyDB.class, "MONEY").build();

        ToggleButton toggleButton = findViewById(R.id.toggleType);
        if (type.equals("INCOME")){
            toggleButton.setChecked(false);
        }else {
            toggleButton.setChecked(true);
        }


        editTextOrder = findViewById(R.id.editTextOrder);
        editTextAmount = findViewById(R.id.editTextAmount);



        editTextOrder.setText(order);
        editTextAmount.setText(amount);
    }

    public void changeType(View view){

        boolean checked =  ((ToggleButton) view).isChecked();
        if(checked){
            type = "EXPENSE";

        }else {
            type = "INCOME";
        }
    }



    public void onSubmitEdit(View view){

        new AsyncTask<Void, Void, MoneyInfo>() {
            @Override
            protected MoneyInfo doInBackground(Void... voids) {
                MoneyInfo moneyInfo = new MoneyInfo();
                moneyInfo.setId(i);
                moneyInfo.setType(type);
                moneyInfo.setOrder(editTextOrder.getText().toString());
                moneyInfo.setAmount(editTextAmount.getText().toString());

                moneyDB.getMoneyInfoDAO().updateMoney(moneyInfo);

                return null;
            }
        }.execute();
        finish();

    }

    public void onDelete(View view){

        new AsyncTask<Void, Void, MoneyInfo>() {
            @Override
            protected MoneyInfo doInBackground(Void... voids) {
                MoneyInfo moneyInfo = new MoneyInfo();
                moneyInfo.setId(i);
                moneyDB.getMoneyInfoDAO().deleteMoney(moneyInfo);

                return null;
            }
        }.execute();
        finish();
    }

    public void onCancel(View view){
        finish();
    }

}
