package com.blogspot.cavemanbacktocave.myblelibrary;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;

public class Utils {

    public static GradientDrawable getAppsPrimaryColorAsGradientDrawable(Context context){
        GradientDrawable gd = new GradientDrawable(
                GradientDrawable.Orientation.TOP_BOTTOM,
                new int[] {ThemeUtils.resolvePrimaryColor(context),ThemeUtils.resolvePrimaryColor(context)});
        gd.setCornerRadius(20f);
        return gd;
    }

}
