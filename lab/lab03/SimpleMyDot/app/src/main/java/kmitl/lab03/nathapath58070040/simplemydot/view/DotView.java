package kmitl.lab03.nathapath58070040.simplemydot.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

import kmitl.lab03.nathapath58070040.simplemydot.model.Dot;

/**
 * Created by student on 8/25/2017 AD.
 */

public class DotView extends View {

    private Paint paint;
    //private Dot dot;
    private ArrayList<Dot> allDots;

    /*public Dot getDot() {
        return dot;
    }*/

    public void setDot(ArrayList<Dot> allDots) {
        this.allDots = allDots;
    }




    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.RED);
        if (allDots != null) {
            for(Dot dot : allDots){
                canvas.drawCircle(dot.getCenterX(), dot.getCenterY(), 30, paint);
            }

        }

    }

    public DotView(Context context) {
        super(context);
        paint = new Paint();
    }

    public DotView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
    }

    public DotView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint();
    }

}
