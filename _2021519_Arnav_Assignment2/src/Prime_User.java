import java.util.*;

public class Prime_User extends Normal_User{
    private double wallet;
    private String status;
    private double default_discount;
    private double flex_delivery;
    private int fixed_delivery;
    private int delivery_days;
    private ArrayList<Double> coupons = new ArrayList<>();

    Prime_User(String x, String y) {
        super(x, y);
        this.wallet = super.getWallet();
        this.status = "Prime";
        this.default_discount = 5;
        this.fixed_delivery = 100;
        this.flex_delivery = 0.02;
        this.delivery_days = 4;
        this.coupons.add((double) 0);
    }

    @Override
    public String getUsername() {
        return super.getUsername();
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public double getWallet() {
        return wallet;
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public LinkedHashMap<ArrayList<Product>, Integer> getCart() {
        return super.getCart();
    }

    @Override
    public double getDefault_discount() {
        return default_discount;
    }

    @Override
    public ArrayList<Double> getCoupons() {
        return coupons;
    }

    @Override
    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    @Override
    public int getFixed_delivery() {
        return fixed_delivery;
    }

    @Override
    public double getFlex_delivery() {
        return flex_delivery;
    }

    @Override
    public int getDelivery_days() {
        return delivery_days;
    }
}
