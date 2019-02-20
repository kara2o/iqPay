package sunrise.smartparking.iqpay.user;

public class CartItem
{
    float value;
    Operator operator;

    public CartItem(float value, Operator operator)
    {
        this.value = value;
        this.operator = operator;
    }
}
