package sunrise.smartparking.iqpay.admin;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import sunrise.smartparking.iqpay.R;

public class ReviewTransactionFragmentAdmin extends Fragment
{
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            // Inflate the layout for this fragment
            View v = inflater.inflate(R.layout.fragment_review_transaction_admin, container, false);
            bindUI();
            return v;
        }

    private void bindUI()
    {
        Button buttonContact = (Button) getActivity().findViewById(R.id.buttonCompleteTransaction);
    }

}
