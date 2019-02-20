package sunrise.smartparking.iqpay.user;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import sunrise.smartparking.iqpay.R;

public class MainActivityUser extends AppCompatActivity
{
    ListView listViewMain;
    Bundle currentSavedInstanceState;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.currentSavedInstanceState = savedInstanceState;
        setContentView(R.layout.activity_main_user);

        MainListFragment newFragment = new MainListFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack so the user can navigate back
        transaction.replace(R.id.fragment_container, newFragment);
        transaction.addToBackStack(null);

        // Commit the transaction
        transaction.commit();
        // Check that the activity is using the layout version with
//        View v = findViewById(R.id.constraintLayoutFragment).findViewById(R.id.fragment_container);
//        v.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//                // the fragment_container FrameLayout
//                if ( findViewById(R.id.constraintLayoutFragment).findViewById(R.id.fragment_container) != null) {
//
//                // However, if we're being restored from a previous state,
//                // then we don't need to do anything and should return or else
//                // we could end up with overlapping fragments.
//                if (currentSavedInstanceState != null) {
//                    return;
//                }
//
//                SpecificListFragment newFragment = new SpecificListFragment();
//
//                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//
//                // Replace whatever is in the fragment_container view with this fragment,
//                // and add the transaction to the back stack so the user can navigate back
//                transaction.replace(R.id.fragment_container, newFragment);
//                transaction.addToBackStack(null);
//
//                // Commit the transaction
//                transaction.commit();
//            }
//            }
//        });


    }
}
