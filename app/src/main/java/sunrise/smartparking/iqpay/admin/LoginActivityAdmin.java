package sunrise.smartparking.iqpay.admin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import sunrise.smartparking.iqpay.R;

public class LoginActivityAdmin extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_admin);
        findViewById(R.id.constraintLayoutLoginButton).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
               startActivity(new Intent(getApplicationContext(), MainActivityAdmin.class));
            }
        });
    }
}
