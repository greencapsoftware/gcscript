package gcs.com.br.gcscript.lib;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.text.Editable;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import gcs.com.br.gcscript.R;

/**
 * Created by welisson on 21/10/16.
 */

public class GCSCriptUtils {

    public static void showToast(Context context, CharSequence text)
    {
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public static void showError(Context context, String message) {
        new AlertDialog.Builder(context)
                .setMessage(message)
                .setPositiveButton(android.R.string.yes, null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    public static String dateToString(Date date)
    {
        //SimpleDateFormat in= new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");

        return out.format(date);
    }

    public static Date addDays(Date date, int days)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return cal.getTime();
    }

    public static void openActivity(Context context, Class activityClass)
    {
        openActivity(context, activityClass, null);
    }

    public static void openActivity(Context context, Class activityClass, Bundle params)
    {
        Intent i = new Intent(context, activityClass);

        if (params != null)
            i.putExtras(params);

        context.startActivity(i);
    }

    public static void openYESNOMessage(Context context, String msg,
                                          DialogInterface.OnClickListener clSim,
                                          DialogInterface.OnClickListener clNao) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder.setTitle(R.string.app_name)
                .setMessage(msg)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setPositiveButton(R.string.yes, clSim)
                .setNegativeButton(R.string.no, clNao)						//Do nothing on no
                .show();
    }

    public static String cript(String text) {

        Random r = new Random();
        //r.setSeed(256);
        int x = r.nextInt(128);

        x = x < 33 ? x + 33 : x;

        String result = "" + (char)x;
        char c = ' ';
        int ci = 0;

        for (int i = 0; i < text.length(); i++) {
            c = text.charAt(i);

            ci = (int)c;
            ci += x;

            c = (char)ci;

            result += c;
        }

        return result;
    }

    public static String decript(String text) {

        String result = "";
        char c = ' ';
        int ci = 0;

        char t = text.charAt(0);
        int x = (int)t;

        text = text.substring(1);

        for (int i = 0; i < text.length(); i++) {
            c = text.charAt(i);

            ci = (int)c;
            ci -= x;

            c = (char)ci;

            result += c;
        }

        return result;

    }
}
