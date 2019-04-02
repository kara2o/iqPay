package sunrise.smartparking.iqpay.admin;

import android.content.Intent;
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
            v.findViewById(R.id.buttonReturnToHome).setOnClickListener(returnToHome());
            v.findViewById(R.id.buttonContactSunrise).setOnClickListener(contactSunrise());
            return v;
        }

    private View.OnClickListener contactSunrise()
    {
        return new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                ((MainActivityAdmin)getActivity()).replaceFragment(new SupportActivityFragment(), true);
            }
        };
    }

    private View.OnClickListener returnToHome()
    {
        return new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(AboutSunriseFragment.this.getContext(), MainActivityAdmin.class));
            }
        };
    }

}
