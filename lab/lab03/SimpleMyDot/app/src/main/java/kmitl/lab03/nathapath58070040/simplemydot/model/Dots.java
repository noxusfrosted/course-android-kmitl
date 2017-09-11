package kmitl.lab03.nathapath58070040.simplemydot.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS_A550JX on 10/9/2560.
 */

public class Dots {


    public void clearAll() {
        allDot.clear();
        this.listener.onDotChanged(this);
    }

    public void removeBy(int dotPosition) {
        allDot.remove(dotPosition);
        this.listener.onDotChanged(this);
    }


    public interface OnDotsChangedListener {
        void onDotChanged(Dots dots);
    }

    private OnDotsChangedListener listener;

    public void setListener(OnDotsChangedListener listener){
        this.listener = listener;
    }

    private List<Dot> allDot = new ArrayList<>();
    public List<Dot> getAllDot(){
        return allDot;
    }
    public void addDot(Dot dot){
        this.allDot.add(dot);
        this.listener.onDotChanged(this);
    }

    public int findDot(int x, int y){
        for(int i = 0; i < allDot.size(); i++){
            int centerX = allDot.get(i).getCenterX();
            int centerY = allDot.get(i).getCenterY();
            double distance = Math.sqrt(Math.pow(centerX-x, 2)) +
                    Math.sqrt(Math.pow(centerY-y, 2));
            if (distance<=50){
                return i;
            }
        }
        return -1;
    }

}
