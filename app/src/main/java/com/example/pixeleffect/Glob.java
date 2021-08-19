package com.example.pixeleffect;

import android.graphics.Bitmap;
import android.media.session.PlaybackState;
import android.os.Environment;

import android.util.Log;

import java.io.File;
import java.util.ArrayList;

public class Glob {
    public static String Edit_Folder_name = "PixelEffect";
    public static final float HUE_CYAN = 180.0f;
    public static final float HUE_MAGENTA = 300.0f;
    public static final float HUE_VIOLET = 270.0f;
    public static ArrayList<String> IMAGEALLARY = new ArrayList<>();
    public static String acc_link = "https://play.google.com/store/apps/developer?id=Photo+Video+Zone";
    public static int appID = 43;
    public static String app_link = package_name="https://play.google.com/store/apps/details?id=photovideozone.pixeleffect&hl=en";
    public static String app_name = "Pixel Effect";
    public static String banner_image = "";
    public static String banner_link = "";
    public static String interstitial_image = "";
    public static String interstitial_link = "";
    public static String package_name = "https://play.google.com/store/apps/details?id=photovideozone.pixeleffect&hl=en";
    public static String privacy_link = "http://photovideozone.com/admin/policy.html";
    public static Bitmap txtBitmap;

    public static boolean createDirIfNotExists(String path) {
        File file = new File(Environment.getExternalStorageDirectory(), "/" + path);
        if (!file.exists()) {
            file.mkdir();
            if (!file.mkdirs()) {
                return false;
            }
            return true;
        }
        System.out.println("Can't create folder");
        return true;
    }

    public static void listAllImages(File filepath) {
        File[] files = filepath.listFiles();
        if (files != null) {
            for (int j = files.length - 1; j >= 0; j--) {
                String ss = files[j].toString();
                File check = new File(ss);
                Log.d("" + check.length(), "" + check.length());
                if (check.length() <= PlaybackState.ACTION_PLAY_FROM_MEDIA_ID) {
                    Log.i("Invalid Image", "Delete Image");
                } else if (check.toString().contains(".jpg") || check.toString().contains(".png") || check.toString().contains(".jpeg")) {
                    IMAGEALLARY.add(ss);
                }
                System.out.println(ss);
            }
            return;
        }
        System.out.println("Empty Folder");
    }
}
