package com.blogspot.cavemanbacktocave.myblelibrary;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;

public class MyPermissionDialog extends Dialog {
    private OnDialogButtonClick onDialogButtonClick;
    private Activity activity;

    private String dialogTitle = null;
    private String dialogDescription = null;
    private String hyperLinkText = null;
    private String urlToRedirect = null;
    private int colorOfOKButton = -1, colorOfCancelButton = -1;

    public interface OnDialogButtonClick {
        void buttonClickEventDialog(boolean okBtnClicked);
    }

    /*public MyPermissionDialog(@NonNull Context context, OnDialogButtonClick onDialogButtonClick) {
        super(context);
        this.activity=activity;
        this.onDialogButtonClick=onDialogButtonClick;
    }*/

    public MyPermissionDialog(@NonNull Context context, Activity activity,
                              OnDialogButtonClick onDialogButtonClick, String dialogTitle, String dialogDescription,
                              String hyperLinkText, String urlToRedirect, int colorOfOKButton, int colorOfCancelButton) {
        super(context);
        this.activity = activity;
        this.onDialogButtonClick = onDialogButtonClick;
        this.dialogTitle = dialogTitle;
        this.dialogDescription = dialogDescription;
        this.hyperLinkText = hyperLinkText;
        this.urlToRedirect = urlToRedirect;
        this.colorOfOKButton = colorOfOKButton;
        this.colorOfCancelButton = colorOfCancelButton;
    }

    public MyPermissionDialog(@NonNull Context context, Activity activity,) {
        super(context);
        this.activity = activity;
    }

    private Button okBtn, closeBtn;
    private TextView message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_mypermission);
        okBtn = findViewById(R.id.okBtn);
        closeBtn = findViewById(R.id.closeBtn);
        message = findViewById(R.id.message);
        message.setMovementMethod(LinkMovementMethod.getInstance());
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onDialogButtonClick != null) {
                    onDialogButtonClick.buttonClickEventDialog(true);
                }
                ActivityCompat.requestPermissions(activity,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MyPermissions.BLE_LOCATION_PERMISSION_CODE);
                dismiss();
            }
        });

        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onDialogButtonClick != null) {
                    onDialogButtonClick.buttonClickEventDialog(false);
                }
                dismiss();
            }
        });

        closeBtn.setBackground(Utils.getAppsPrimaryColorAsGradientDrawable(getContext()));
        okBtn.setBackground(Utils.getAppsPrimaryColorAsGradientDrawable(getContext()));

    }


}
