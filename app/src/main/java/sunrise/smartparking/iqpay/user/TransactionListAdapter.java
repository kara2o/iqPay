package sunrise.smartparking.iqpay.user;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

import sunrise.smartparking.iqpay.R;
import sunrise.smartparking.iqpay.admin.MainActivityAdmin;
import sunrise.smartparking.iqpay.admin.ReviewTransactionFragmentAdmin;

public class TransactionListAdapter extends BaseAdapter
{

    private final Context context;
    private final FragmentActivity activity;

    public TransactionListAdapter(FragmentActivity activity, Context context)
    {
        this.context = context;
        this.activity = activity;
        listCartItems = new ArrayList<CartItem>();
    }

    public TransactionListAdapter(FragmentActivity activity, Context context, ArrayList<CartItem> listCartItems)
    {
        this.listCartItems = listCartItems;
        this.activity = activity;
        this.context = context;
    }

    public void addItem(CartItem item)
    {
        listCartItems.add(item);
        notifyDataSetChanged();
    }

    ArrayList<CartItem> listCartItems;
    public ArrayList<CartItem> getListCartItems()
    {
        return listCartItems;
    }
    public void setListCartItems(ArrayList<CartItem> listCartItems) {
        this.listCartItems = listCartItems;
    }

    @Override
    public int getCount()
    {
        return listCartItems.size() + 1;
    }

    @Override
    public Object getItem(int position)
    {
        return position;
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View row = convertView;
        if (position == listCartItems.size())
        {
            row = LayoutInflater.from(context).inflate(R.layout.button_proceed_to_checkout, parent, false);
            row.findViewById(R.id.buttonProceedToCheckout).setOnClickListener(onClickButtomCheckout(listCartItems.size()));
            if (listCartItems.size() > 0) row.findViewById(R.id.buttonProceedToCheckout).setBackgroundResource(R.drawable.rounded_button_blue);
            return row;
        }


        row = LayoutInflater.from(context).inflate(R.layout.listitem_transaction, parent, false);


        return row;
    }

    private View.OnClickListener onClickButtomCheckout(final int intNumberOfItems)
    {
        return new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                ((MainActivityAdmin) activity).replaceFragment(new ReviewTransactionFragmentAdmin(), true);

            }
        };
    }


    private View.OnClickListener onClickButtomRemove(final int position)
    {
        return new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                removeItem(position);
            }
        };
    }

    public void removeItem(int position)
    {
        listCartItems.remove(position);
        notifyDataSetChanged();
    }
}
