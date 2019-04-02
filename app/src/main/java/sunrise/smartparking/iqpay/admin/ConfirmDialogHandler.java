package sunrise.smartparking.iqpay.admin;

import android.app.Activity;
import android.support.v7.app.AlertDialog;
import android.support.v7.view.ContextThemeWrapper;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import sunrise.smartparking.iqpay.objects.Action;
import sunrise.smartparking.iqpay.R;

public class ConfirmDialogHandler implements Runnable
{
    ReviewTransactionFragmentAdmin.Components components;
    View viewConfirmDialog;
    Action action;
    Activity activity;

    public ConfirmDialogHandler(ReviewTransactionFragmentAdmin.Components components, Activity activity, Action action)
    {
        this.action = action;
        this.activity = activity;
        this.components =  components;
        activity.runOnUiThread(this);
    }

    @Override
    public void run()
    {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(new ContextThemeWrapper(activity, R.style.AppTheme));
        // ...Irrelevant code for customizing the buttons and title


        components.buttonConfirmDialogComplete.setOnClickListener(executeTransaction(Action.COMPLETE_TRANSACTION));
        if (action == Action.CANCEL_TRANSACTION)
        {
            String stringCancelMessage =  components.textViewConfirmDialog.getText().toString().replace("complete", "cancel");
            components.textViewConfirmDialog.setText(stringCancelMessage);
            components.buttonConfirmDialogComplete.setOnClickListener(executeTransaction(Action.CANCEL_TRANSACTION));
        }

        dialogBuilder.setView(viewConfirmDialog);
        AlertDialog alertDialog= dialogBuilder.create();
        Window windowAlert = alertDialog.getWindow();
        WindowManager.LayoutParams layoutConfirmDialog = new WindowManager.LayoutParams();
        layoutConfirmDialog.copyFrom(windowAlert.getAttributes());
        layoutConfirmDialog.width = 320;
        layoutConfirmDialog.height = 320;
        alertDialog.getWindow().setAttributes(layoutConfirmDialog);
        components.alertDialog = alertDialog;
        alertDialog.show();
    }

    private View.OnClickListener executeTransaction(Action completeTransaction)
    {
        return new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // todo: add functionality for completing/canceling transactions here


                // on success:
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(new ContextThemeWrapper(activity, R.style.AppTheme));
                dialogBuilder.setView(viewConfirmDialog);
                AlertDialog alertDialog= dialogBuilder.create();
                Window windowAlert = alertDialog.getWindow();
                WindowManager.LayoutParams layoutConfirmDialog = new WindowManager.LayoutParams();
                layoutConfirmDialog.copyFrom(windowAlert.getAttributes());
                layoutConfirmDialog.width = 320;
                layoutConfirmDialog.height = 320;
                alertDialog.getWindow().setAttributes(layoutConfirmDialog);
                dismissAlertDialog();
                components.alertDialog = alertDialog;
                alertDialog.show();

            }
        };
    }

    private View.OnClickListener dismissAlertDialog()
    {
        return new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                components.alertDialog.dismiss();
            }
        };
    }


}
