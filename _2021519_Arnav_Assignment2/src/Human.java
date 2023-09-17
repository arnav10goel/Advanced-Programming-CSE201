import java.util.*;

public interface Human {
    ArrayList<Human> admins = new ArrayList<>();
    ArrayList<Customer> customers = new ArrayList<>();
    ArrayList<Customer> normal_customers = new ArrayList<>();
    ArrayList<Customer> elite_customers = new ArrayList<>();
    ArrayList<Customer> prime_customers = new ArrayList<>();
    String getPassword();
    String getUsername();
}
