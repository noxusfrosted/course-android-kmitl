package kmitl.lab05.nathapath58070040.simplemydot.model;

import android.graphics.Color;

import java.util.Random;

/**
 * Created by ASUS_A550JX on 21/9/2560.
 */

public class Colors {
    public Colors() {
    }

    public int getColor() {
        int red = new Random().nextInt(255);
        int green = new Random().nextInt(255);
        int blue = new Random().nextInt(255);
        return Color.rgb(red, green, blue);
    }
}
