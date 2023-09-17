import java.util.*;
public class Product extends Store_Item{
    private int quantity;
    private double price;
    private double discount_normal;
    private double discount_elite;
    private double discount_prime;
    private static ArrayList<Product> products = new ArrayList<>();
    private LinkedHashMap<String, String> prod_attributes_value = new LinkedHashMap<>();

    Product(String name, double id, int quantity, double price) {
        super(name, id);
        this.quantity = quantity;
        this.price = price;
        this.discount_normal = 0;
        this.discount_prime = 0;
        this.discount_elite = 0;
    }
    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public double getId() {
        return super.getId();
    }

    public int getQuantity() {
        return quantity;
    }

    public double getDiscount_normal() {
        return discount_normal;
    }

    public double getDiscount_prime() {
        return discount_prime;
    }

    public double getDiscount_elite() {
        return discount_elite;
    }

    public double getPrice() {
        return price;
    }

    public LinkedHashMap<String, String> getProd_attributes_value() {
        return prod_attributes_value;
    }

    public static ArrayList<Product> getProducts() {
        return products;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDiscount_normal(double discount_normal) {
        this.discount_normal = discount_normal;
    }

    public void setDiscount_prime(double discount_prime) {
        this.discount_prime = discount_prime;
    }

    public void setDiscount_elite(double discount_elite) {
        this.discount_elite = discount_elite;
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        for(String i : this.getProd_attributes_value().keySet()){
            ret.append(i);
            ret.append(" : ").append(this.getProd_attributes_value().get(i)).append("\n");
        }
        return ("Product Name: "+ getName() +"\n" + "Product ID: " + getId() + "\n" + ret);
    }
}
