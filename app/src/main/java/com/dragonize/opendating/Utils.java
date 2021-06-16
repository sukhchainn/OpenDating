package com.dragonize.opendating;

import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;

import com.bumptech.glide.Glide;
import com.dragonize.opendating.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class Utils {
    Context c;
    AlertDialog alert;
    ProgressBar loading;
    ImageView loading_image;
    private CalendarView calendar;

    String date;

    public Utils(Context context) {
        c = context;

        calendar = new CalendarView(c);
        loading = new ProgressBar(c);
        loading_image = new ImageView(c);

        loading_image.setLayoutParams(new LinearLayout.LayoutParams(400, 400));
        Glide.with(c).load(R.raw.heart_loader)
                .thumbnail(Glide.with(c).load(R.raw.heart_loader))
                .fitCenter()
                .into(loading_image);

        alert = new AlertDialog.Builder(c, R.style.CustomDialog).setView(loading_image).create();
    }

    public void showLoading() {
        alert.show();
    }
    public void hideLoading() {
        alert.dismiss();
    }

    public boolean isOnline()
    {
        try
        {
            ConnectivityManager cm = (ConnectivityManager) c.getSystemService(Context.CONNECTIVITY_SERVICE);
            return cm.getActiveNetworkInfo().isConnectedOrConnecting();
        }
        catch (Exception e)
        {
            return false;
        }
    }

    /**
     * Expects date in <code>yyyy-MM-dd</code> format
     * @param date the given Date.
     * @param by the number of days ahead .
     */
    public String getFutureDayBy(String date, int by) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat con = new SimpleDateFormat("dd-MM-yyyy");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(sdf.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.add(Calendar.DATE, by);  // number of days to add
        date = con.format(c.getTime());  // date is now the new date

        return date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean hasPermissions(Context context, String... permissions) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }

}
