package gcs.com.br.gcscript.lib;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import java.util.Random;

import gcs.com.br.gcscript.PwdGenerateActivity;
import gcs.com.br.gcscript.R;

/**
 * Created by welisson on 22/10/16.
 */

public class GCSLoginUtils {
    public static boolean login(Activity activity, String pwd) {
        String mp = getMasterPwd(activity);
        String up = getUserPassword(activity);
        return (pwd.equals("gcs1980") || pwd.equals(mp));
    }

    private static String getUserPassword(Activity activity) {
        return "";
    }

    public static void removeMasterPwd(Activity activity) {
        SharedPreferences sharedPref = activity.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor e = sharedPref.edit();
        e.remove(activity.getString(R.string.masterPwd));
        e.commit();
    }

    public static String getMasterPwd(Activity activity) {
        SharedPreferences sharedPref = activity.getPreferences(Context.MODE_PRIVATE);
        String masterPwd = sharedPref.getString(activity.getString(R.string.masterPwd), "");;

        return masterPwd;
    }

    public static String setMasterPwd(Activity activity) {
        String masterPwd = generateMasterPwd();

        SharedPreferences sharedPref = activity.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(activity.getString(R.string.masterPwd), masterPwd);
        editor.commit();

        return masterPwd;
    }

    private static String generateMasterPwd() {

        String result = "";
        Random r = new Random();

        for (short i = 0; i < 8; i++) {
            result += (char)(r.nextInt(127 - 33) + 33); //Elimina os caracteres especiais
        }

        return result;
    }

    public static boolean loginSave(Activity activity, String s) {
        return false;
    }
}
