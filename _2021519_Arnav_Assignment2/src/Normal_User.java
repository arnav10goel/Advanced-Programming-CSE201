import java.util.*;
public class Normal_User extends Customer{
    private String username;
    private String password;
    private String status;
    private double wallet;
    private double default_discount;
    private double flex_delivery;
    private ArrayList<Double> coupons = new ArrayList<>();
    private int fixed_delivery;
    private int delivery_days;
    private LinkedHashMap<ArrayList<Product>, Integer> Cart = new LinkedHashMap<>(); //CART IS HASHMAP OF ARRAYLIST OF PRODUCTS (for deals) and INT FOR QUANTITY
    Normal_User(String x, String y){
        this.username = x;
        this.password = y;
        this.status = "Normal";
        this.wallet = 1000;
        this.default_discount = 0;
        this.fixed_delivery = 100;
        this.flex_delivery = 0.05;
        this.delivery_days = 8;
        this.coupons.add((double) 0);
    }

    @Override
    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public double getWallet() {
        return wallet;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public ArrayList<Double> getCoupons() {
        return coupons;
    }

    public double getDefault_discount() {
        return default_discount;
    }

    public LinkedHashMap<ArrayList<Product>, Integer> getCart() {
        return Cart;
    }

    public double getFlex_delivery() {
        return flex_delivery;
    }

    public int getFixed_delivery() {
        return fixed_delivery;
    }

    public int getDelivery_days() {
        return delivery_days;
    }
}
