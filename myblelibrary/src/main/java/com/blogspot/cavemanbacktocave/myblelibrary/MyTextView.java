package com.blogspot.cavemanbacktocave.myblelibrary;


import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

public class MyTextView extends AppCompatTextView {
    public MyTextView(@NonNull Context context) {
        super(context);
    }

    public MyTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        //todo:if an attribute is set, make sure it is used, or we need not use it
        setMyTypeFace(attrs.getAttributeValue("",""));
    }

    public MyTextView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setMyTypeFace(attrs.getAttributeValue("",""));
    }

    private void setMyTypeFace(String path){
        //set font
        //Typeface face= Typeface.createFromAsset(getContext().getAssets(), "Helvetica_Neue.ttf");
        /**
         * https://stackoverflow.com/questions/9477336/how-to-make-a-custom-textview
         * https://stackoverflow.com/users/1222926/sun
         * */
        Typeface face= Typeface.createFromAsset(getContext().getAssets(), path);
        this.setTypeface(face);
    }
}
