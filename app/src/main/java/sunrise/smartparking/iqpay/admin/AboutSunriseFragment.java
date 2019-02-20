package sunrise.smartparking.iqpay.admin;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import sunrise.smartparking.iqpay.R;

public class AboutSunriseFragment extends Fragment
{
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            // Inflate the layout for this fragment
            View v = inflater.inflate(R.layout.fragment_about_sunrise, container, false);
            return v;
        }

}
