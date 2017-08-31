package kmitl.lab03.nathapath58070040.simplemydot.model;

/**
 * Created by student on 8/25/2017 AD.
 */

public class Dot {

    public interface OnDotChangedListener {
        void onDotChanged(Dot dot);
    }

    public void setListener(OnDotChangedListener listener) {
        this.listener = listener;
    }

    private OnDotChangedListener listener;

    private int centerX;
    private int centerY;
    private int radius;

    public int getColorR() {
        return colorR;
    }

    public int getColorG() {
        return colorG;
    }

    public int getColorB() {
        return colorB;
    }

    private int colorR;
    private int colorG;
    private int colorB;

    public Dot(OnDotChangedListener listener, int centerX, int centerY, int radius, int colorR, int colorG, int colorB) {
        this.listener = listener;
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.colorR = colorR;
        this.colorG = colorG;
        this.colorB = colorB;
    }

    public Dot(int centerX, int centerY, int radius, int colorR, int colorG, int colorB) {

        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.colorR = colorR;
        this.colorG = colorG;
        this.colorB = colorB;

        this.listener.onDotChanged(this);
    }

    public int getCenterX() {
        return centerX;
    }

    public void setCenterX(int centerX) {
        this.centerX = centerX;

        this.listener.onDotChanged(this);
    }

    public int getCenterY() {
        return centerY;
    }

    public void setCenterY(int centerY) {
        this.centerY = centerY;

        this.listener.onDotChanged(this);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }


}
