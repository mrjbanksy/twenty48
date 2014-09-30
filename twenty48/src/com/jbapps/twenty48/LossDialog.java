package com.jbapps.twenty48;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;

public class LossDialog
    extends Dialog
{
    private MainActivity activity;


    public LossDialog(MainActivity activity)
    {
        super(activity);
        this.activity = activity;

    }


    public void onCreateDialog()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setMessage("You lose!").setCancelable(false)
            .setNegativeButton("New Game", new AlertDialog.OnClickListener() {
                public void onClick(DialogInterface dialog, int id)
                {
                    activity.newGame();
                }
            });
        AlertDialog alert = builder.create();
        alert.setOwnerActivity(activity);
        alert.show();
    }

}
