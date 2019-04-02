package sunrise.smartparking.iqpay.admin;

import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import sunrise.smartparking.iqpay.R;
import sunrise.smartparking.iqpay.user.CartItem;

public class MainListFragmentAdmin extends Fragment
{
    View fragmentView;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            // Inflate the layout for this fragment
            fragmentView= inflater.inflate(R.layout.fragment_main_activity_admin, container, false);
            bindUI();
            return fragmentView;
        }

        public void bindUI()
        {
            ListView listView = (ListView) fragmentView.findViewById(R.id.listviewTransactions);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id)
                {
                    ((MainActivityAdmin) getActivity()).replaceFragment(new ReviewTransactionFragmentAdmin(), true);
                }
            });
            ArrayList<CartItem> list = new ArrayList<CartItem>();
            list.add(new CartItem(0,null));
            listView.setAdapter(new TransactionListAdapter(getActivity(), getActivity().getApplicationContext(), list));

            // todo: add responsive resizing of views later
            // resizeViews();
        }

    private void resizeViews()
    {
        TextView textViewPendingTransactions = (TextView) fragmentView.findViewById(R.id.textViewPendingTransactions);
        TextView textViewCompletedTransactions = (TextView) fragmentView.findViewById(R.id.textViewCompletedTransactions);
        TextView textViewCanceledTransactions = (TextView) fragmentView.findViewById(R.id.textViewCanceledTransactions);
        TextView textViewViewTransactions = (TextView) fragmentView.findViewById(R.id.textViewViewTransactions);


        Display display = getActivity().getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        // Comparison device: 1440 x 2560 Google Pixel XL
        int intDeltaWidth = size.x - 1440;
        int intDeltaHeight = size.y - 2560;

        textViewCanceledTransactions.setTextSize(TypedValue.COMPLEX_UNIT_DIP, intDeltaWidth*0.02f);
        textViewCompletedTransactions.setTextSize(TypedValue.COMPLEX_UNIT_DIP, intDeltaWidth*0.02f);
        textViewPendingTransactions.setTextSize(TypedValue.COMPLEX_UNIT_DIP, intDeltaWidth*0.02f);
        textViewViewTransactions.setTextSize(TypedValue.COMPLEX_UNIT_DIP, intDeltaWidth*0.02f);
    }

}
