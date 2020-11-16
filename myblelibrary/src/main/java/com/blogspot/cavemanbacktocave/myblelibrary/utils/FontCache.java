package com.blogspot.cavemanbacktocave.myblelibrary.utils;

import android.content.Context;
import android.graphics.Typeface;

import java.util.Hashtable;

public class FontCache {
    /**
     * https://stackoverflow.com/questions/16648190/how-to-set-a-particular-font-for-a-button-text-in-android/16648457#16648457
     */
    private static Hashtable<String, Typeface> fontCache = new Hashtable<String, Typeface>();

    public static Typeface get(String name, Context context) {
        Typeface tf = fontCache.get(name);
        if (tf == null) {
            try {
                tf = Typeface.createFromAsset(context.getAssets(), name);
            } catch (Exception e) {
                return null;
            }
            fontCache.put(name, tf);
        }
        return tf;
    }
}
