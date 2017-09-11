package kmitl.lab03.nathapath58070040.simplemydot.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

import kmitl.lab03.nathapath58070040.simplemydot.model.Dot;
import kmitl.lab03.nathapath58070040.simplemydot.model.Dots;

/**
 * Created by student on 8/25/2017 AD.
 */

public class DotView extends View {


    private Dots allDot;
    private Paint paint;


    public interface OnDotViewPressListener {
        void onDotViewPressed(int x, int y);
    }
    private OnDotViewPressListener onDotViewPressListener;


    public void setOnDotViewPressListener(
            OnDotViewPressListener onDotviewPressListener){
        this.onDotViewPressListener = onDotviewPressListener;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.allDot != null) {
            for (Dot dot : allDot.getAllDot()) {
                paint.setColor(dot.getColor());
                canvas.drawCircle(dot.getCenterX(),
                        dot.getCenterY(), 50, paint);

            }

        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                this.onDotViewPressListener
                        .onDotViewPressed(
                                (int) event.getX(),
                                (int) event.getY());
                return true;
        }
        return false;
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


    public void setDots(Dots dots) {
        this.allDot = dots;
    }
}
