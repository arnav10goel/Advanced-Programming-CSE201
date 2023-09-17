import java.util.*;

abstract class Customer implements Human{
    public abstract void setWallet(double wallet);

    public abstract String getStatus();

    public abstract double getWallet();

    public abstract double getDefault_discount();

    public abstract LinkedHashMap<ArrayList<Product>, Integer> getCart();

    public abstract ArrayList<Double> getCoupons();

    public abstract double getFlex_delivery();

    public abstract int getFixed_delivery();

    public abstract int getDelivery_days();
}
