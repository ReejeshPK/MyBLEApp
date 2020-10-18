package com.blogspot.cavemanbacktocave.myblelibrary;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;

public class MyPermissionsDialogBuilder {
    /**
     * Builder Pattern
     * Ref: https://www.vogella.com/tutorials/DesignPatternBuilder/article.html
     */

    private Context context = null;
    private MyPermissionDialog.OnDialogButtonClick onDialogButtonClick = null;

    private String dialogTitle = null;
    private String dialogDescription = null;
    private String hyperLinkText = null;
    private String urlToRedirect = null;
    private int colorOfOKButton = -1;
    private int colorOfCancelButton = -1;
    private String fontNameInAssetsFontsFolder = null;

    public MyPermissionsDialogBuilder() {
    }

    public MyPermissionDialog build(Activity activity) {
        /**These two are  needed for sure parameters*/
        return new MyPermissionDialog(activity, activity, onDialogButtonClick, dialogTitle, dialogDescription, hyperLinkText, urlToRedirect, colorOfOKButton, colorOfCancelButton, fontNameInAssetsFontsFolder);
    }

    public MyPermissionsDialogBuilder setDialogTitle(String dialogTitle) {
        this.dialogTitle = dialogTitle;
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

    public MyPermissionsDialogBuilder setColorOfOKButton(int colorOfOKButton) {
        this.colorOfOKButton = colorOfOKButton;
        return this;
    }

    public MyPermissionsDialogBuilder setColorOfCancelButton(int colorOfCancelButton) {
        this.colorOfCancelButton = colorOfCancelButton;
        return this;
    }

    public MyPermissionsDialogBuilder setFontNameInAssetsFontsFolder(String fontNameInAssetsFontsFolder) {
        /**Note:Keep the font under assets/fonts folder,
         * to be precise  app/src/main/assets/fonts folder*/
        /**
         * Lets add a validation for not having fonts/ prefix
         * */
        if (!fontNameInAssetsFontsFolder.contains("fonts/")) {
            fontNameInAssetsFontsFolder = "fonts/" + fontNameInAssetsFontsFolder;
        }
        this.fontNameInAssetsFontsFolder = fontNameInAssetsFontsFolder;
        return this;
    }
}
