package kmitl.lab03.nathapath58070040.simplemydot;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;

import model.DotParcelable;
import model.DotSerializable;

public class SecondActivity extends AppCompatActivity {

    private DotSerializable dotSerializable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        TextView tvValueX = (TextView) findViewById(R.id.tvValueX);

        int x = getIntent().getIntExtra("xValue", 0);

        dotSerializable = (DotSerializable) getIntent().getSerializableExtra("dotSerializable");

        DotParcelable dotParcelable = (DotParcelable) getIntent().getParcelableExtra("dotParcelable");

        //tvValueX.setText(String.valueOf(x));


        //tvValueX.setText("centerX : " + dotSerializable.getCenterX() +
        //"\ncenterY : "+dotSerializable.getCenterY()+
        //        "\nRadius : "+ dotSerializable.getRadius() +
        //        "\nColor : "+dotSerializable.getColor()
        //);

        tvValueX.setText(dotParcelable.toString());
    }
}
