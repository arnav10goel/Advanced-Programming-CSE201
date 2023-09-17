import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Admin implements Human{

    private String username;
    private String password;

    private static LinkedHashMap<Integer, ArrayList<Product>> deal_ids = new LinkedHashMap<>();
    private static LinkedHashMap<ArrayList<Product>, Double> deal_prices_normal = new LinkedHashMap<>();
    private static LinkedHashMap<ArrayList<Product>, Double> deal_prices_prime = new LinkedHashMap<>();
    private static LinkedHashMap<ArrayList<Product>, Double> deal_prices_elite = new LinkedHashMap<>();

    Admin(String x, String y){
        this.username = x;
        this.password = y;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public static LinkedHashMap<ArrayList<Product>, Double> getDeal_prices_elite() {
        return deal_prices_elite;
    }

    public static LinkedHashMap<ArrayList<Product>, Double> getDeal_prices_normal() {
        return deal_prices_normal;
    }

    public static LinkedHashMap<ArrayList<Product>, Double> getDeal_prices_prime() {
        return deal_prices_prime;
    }

    public static LinkedHashMap<Integer, ArrayList<Product>> getDeal_ids() {
        return deal_ids;
    }
}
