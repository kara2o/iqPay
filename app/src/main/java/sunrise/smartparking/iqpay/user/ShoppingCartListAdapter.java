package sunrise.smartparking.iqpay.user;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import sunrise.smartparking.iqpay.R;
import sunrise.smartparking.iqpay.admin.LoginActivityAdmin;
import sunrise.smartparking.iqpay.admin.MainActivityAdmin;

public class ShoppingCartListAdapter extends BaseAdapter
{

    private final Context context;
    private final FragmentActivity activity;
    private boolean reversed;

    public void setReversed(boolean reversed)
    {
        this.reversed = reversed;
    }

    public ShoppingCartListAdapter(FragmentActivity activity, Context context)
    {
        this.context = context;
        this.activity = activity;
        listCartItems = new ArrayList<CartItem>();
    }

    public ShoppingCartListAdapter(FragmentActivity activity, Context context, ArrayList<CartItem> listCartItems)
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
        if ( (position == listCartItems.size() && !reversed ) || (position == 0 && reversed))
        {
            row = LayoutInflater.from(context).inflate(R.layout.button_proceed_to_checkout, parent, false);
            row.findViewById(R.id.buttonProceedToCheckout).setOnClickListener(onClickButtomCheckout(listCartItems.size()));
            if (listCartItems.size() > 0) row.findViewById(R.id.buttonProceedToCheckout).setBackgroundResource(R.drawable.rounded_button_blue);
            if (reversed)
            {
                Button buttonOrderItems =  ((Button) row.findViewById(R.id.buttonProceedToCheckout));
                buttonOrderItems.setText("Order Items");
                buttonOrderItems.setOnClickListener(orderItems());
            }
            return row;
        }


        row = LayoutInflater.from(context).inflate(R.layout.listitem_shopping_cart, parent, false);


        ConstraintLayout constraintLayoutListItem = (ConstraintLayout)  row.findViewById(R.id.constraintLayoutCartListItem);
        ImageView imageViewThumbnail = (ImageView) constraintLayoutListItem.findViewById(R.id.imageViewCartItemThumbnail);
        TextView textViewOperator = (TextView) constraintLayoutListItem.findViewById(R.id.textViewCartItemOperator);
        TextView textViewValue = (TextView) constraintLayoutListItem.findViewById(R.id.textViewCartItemValue);
        ImageButton buttonRemoveItem = (ImageButton) constraintLayoutListItem.findViewById(R.id.buttonRemoveItem);

        textViewOperator.setText("Apple iTunes");
        textViewValue.setText("10$");
        buttonRemoveItem.setOnClickListener(onClickButtomRemove(position));

        return row;
    }

    private View.OnClickListener orderItems()
    {
        return new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // todo: add api call for ordering items here
                activity.startActivity(new Intent(activity, LoginActivityAdmin.class));
            }
        };
    }

    private View.OnClickListener onClickButtomCheckout(final int intNumberOfItems)
    {
        return new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (intNumberOfItems > 0)
                {
                    OrderSuccesfulFragment newFragment = new OrderSuccesfulFragment();
                    FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
                    // Replace whatever is in the fragment_container view with this fragment,
                    // and add the transaction to the back stack so the user can navigate back
                    transaction.replace(R.id.fragment_container, newFragment);
                    transaction.addToBackStack(null);

                    // Commit the transaction
                    transaction.commit();
                    setReversed(true);
                    notifyDataSetChanged();
                }
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
