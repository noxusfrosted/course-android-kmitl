package kmitl.lab03.nathapath58070040.simplemydot;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

import kmitl.lab03.nathapath58070040.simplemydot.model.Colors;
import kmitl.lab03.nathapath58070040.simplemydot.model.Dot;
import kmitl.lab03.nathapath58070040.simplemydot.model.Dots;
import kmitl.lab03.nathapath58070040.simplemydot.view.DotView;


public class MainActivity extends AppCompatActivity
        implements Dots.OnDotsChangedListener, DotView.OnDotViewPressListener {

    private DotView dotView;
    private Dots dots;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        dotView = (DotView) findViewById(R.id.dotView);
        dotView.setOnDotViewPressListener(this);


        dots = new Dots();
        dots.setListener(this);


    }



    public void onRandomDot(View view){
        Random random = new Random();
        int centerX = random.nextInt(dotView.getWidth());
        int centerY = random.nextInt(dotView.getHeight());
        Dot newDot = new Dot(centerX, centerY, 30, new Colors().getColor());
        dots.addDot(newDot);
    }

    public void onRemoveAll(View view){
        dots.clearAll();
    }



    @Override
    public void onDotChanged(Dots dots){
        dotView.setDots(dots);
        dotView.invalidate();
    }

    @Override
    public void onDotViewPressed(int x, int y){
        int dotPosition = dots.findDot(x, y);
        if(dotPosition == -1) {
            Dot newDot = new Dot(x, y, 30, new Colors().getColor());
            dots.addDot(newDot);
        }
        else{
            dots.removeBy(dotPosition);
        }

    }
}
