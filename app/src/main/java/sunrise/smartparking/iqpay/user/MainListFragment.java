package sunrise.smartparking.iqpay.user;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import sunrise.smartparking.iqpay.R;

public class MainListFragment extends Fragment
{
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            // Inflate the layout for this fragment
            View v = inflater.inflate(R.layout.fragment_specific_selection, container, false);
            ImageView i = (ImageView) v.findViewById(R.id.scrollViewMainSelection).findViewById(R.id.tableLayoutMainSelection).findViewById(R.id.tableRowMainSelection0).findViewById(R.id.constraintLayoutTableRowMain0).findViewById(R.id.imageViewMain01);
            i.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    SpecificListFragment newFragment = new SpecificListFragment();

                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

                    // Replace whatever is in the fragment_container view with this fragment,
                    // and add the transaction to the back stack so the user can navigate back
                    transaction.replace(R.id.fragment_container, newFragment);
                    transaction.addToBackStack(null);

                    // Commit the transaction
                    transaction.commit();
                }
            });
            i.bringToFront();

            return v;
        }

}
