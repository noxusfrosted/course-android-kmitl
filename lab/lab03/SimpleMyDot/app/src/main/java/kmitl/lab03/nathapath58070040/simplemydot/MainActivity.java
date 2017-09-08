package kmitl.lab03.nathapath58070040.simplemydot;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

import kmitl.lab03.nathapath58070040.simplemydot.model.Dot;
import kmitl.lab03.nathapath58070040.simplemydot.view.DotView;
import model.DotParcelable;
import model.DotSerializable;

public class MainActivity extends AppCompatActivity
        implements Dot.OnDotChangedListener {

    private DotView dotView;
    private Dot dot;
    private ArrayList<Dot> allDots;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnOpenActivity = (Button) findViewById(R.id.btnOpenActivity);

        final DotSerializable dotSerializable = new DotSerializable();
        dotSerializable.setCenterX(150);
        dotSerializable.setCenterY(150);
        dotSerializable.setColor(Color.RED);
        dotSerializable.setRadius(30);

        final DotParcelable dotParcelable = new DotParcelable(149, 149 , 29);


        btnOpenActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,
                        SecondActivity.class);

                intent.putExtra("xValue", 30);
                intent.putExtra("dotSerializable", dotSerializable);

                //parcelable
                intent.putExtra("dotParcelable", dotParcelable);
                startActivity(intent);
                finish();
            }
        });

        dotView = (DotView) findViewById(R.id.dotView);
        allDots = new ArrayList<>();

        dotView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    drawDot(event.getX(), event.getY());
                }
                return true;
            }
        });


    }

    private void drawDot(float x, float y) {
        Random random = new Random();
        int r = random.nextInt(255);
        int g = random.nextInt(255);
        int b = random.nextInt(255);
        Dot dot = new Dot(this, (int) x, (int) y, 30, r, g, b);
        allDots.add(dot);
        dotView.setDot(allDots);
        dotView.invalidate();
    }

    public void onRandomDot(View view) {
        //Random a dot
        Random random = new Random();
        int r = random.nextInt(255);
        int g = random.nextInt(255);
        int b = random.nextInt(255);
        dot = new Dot(this, 0, 0, 30, r, g, b);
        int centerX = random.nextInt(1000);
        int centerY = random.nextInt(1000);
        this.dot.setCenterX(centerX);
        this.dot.setCenterY(centerY);

        allDots.add(dot);


    }

    @Override
    public void onDotChanged(Dot dot) {
        dotView.setDot(allDots);
        dotView.invalidate();

    }

    public void onClear(View view) {
        allDots.clear();
        dotView.invalidate();
    }
}
