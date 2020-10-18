package com.blogspot.cavemanbacktocave.myblelibrary;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

public class CustomFontHelper {
    /**
     * Ref font:
     * https://stackoverflow.com/questions/12128331/how-to-change-fontfamily-of-textview-in-android
     *
     * https://stackoverflow.com/questions/16901930/memory-leaks-with-custom-font-for-set-custom-font/16902532#16902532
     *
     * https://stackoverflow.com/questions/16648190/how-to-set-a-particular-font-for-a-button-text-in-android/16648457#16648457
     * */

    /**
     * Sets a font on a textview based on the custom com.my.package:font attribute
     * If the custom font attribute isn't found in the attributes nothing happens
     *
     * @param textview
     * @param context
     * @param font
     */
  /*  public static void setCustomFont(TextView textview, Context context, String font) {
        //TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CustomFont);
        //String font = a.getString(R.styleable.CustomFont_font);
        setCustomFont(textview, font, context);
        //a.recycle();
    }*/

    /**
     * Sets a font on a textview
     *
     * @param textview
     * @param font
     * @param context
     */
    public static void setCustomFont(TextView textview, String font, Context context) {
        if (font == null) {
            return;
        }
        Typeface tf = FontCache.get(font, context);
        Log.d("MyPermissionDialog", "setCustomFont: ");
        if (tf != null) {
            Log.d("MyPermissionDialog", "setCustomFont: tf not null ");
            textview.setTypeface(tf);
        }
    }
}
