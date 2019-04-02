package sunrise.smartparking.iqpay.admin;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import sunrise.smartparking.iqpay.R;

public class MainActivityAdmin extends AppCompatActivity
{
    ListView listViewMain;
    Bundle currentSavedInstanceState;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.currentSavedInstanceState = savedInstanceState;
        setContentView(R.layout.activity_main_admin);
        replaceFragment(new MainListFragmentAdmin(),false);
        initializeToolbar();

    }

    private void initializeToolbar()
    {
        final DrawerLayout drawerLayoutMainActivity = ((DrawerLayout)findViewById(R.id.drawerLayoutMainActivity));
        ActionBarDrawerToggle t = new ActionBarDrawerToggle(MainActivityAdmin.this, drawerLayoutMainActivity, R.string.navigation_drawer_open, R.string.nav_header_desc);
        t.setHomeAsUpIndicator(R.drawable.drawer_icon);
        drawerLayoutMainActivity.addDrawerListener(t);
        t.syncState();
        drawerLayoutMainActivity.setScrimColor(getResources().getColor(android.R.color.transparent));

        Toolbar toolbar = (Toolbar) findViewById(R.id.constraintLayoutMainActivityAdmin).findViewById(R.id.toolbar);
        toolbar.setTitle("");
        toolbar.findViewById(R.id.constraintLayoutMainActivityToolbar).findViewById(R.id.imageButtonToolbarNavigation).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                drawerLayoutMainActivity.openDrawer(Gravity.RIGHT);
            }
        });
        setSupportActionBar(toolbar);

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigationViewDrawerMain);
        View viewNavigationHeader = (View) navigationView.getHeaderView(0);
        Button buttonSuport = (Button) viewNavigationHeader.findViewById(R.id.constraintLayoutDrawerButtons).findViewById(R.id.buttonDrawerSupport);
        buttonSuport.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                replaceFragment(new SupportActivityFragment(), true);
                drawerLayoutMainActivity.closeDrawer(Gravity.RIGHT);
            }
        });
        Button buttonAboutSunriseNetworks = (Button) viewNavigationHeader.findViewById(R.id.constraintLayoutDrawerButtons).findViewById(R.id.buttonDrawerAbout);
        buttonAboutSunriseNetworks.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                replaceFragment(new AboutSunriseFragment(), true);
                drawerLayoutMainActivity.closeDrawer(Gravity.RIGHT);
            }
        });

        Button buttonHome = (Button) viewNavigationHeader.findViewById(R.id.constraintLayoutDrawerButtons).findViewById(R.id.buttonDrawerHome);
        buttonHome.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                replaceFragment(new MainListFragmentAdmin(), false);
                drawerLayoutMainActivity.closeDrawer(Gravity.RIGHT);
            }
        });

        Button buttonSignout = (Button) viewNavigationHeader.findViewById(R.id.constraintLayoutDrawerButtons).findViewById(R.id.buttonDrawerLogout);
        buttonSignout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(getApplicationContext(), LoginActivityAdmin.class));
                drawerLayoutMainActivity.closeDrawer(Gravity.RIGHT);
            }
        });


    }

    public void replaceFragment(Fragment newFragment, Boolean addToBackSack)
    {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack so the user can navigate back
        transaction.replace(R.id.frameLayoutFragmentMain, newFragment);
        if (addToBackSack) transaction.addToBackStack(null);

        // Commit the transaction
        transaction.commit();
    }
}
