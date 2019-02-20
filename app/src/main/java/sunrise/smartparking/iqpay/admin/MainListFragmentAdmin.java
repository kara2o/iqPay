package sunrise.smartparking.iqpay.admin;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

import sunrise.smartparking.iqpay.R;
import sunrise.smartparking.iqpay.user.CartItem;
import sunrise.smartparking.iqpay.user.SpecificListFragment;
import sunrise.smartparking.iqpay.user.TransactionListAdapter;

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


                }
            });
            ArrayList<CartItem> list = new ArrayList<CartItem>();
            list.add(new CartItem(0,null));
            listView.setAdapter(new TransactionListAdapter(getActivity(), getActivity().getApplicationContext(), list));
        }

}
