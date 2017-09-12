package kmitl.lab03.nathapath58070040.simplemydot;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;

import android.support.v4.content.FileProvider;

import android.support.v7.app.AppCompatActivity;
import android.view.View;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

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


    public void onRandomDot(View view) {
        Random random = new Random();
        int centerX = random.nextInt(dotView.getWidth());
        int centerY = random.nextInt(dotView.getHeight());
        Dot newDot = new Dot(centerX, centerY, 30, new Colors().getColor());
        dots.addDot(newDot);
    }

    public void onUndo(View view){
        dots.undoDot();
    }

    public void onRemoveAll(View view) {
        dots.clearAll();
    }


    @Override
    public void onDotChanged(Dots dots) {
        dotView.setDots(dots);
        dotView.invalidate();
    }

    @Override
    public void onDotViewPressed(int x, int y) {
        int dotPosition = dots.findDot(x, y);
        if (dotPosition == -1) {
            Dot newDot = new Dot(x, y, 30, new Colors().getColor());
            dots.addDot(newDot);
        } else {
            dots.removeBy(dotPosition);
        }

    }

    public void onShare(View view) {
        Bitmap bitmap = getBitmapFromView(dotView);
        saveBitmap(bitmap);
        File imagePath = new File(this.getCacheDir(), "images");
        File newFile = new File(imagePath, "image.png");
        Uri contentUri = FileProvider.getUriForFile(this, "kmitl.lab03.nathapath58070040.simplemydot.fileprovider", newFile);
        if (contentUri != null) {
            Intent shareIntent = new Intent();
            shareIntent.setAction(Intent.ACTION_SEND);
            shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION); // temp permission for receiving app to read this file
            shareIntent.setDataAndType(contentUri, getContentResolver().getType(contentUri));
            shareIntent.putExtra(Intent.EXTRA_STREAM, contentUri);
            startActivity(Intent.createChooser(shareIntent, "Choose an app"));
        }
    }

    public static Bitmap getBitmapFromView(View view) {
        Bitmap returnedBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(returnedBitmap);
        Drawable bgDrawable = view.getBackground();
        if (bgDrawable != null)
            bgDrawable.draw(canvas);
        else
            canvas.drawColor(Color.WHITE);
        view.draw(canvas);
        return returnedBitmap;
    }

    private void saveBitmap(Bitmap bitmap) {
        try {
            File cachePath = new File(this.getCacheDir(), "images");
            cachePath.mkdirs();
            FileOutputStream stream = new FileOutputStream(cachePath + "/image.png");
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}




