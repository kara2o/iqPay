package sunrise.smartparking.iqpay.user;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.ArrayList;

import sunrise.smartparking.iqpay.R;

public class SpecificListFragment extends Fragment
{
    private ListView listView;

    @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            // Inflate the layout for this fragment
            View view = inflater.inflate(R.layout.fragment_main_selection, container, false);
            setUpListView();
            TableLayout t = (TableLayout) view.findViewById(R.id.scrollViewSpecificSelection).findViewById(R.id.tableLayoutSpecificSelection);

            TableRow rowBuyButtons = t.findViewWithTag("tableRowButtonsBuy0");
            TableRow rowAddButtons = t.findViewWithTag("tableRowButtonsAdd0");

            Button b = rowBuyButtons.findViewById(R.id.buttonBuy00);
            Button ba = rowAddButtons.findViewById(R.id.buttonAdd00);

            ba.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    ((ShoppingCartListAdapter)listView.getAdapter()).addItem(new CartItem(0, null));
                }
            });

            /*
            int intRowCount = t.getChildCount();
            for (int i = 0; i < intRowCount; i++)
            {
                TableRow rowImages = t.findViewWithTag("tableRowLogos" + i);
                TableRow rowBuyButtons = t.findViewWithTag("tableRowButtonsBuy" + i);
                TableRow rowAddButtons = t.findViewWithTag("tableRowButtonsAdd" + i);

                int intColumnCount = rowImages.getChildCount();

                for (int j = 0; j < intColumnCount; j++)
                {

                }


                break;
            }
            */

            return view;
        }

    private void setUpListView()
    {
        listView = (ListView) getActivity().findViewById(R.id.constraintLayoutShoppingCartList).findViewById(R.id.listViewShoppingCartList);
        listView.setAdapter(new ShoppingCartListAdapter(getActivity(), getActivity().getApplicationContext(), new ArrayList<CartItem>()));
    }
}
