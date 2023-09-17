import java.util.*;

public class Category extends Store_Item{
    private static ArrayList<Category> categories = new ArrayList<>();
    private ArrayList<Product> products_category = new ArrayList<>();

    Category(String name, double id) {
        super(name, id);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public double getId() {
        return super.getId();
    }

    public ArrayList<Product> getProducts_category() {
        return products_category;
    }

    public static ArrayList<Category> getCategories() {
        return categories;
    }

    @Override
    public String toString() {
        return "Category Name: "+ super.getName() + "\n" + "Category ID: " + super.getId() + "\n";
    }
}
