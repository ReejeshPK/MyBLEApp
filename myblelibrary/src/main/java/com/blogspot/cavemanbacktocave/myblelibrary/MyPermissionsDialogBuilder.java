package com.blogspot.cavemanbacktocave.myblelibrary;

import android.app.Activity;
import android.content.Context;

public class MyPermissionsDialogBuilder {

    private Context context=null;
    private MyPermissionDialog.OnDialogButtonClick onDialogButtonClick=null;

    private String dialogTitle=null;
    private String dialogDescription=null;
    private String hyperLinkText=null;
    private String urlToRedirect=null;
    private int colorOfOKButton=-1;
    private int colorOfCancelButton=-1;

    public MyPermissionsDialogBuilder() {
    }

    public MyPermissionDialog build(Activity activity){
        /**These two are  needed for sure parameters*/
        return new MyPermissionDialog(activity,activity,onDialogButtonClick,dialogTitle,dialogDescription,hyperLinkText,urlToRedirect,colorOfOKButton,colorOfCancelButton);
    }

    public MyPermissionsDialogBuilder setDialogTitle(String dialogTitle){
        this.dialogTitle=dialogTitle;
        return this;
    }

    public MyPermissionsDialogBuilder setDialogDescription(String dialogDescription) {
        this.dialogDescription = dialogDescription;
        return this;
    }

    public MyPermissionsDialogBuilder setHyperLinkText(String hyperLinkText) {
        this.hyperLinkText = hyperLinkText;
        return this;
    }

    public MyPermissionsDialogBuilder setUrlToRedirect(String urlToRedirect) {
        this.urlToRedirect = urlToRedirect;
        return this;
    }

    public MyPermissionsDialogBuilder setOnDialogButtonClick(MyPermissionDialog.OnDialogButtonClick onDialogButtonClick) {
        this.onDialogButtonClick = onDialogButtonClick;
        return this;
    }

    public void setColorOfOKButton(int colorOfOKButton) {
        this.colorOfOKButton = colorOfOKButton;
    }

    public void setColorOfCancelButton(int colorOfCancelButton) {
        this.colorOfCancelButton = colorOfCancelButton;
    }
}
