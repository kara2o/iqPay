package sunrise.smartparking.iqpay.admin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import sunrise.smartparking.iqpay.objects.Action;
import sunrise.smartparking.iqpay.R;

public class ReviewTransactionFragmentAdmin extends Fragment
{
    private View viewConfirmDialog;
    Activity activityMain;

    public final class Components { AlertDialog alertDialog; TextView textViewTransactionID, textViewConfirmDialog; Button buttonCancelTransaction, buttonCompleteTransaction, buttonConfirmDialogReturn, buttonConfirmDialogComplete; }
    Components components;
    View view;
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            // Inflate the layout for this fragment
            view = inflater.inflate(R.layout.fragment_review_transaction_admin, container, false);
            bindUI(view);
            return view;
        }

    private void bindUI(View view)
    {
        activityMain = getActivity();
        Components components = new Components();
        components.buttonCompleteTransaction = (Button) view.findViewById(R.id.buttonCompleteTransaction);
        components.buttonCompleteTransaction.setOnClickListener(showConfirmDialog(Action.COMPLETE_TRANSACTION));
        components.buttonCancelTransaction = (Button) view.findViewById(R.id.buttonReturn);
        components.buttonCancelTransaction.setOnClickListener(showConfirmDialog(Action.CANCEL_TRANSACTION));
        LayoutInflater inflater = ReviewTransactionFragmentAdmin.this.getLayoutInflater();
        viewConfirmDialog = inflater.inflate(R.layout.confirm_dialog, null);
        components.buttonConfirmDialogReturn = (Button) viewConfirmDialog.findViewById(R.id.buttonReturn);
        components.buttonConfirmDialogComplete = (Button) viewConfirmDialog.findViewById(R.id.buttonCompleteTransaction);
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

    private View.OnClickListener showConfirmDialog(final Action action)
    {
        return new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                LayoutInflater inflater = ReviewTransactionFragmentAdmin.this.getLayoutInflater();
                viewConfirmDialog = inflater.inflate(R.layout.confirm_dialog, null);
                components = new Components();
                components.buttonConfirmDialogReturn = (Button) viewConfirmDialog.findViewById(R.id.buttonReturn);
                components.buttonConfirmDialogComplete = (Button) viewConfirmDialog.findViewById(R.id.buttonCompleteTransaction);
                components.buttonConfirmDialogReturn.setOnClickListener(dismissAlertDialog());
                components.textViewConfirmDialog = (TextView) viewConfirmDialog.findViewById(R.id.textViewConfirmDialog);
                components.buttonConfirmDialogComplete.setOnClickListener(executeTransaction(Action.COMPLETE_TRANSACTION));
                if (action == Action.CANCEL_TRANSACTION)
                {
                    String stringCancelMessage =  components.textViewConfirmDialog.getText().toString().replace("complete", "cancel");
                    components.textViewConfirmDialog.setText(stringCancelMessage);
                    components.buttonConfirmDialogComplete.setOnClickListener(executeTransaction(Action.CANCEL_TRANSACTION));
                }

                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
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
        };
    }

    private View.OnClickListener executeTransaction(Action executeTransaction)
    {
        return new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // todo: add functionality for server call to edit Transactions on server here
                // on success:
                LayoutInflater inflater = ReviewTransactionFragmentAdmin.this.getLayoutInflater();
                viewConfirmDialog = inflater.inflate(R.layout.success_dialog, null);
                viewConfirmDialog.findViewById(R.id.buttonReturn).setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        startActivity(new Intent(ReviewTransactionFragmentAdmin.this.getContext(), MainActivityAdmin.class));
                    }
                });
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(new ContextThemeWrapper(getActivity(), R.style.AppTheme));
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
                return;
            }
        };
    }

}
