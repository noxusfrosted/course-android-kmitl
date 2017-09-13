package kmitl.lab03.nathapath58070040.simplemydot.model;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by ASUS_A550JX on 10/9/2560.
 */

public class Colors {
    public int createColor() {
        Random random = new Random();
        int red = random.nextInt(255);
        int green = random.nextInt(255);
        int blue = random.nextInt(255);

        return Color.rgb(red, green, blue);
    }


}
