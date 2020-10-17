package com.blogspot.cavemanbacktocave.myblelibrary;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class MyPermissionDialog  extends Dialog {
    private OnDialogButtonClick onDialogButtonClick;
    public interface OnDialogButtonClick{
        void buttonClickEventDialog(boolean okBtnClicked);
    }

    public MyPermissionDialog(@NonNull Context context, OnDialogButtonClick onDialogButtonClick) {
        super(context);
        this.onDialogButtonClick=onDialogButtonClick;
    }

    private Button okBtn,closeBtn;
    private TextView message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_mypermission);
        okBtn=findViewById(R.id.okBtn);
        closeBtn=findViewById(R.id.closeBtn);
        message=findViewById(R.id.message);
        message.setMovementMethod(LinkMovementMethod.getInstance());
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDialogButtonClick.buttonClickEventDialog(true);
            }
        });

        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDialogButtonClick.buttonClickEventDialog(false);
            }
        });

    }
}
