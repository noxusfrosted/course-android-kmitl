package kmitl.lab03.nathapath58070040.simplemydot;


import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import kmitl.lab03.nathapath58070040.simplemydot.model.Colors;
import kmitl.lab03.nathapath58070040.simplemydot.model.Dot;
import kmitl.lab03.nathapath58070040.simplemydot.model.Dots;
import kmitl.lab03.nathapath58070040.simplemydot.view.DotView;


public class MainActivity extends AppCompatActivity
        implements Dots.OnDotsChangedListener, DotView.OnDotViewPressListener {

    private DotView dotView;
    private Dots dots;

    private Context context;


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
        Dot newDot = new Dot(centerX, centerY, 50, new Colors().getColor());
        dots.addDot(newDot);
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
            Dot newDot = new Dot(x, y, 50, new Colors().getColor());
            dots.addDot(newDot);
        } else {
            dots.removeBy(dotPosition);
        }

    }

    public void onShare(View view) {

        View v1 = dotView.getRootView();
        v1.setDrawingCacheEnabled(true);
        Bitmap bitmap = v1.getDrawingCache();

        context = getApplicationContext();

        Uri uri = getImageUri(context, bitmap);

        share_screen(uri, "facebook");
    }

    public static Uri getImageUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(),
                inImage, "", "");
        return Uri.parse(path);
    }

    public void share_screen(Uri pngUri, final String sharingapp) {

        Intent shareIntent = new Intent(android.content.Intent.ACTION_SEND);
        shareIntent.setType("image/png");
        shareIntent
                .putExtra(android.content.Intent.EXTRA_TEXT,
                        "your sharing text");
        shareIntent.putExtra(android.content.Intent.EXTRA_STREAM, pngUri); // Share
        // the
        // image
        // on
        // Facebook
        PackageManager pm = getApplicationContext().getPackageManager();
        List<ResolveInfo> activityList = pm.queryIntentActivities(shareIntent, 0);
        int c = 0;
        for (final ResolveInfo app : activityList) {
            if ((app.activityInfo.name).contains(sharingapp)) {
                c++;
                final ActivityInfo activity = app.activityInfo;
                final ComponentName name = new ComponentName(
                        activity.applicationInfo.packageName, activity.name);
                shareIntent.addCategory(Intent.CATEGORY_LAUNCHER);
                shareIntent.setComponent(name);
                startActivity(shareIntent);
                break;
            }

        }
        if (c == 1)
            c = 0;
        else {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(
                    context);
            alertDialog.setTitle("Alert");
            alertDialog.setMessage("You don't have " + sharingapp
                    + " installed.");
            alertDialog.setPositiveButton("OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,
                                            int which) {
                            dialog.dismiss();

                        }
                    });
            alertDialog.show();
        }

    }
}




