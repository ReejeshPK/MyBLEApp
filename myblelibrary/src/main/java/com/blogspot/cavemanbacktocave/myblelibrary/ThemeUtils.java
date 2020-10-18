package com.blogspot.cavemanbacktocave.myblelibrary;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;

import static android.graphics.Color.parseColor;
import static android.os.Build.VERSION.SDK_INT;
import static android.os.Build.VERSION_CODES.LOLLIPOP;

public class ThemeUtils {
    /**
     * Reference: https://stackoverflow.com/a/29043405/7710739
     * */
    // material_deep_teal_500
    static final int FALLBACK_COLOR = parseColor("#009688");

    private ThemeUtils() {
        // no instances
    }

    static boolean isAtLeastL() {
        return SDK_INT >= LOLLIPOP;
    }

    @TargetApi(LOLLIPOP)
    static int resolveAccentColor(Context context) {
        Resources.Theme theme = context.getTheme();

        // on Lollipop, grab system colorAccent attribute
        // pre-Lollipop, grab AppCompat colorAccent attribute
        // finally, check for custom mp_colorAccent attribute
        int attr = isAtLeastL() ? android.R.attr.colorAccent : R.attr.colorAccent;
        //TypedArray typedArray = theme.obtainStyledAttributes(new int[] { attr, R.attr.mp_colorAccent });
        TypedArray typedArray = theme.obtainStyledAttributes(new int[] { attr, R.attr.colorAccent });

        int accentColor = typedArray.getColor(0, FALLBACK_COLOR);
        accentColor = typedArray.getColor(1, accentColor);
        typedArray.recycle();

        return accentColor;
    }

    @TargetApi(LOLLIPOP)
    static int resolvePrimaryColor(Context context) {
        Resources.Theme theme = context.getTheme();

        // on Lollipop, grab system colorAccent attribute
        // pre-Lollipop, grab AppCompat colorAccent attribute
        // finally, check for custom mp_colorAccent attribute
        int attr = isAtLeastL() ? android.R.attr.colorPrimary : R.attr.colorPrimary;
        //TypedArray typedArray = theme.obtainStyledAttributes(new int[] { attr, R.attr.mp_colorAccent });
        TypedArray typedArray = theme.obtainStyledAttributes(new int[] { attr, R.attr.colorPrimary });

        int colorPrimary = typedArray.getColor(0, FALLBACK_COLOR);
        colorPrimary = typedArray.getColor(1, colorPrimary);
        typedArray.recycle();

        return colorPrimary;
    }
}
