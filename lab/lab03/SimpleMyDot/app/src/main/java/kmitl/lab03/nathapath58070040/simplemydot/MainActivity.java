package kmitl.lab03.nathapath58070040.simplemydot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

import kmitl.lab03.nathapath58070040.simplemydot.model.Dot;
import kmitl.lab03.nathapath58070040.simplemydot.view.DotView;

public class MainActivity extends AppCompatActivity
implements Dot.OnDotChangedListener{

    private DotView dotView;
    private Dot dot;
    private ArrayList<Dot> allDots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dotView = (DotView) findViewById(R.id.dotView);

        allDots = new ArrayList<>();
    }

    public void onRandomDot(View view) {
        //Random a dot

        dot = new Dot(this, 0, 0, 30);
        Random random = new Random();
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

    public void onClear(View view){
        allDots.clear();
        dotView.invalidate();
    }
}
