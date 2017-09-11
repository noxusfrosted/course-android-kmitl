package kmitl.lab03.nathapath58070040.simplemydot.model;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 8/25/2017 AD.
 */

public class Dot {

    private int centerX;



    private int centerY;
    private int radius;
    private int color;

    public Dot(int centerX, int centerY, int radius) {
        this(centerX, centerY, radius, Color.RED);
    }


    public Dot(int centerX, int centerY, int radius, int color) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.color = color;
    }

    public int getCenterX() {
        return centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    public int getColor() {
        return color;
    }
}
