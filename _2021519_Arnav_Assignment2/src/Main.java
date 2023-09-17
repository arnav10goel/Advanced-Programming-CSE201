import org.jetbrains.annotations.NotNull;
import java.util.*;
public class Main {
    public static void main(String[] args){
        //HELPER DEFINITIONS
        Category category = new Category("NULL", -1);
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        //Polymorphism
        Human admin1 = new Admin("ag2003","10012003");
        Human admin2 = new Admin("medhahira","16122003");
        Human.admins.add(admin1);
        Human.admins.add(admin2);

        while(true){
            System.out.println("Welcome to FLIPZON");
            System.out.println("1. Enter as Admin");
            System.out.println("2. Explore the Product Catalog");
            System.out.println("3. Show Available Deals");
            System.out.println("4. Enter as Customer");
            System.out.println("5. Exit the Application");
            System.out.println("Enter the number corresponding to your choice: ");
            int choice1 = scanner.nextInt();
            scanner.nextLine();

            //ADMIN MODE
            if(choice1 == 1){
                System.out.print("Enter Admin Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter Password: ");
                String password = scanner.nextLine();
                int flag1 = 0;
                for(int i = 0; i < Human.admins.size(); i++) {
                    if (Human.admins.get(i).getUsername().equals(name) && Human.admins.get(i).getPassword().equals(password)) {
                        flag1 = 1;
                        break;
                    }
                }
                if(flag1 == 1){
                    //MENU FOR ADMIN CHOICES
                    while(true) {
                        System.out.println("Please choose any of the following options: ");
                        System.out.println("1. Add Category");
                        System.out.println("2. Delete Category");
                        System.out.println("3. Add Product");
                        System.out.println("4. Delete Product");
                        System.out.println("5. Set Discount on Product");
                        System.out.println("6. Add Giveaway Deal");
                        System.out.println("7. Back");
                        System.out.println("Enter the number corresponding to your choice: ");
                        int choice_admin = scanner.nextInt();
                        scanner.nextLine();
                        //ADD CATEGORY
                        if (choice_admin == 1) {
                            System.out.println("Add Category ID: ");
                            double id_input = scanner.nextDouble();
                            scanner.nextLine();
                            int flag_category_id = 0;
                            int indx_flag = 0;
                            for(int i = 0; i < Category.getCategories().size(); i++){
                                if(Category.getCategories().get(i).getId() == id_input){
                                    flag_category_id = 1;
                                    indx_flag = i;
                                    break;
                                }
                            }
                            //FLAG FOR CHECKING IF CATEGORY ALREADY EXISTS
                            if(flag_category_id == 1){
                                System.out.println("This Category already exists: ");
                                System.out.println(Category.getCategories().get(indx_flag).toString());
                            }
                            else{
                                System.out.println("Add Category Name: ");
                                String category_name = scanner.nextLine();
                                Category current_cat = new Category(category_name, id_input);
                                Category.getCategories().add(current_cat);
                                System.out.println("Category Added, now add a Product:");
                                System.out.print("Product Name: ");
                                String prod_name = scanner.nextLine();
                                System.out.print("Product ID: ");
                                double prod_id = scanner.nextDouble();
                                scanner.nextLine();
                                System.out.print("Product Quantity: ");
                                int prod_quant = scanner.nextInt();
                                scanner.nextLine();
                                System.out.print("Product Price: ");
                                double prod_price = scanner.nextDouble();
                                scanner.nextLine();
                                int flag_prod_id = 0;
                                for(int i = 0; i < Product.getProducts().size(); i++){
                                    if(Product.getProducts().get(i).getId() == prod_id){
                                        flag_prod_id = 1;
                                        break;
                                    }
                                }
                                if(flag_prod_id == 1){
                                    System.out.println("Product already exists"); //to be edited end mei
                                }
                                else{
                                    Product new_prod = new Product(prod_name, prod_id, prod_quant, prod_price);
                                    current_cat.getProducts_category().add(new_prod);
                                    Product.getProducts().add(new_prod);
                                    System.out.println("Enter the number of additional properties you would like to mention for your product: ");
                                    int num_props = scanner.nextInt();
                                    scanner.nextLine();
                                    System.out.println("Enter your properties in the following format: (Property:Value)");
                                    for(int i = 0; i < num_props; i++){
                                        String add_props = scanner.nextLine();
                                        String[] arr = add_props.split(":", 3);
                                        new_prod.getProd_attributes_value().put(arr[0],arr[1]);
                                    }
                                    System.out.println("Product Added! Details: ");
                                    System.out.println(new_prod);
                                }
                            }
                        }
                        //DELETE CATEGORY
                        else if (choice_admin == 2) {
                            int[] category_checker;
                            category_checker = Main.Category_Checker();
                            int indx_flag = category_checker[0];
                            int curr_cat_indx = category_checker[1];
                            if(indx_flag == 0){
                                System.out.println("Given Category ID doesn't exist");
                            }
                            else{
                                Category category_tbdel = Category.getCategories().get(curr_cat_indx);
                                for(int i = 0; i < category_tbdel.getProducts_category().size(); i++){
                                    Product.getProducts().remove(category_tbdel.getProducts_category().get(i));
                                }
                                Category.getCategories().remove(category_tbdel);
                            }
                            System.out.println("Category Given Deleted");
                        }
                        //ADD PRODUCT
                        else if (choice_admin == 3) {
                            int[] category_checker;
                            category_checker = Main.Category_Checker();
                            int indx_flag = category_checker[0];
                            int curr_cat_indx = category_checker[1];
                            if(indx_flag == 0){
                                System.out.println("Category doesn't exist, please try again");
                            }
                            else{
                                Category current_cat = Category.getCategories().get(curr_cat_indx);
                                System.out.print("Product Name: ");
                                String prod_name = scanner.nextLine();
                                System.out.print("Product ID: ");
                                double prod_id = scanner.nextDouble();
                                scanner.nextLine();
                                System.out.print("Product Quantity: ");
                                int prod_quant = scanner.nextInt();
                                scanner.nextLine();
                                System.out.print("Product Price: ");
                                double prod_price = scanner.nextDouble();
                                scanner.nextLine();
                                int flag_prod_id = 0;
                                for(int i = 0; i < Product.getProducts().size(); i++){
                                    if(Product.getProducts().get(i).getId() == prod_id){
                                        flag_prod_id = 1;
                                        break;
                                    }
                                }
                                if(flag_prod_id == 1){
                                    System.out.println("Product already exists");
                                }
                                else{
                                    Product new_prod = new Product(prod_name, prod_id, prod_quant, prod_price);
                                    current_cat.getProducts_category().add(new_prod);
                                    Product.getProducts().add(new_prod);
                                    System.out.println("Enter the number of additional properties you would like to mention for your product: ");
                                    int num_props = scanner.nextInt();
                                    scanner.nextLine();
                                    System.out.println("Enter your properties in the following format: (Property:Value)");
                                    for(int i = 0; i < num_props; i++){
                                        String add_props = scanner.nextLine();
                                        String[] arr = add_props.split(":", 3);
                                        new_prod.getProd_attributes_value().put(arr[0],arr[1]);
                                    }
                                    System.out.println("Product Added! Details: ");
                                    System.out.println(new_prod);
                                }
                            }
                        }
                        //DELETE PRODUCT
                        else if (choice_admin == 4) {
                            int[] category_checker;
                            category_checker = Main.Category_Checker();
                            int indx_flag = category_checker[0];
                            int curr_cat_indx = category_checker[1];
                            if(indx_flag == 0){
                                System.out.println("Category doesn't exist, please try again");
                            }
                            else{
                                Category current_cat = Category.getCategories().get(curr_cat_indx);
                                System.out.print("Product ID: ");
                                double prod_id = scanner.nextDouble();
                                scanner.nextLine();
                                int flag_prod_id = 0;
                                int curr_prod_indx = 0;
                                for(int i = 0; i < current_cat.getProducts_category().size(); i++){
                                    if(current_cat.getProducts_category().get(i).getId() == prod_id){
                                        flag_prod_id = 1;
                                        curr_prod_indx = i;
                                        break;
                                    }
                                }
                                if(flag_prod_id == 0){
                                    System.out.println("Product doesn't exist in the given Category. Please try again"); //to be edited end mei
                                }
                                else{
                                    Product curr_prod = Product.getProducts().get(curr_prod_indx);
                                    Product.getProducts().remove(curr_prod);
                                    current_cat.getProducts_category().remove(curr_prod);
                                    if(current_cat.getProducts_category().size() == 0){
                                        Category.getCategories().remove(current_cat);
                                    }
                                    System.out.println("Product: " + curr_prod.getName() + " is deleted");
                                }
                            }
                        }

                        //DISCOUNT ON PRODUCT
                        else if (choice_admin == 5) {
                            System.out.print("Product ID: ");
                            double prod_id = scanner.nextDouble();
                            scanner.nextLine();
                            int flag_prod_id = 0;
                            int curr_prod_indx = 0;
                            for(int i = 0; i < Product.getProducts().size(); i++){
                                if(Product.getProducts().get(i).getId() == prod_id){
                                    flag_prod_id = 1;
                                    curr_prod_indx = i;
                                    break;
                                }
                            }
                            if(flag_prod_id == 0){
                                System.out.println("Product doesn't exist. Please try again");
                            }
                            else{
                                Product curr_prod = Product.getProducts().get(curr_prod_indx);
                                System.out.println("For Chosen Product, enter the discount for the following users: ");
                                System.out.print("Normal User: ");
                                double normal_discount = scanner.nextDouble();
                                scanner.nextLine();
                                curr_prod.setDiscount_normal(normal_discount);
                                System.out.print("Prime User: ");
                                double prime_discount = scanner.nextDouble();
                                scanner.nextLine();
                                curr_prod.setDiscount_prime(prime_discount);
                                System.out.print("Elite User: ");
                                double elite_discount = scanner.nextDouble();
                                scanner.nextLine();
                                curr_prod.setDiscount_elite(elite_discount);
                            }
                        }

                        //GIVEAWAY DEALS
                        else if (choice_admin == 6) {
                            System.out.print("ID for Product 1: ");
                            double prod_id1 = scanner.nextDouble();
                            scanner.nextLine();
                            int flag_prod_id1 = 0;
                            int curr_prod_indx1 = 0;
                            for(int i = 0; i < Product.getProducts().size(); i++){
                                if(Product.getProducts().get(i).getId() == prod_id1){
                                    flag_prod_id1 = 1;
                                    curr_prod_indx1 = i;
                                    break;
                                }
                            }
                            System.out.print("ID for Product 2: ");
                            double prod_id2 = scanner.nextDouble();
                            scanner.nextLine();
                            int flag_prod_id2 = 0;
                            int curr_prod_indx2 = 0;
                            for(int i = 0; i < Product.getProducts().size(); i++){
                                if(Product.getProducts().get(i).getId() == prod_id2){
                                    flag_prod_id2 = 1;
                                    curr_prod_indx2 = i;
                                    break;
                                }
                            }
                            if(flag_prod_id1 == 0 || flag_prod_id2 == 0){
                                System.out.println("The Given Product IDs don't exist");
                            }
                            else if(curr_prod_indx1 == curr_prod_indx2){
                                System.out.println("Entered the same ID, need 2 different products for making a deal");
                            }
                            else{
                                Product curr_prod1 = Product.getProducts().get(curr_prod_indx1);
                                Product curr_prod2 = Product.getProducts().get(curr_prod_indx2);
                                ArrayList<Product> temp = new ArrayList<>();
                                temp.add(curr_prod1);
                                temp.add(curr_prod2);
                                Admin.getDeal_ids().put((Admin.getDeal_ids().size()+1), temp);
                                double price_normal1 = curr_prod1.getPrice()*(1-(curr_prod1.getDiscount_normal()/100));
                                double price_prime1 = curr_prod1.getPrice()*(1-(curr_prod1.getDiscount_prime()/100));
                                double price_elite1 = curr_prod1.getPrice()*(1-(curr_prod1.getDiscount_elite()/100));
                                double price_normal2 = curr_prod2.getPrice()*(1-(curr_prod1.getDiscount_normal()/100));
                                double price_prime2 = curr_prod2.getPrice()*(1-(curr_prod1.getDiscount_prime()/100));
                                double price_elite2 = curr_prod2.getPrice()*(1-(curr_prod1.getDiscount_elite()/100));
                                System.out.print("Enter the Deal Price for Normal Users: ");
                                double price_normal = scanner.nextDouble();
                                scanner.nextLine();
                                System.out.print("Enter the Deal Price for Prime Users: ");
                                double price_prime = scanner.nextDouble();
                                scanner.nextLine();
                                System.out.print("Enter the Deal Price for Elite Users: ");
                                double price_elite = scanner.nextDouble();
                                scanner.nextLine();
                                int deal_checker = 0;
                                if(price_normal > (price_normal1+price_normal2)){
                                    deal_checker = 1;
                                    System.out.println("Your deal price for normal users is greater than the sum of prices for the 2 products.");
                                }
                                if(price_prime > (price_prime1+price_prime2)){
                                    deal_checker = 2;
                                    System.out.println("Your deal price for prime users is greater than the sum of prices for the 2 products.");
                                }
                                if(price_elite > (price_elite1+price_elite2)){
                                    deal_checker = 3;
                                    System.out.println("Your deal price for elite users is greater than the sum of prices for the 2 products.");
                                }
                                if(deal_checker == 1 || deal_checker == 2 || deal_checker ==3){
                                    System.out.println("Please try again");
                                }
                                else{
                                    Admin.getDeal_prices_normal().put(temp, price_normal);
                                    Admin.getDeal_prices_prime().put(temp, price_prime);
                                    Admin.getDeal_prices_elite().put(temp, price_elite);
                                    System.out.println("Done");
                                }
                            }
                        }
                        //ENDING THE WHILE LOOP
                        else if (choice_admin == 7) {
                            break;
                        }
                        else {
                            System.out.println("Invalid choice");
                        }
                    }
                }
                else{
                    System.out.println("You do not have admin access");
                }

            }

            //BROWSE PRODUCT CATALOGUE
            else if(choice1 == 2){
                if(Product.getProducts().size() == 0){
                    System.out.println("No Products to View in Catalogue right now");
                }
                else{
                    System.out.println("The Products in the Catalogue are as follows: ");
                    for(int i = 0; i < Product.getProducts().size(); i++){
                        System.out.println();
                        System.out.println("Product "+ (i+1) + ":");
                        System.out.println(Product.getProducts().get(i).toString());
                    }
                }
            }
            //BROWSE THROUGH DEALS
            else if(choice1 == 3){
                if(Admin.getDeal_ids().size() == 0){
                    System.out.println("No deals to view right now");
                }
                else {
                    for(Integer i : Admin.getDeal_ids().keySet()){
                        System.out.println("Deal ID: "+i);
                        System.out.println("Product 1: " + Admin.getDeal_ids().get(i).get(0).getName());
                        System.out.println("Product 2: " + Admin.getDeal_ids().get(i).get(1).getName());
                        System.out.println("Deal Price:");
                        System.out.println("For Normal Users: " + Admin.getDeal_prices_normal().get(Admin.getDeal_ids().get(i)));
                        System.out.println("For Prime Users: " + Admin.getDeal_prices_prime().get(Admin.getDeal_ids().get(i)));
                        System.out.println("For Elite Users: " + Admin.getDeal_prices_elite().get(Admin.getDeal_ids().get(i)));
                    }
                }
            }
            //CUSTOMER MODE
            else if(choice1 == 4){
                while(true) {
                    System.out.println("Please choose any of the following options: ");
                    System.out.println("1. Sign Up");
                    System.out.println("2. Login");
                    System.out.println("3. Back");
                    System.out.println("Enter the number corresponding to your choice: ");
                    int choice_customer_first = scanner.nextInt();
                    scanner.nextLine();
                    if (choice_customer_first == 1) {
                        System.out.print("Enter Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Password: ");
                        String password = scanner.nextLine();
                        //Polymorphism
                        Customer new_customer = new Normal_User(name, password);
                        int[] user_check;
                        user_check = Main.check_customer_type(new_customer);
                        if (user_check[0] == -1){
                            Human.customers.add(new_customer);
                            Human.normal_customers.add(new_customer);
                            System.out.println("User successfully registered");
                        }
                        else{
                            System.out.println("User already exists, please login");
                        }
                    }
                    else if (choice_customer_first == 2) {
                        System.out.print("Enter Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Password: ");
                        String password = scanner.nextLine();
                        Customer customer_precheck = new Normal_User(name, password);
                        int[] user_check;
                        int indx_curr_customer;
                        Customer current_user;
                        user_check = Main.check_customer_type(customer_precheck);
                        if(user_check[0] == -1){
                            System.out.println("User cannot be found, please Sign-Up first");
                        }
                        else{
                            indx_curr_customer = user_check[1];
                            if(user_check[0] == 0){
                                current_user = Human.elite_customers.get(indx_curr_customer);
                            }
                            else if(user_check[0] == 1){
                                current_user = Human.prime_customers.get(indx_curr_customer);
                            }
                            else{
                                current_user = Human.normal_customers.get(indx_curr_customer);
                            }
                            System.out.println("Welcome "+ current_user.getUsername());
                            //CUSTOMER LOGIN CHOICES
                            while (true) {
                                System.out.println("Please choose any of the following options: ");
                                System.out.println("1. Browse Products");
                                System.out.println("2. Browse Deals");
                                System.out.println("3. Add a Product to the Cart");
                                System.out.println("4. Add Products in Deal to the Cart");
                                System.out.println("5. View Coupons");
                                System.out.println("6. Check Account Balance");
                                System.out.println("7. View Cart");
                                System.out.println("8. Empty Cart");
                                System.out.println("9. Checkout Cart");
                                System.out.println("10. Upgrade Customer Status");
                                System.out.println("11. Add Amount to Wallet");
                                System.out.println("12. Back");
                                System.out.println("Enter the number corresponding to your choice: ");

                                int choice_student_second = scanner.nextInt();
                                scanner.nextLine();
                                //BROWSE PRODUCTS
                                if (choice_student_second == 1) {
                                    if(Product.getProducts().size() == 0){
                                        System.out.println("No Products to View in Catalogue right now");
                                    }
                                    else{
                                        System.out.println("The Products in the Catalogue are as follows: ");
                                        for(int i = 0; i < Product.getProducts().size(); i++){
                                            System.out.println();
                                            System.out.println("Product "+ (i+1) + ":");
                                            System.out.println(Product.getProducts().get(i).toString());
                                        }
                                    }
                                }
                                //BROWSE DEALS
                                else if (choice_student_second == 2) {
                                    if(Admin.getDeal_ids().size() == 0){
                                        System.out.println("No deals to view right now");
                                    }
                                    else {
                                        for(Integer i : Admin.getDeal_ids().keySet()){
                                            System.out.println("Deal ID: "+i);
                                            System.out.println("Product 1: " + Admin.getDeal_ids().get(i).get(0).getName());
                                            System.out.println("Product 2: " + Admin.getDeal_ids().get(i).get(1).getName());
                                            System.out.println("Deal Price:");
                                            System.out.println("For Normal Users: " + Admin.getDeal_prices_normal().get(Admin.getDeal_ids().get(i)));
                                            System.out.println("For Prime Users: " + Admin.getDeal_prices_prime().get(Admin.getDeal_ids().get(i)));
                                            System.out.println("For Elite Users: " + Admin.getDeal_prices_elite().get(Admin.getDeal_ids().get(i)));
                                        }
                                    }
                                }
                                //ADD PRODUCT
                                else if (choice_student_second == 3) {
                                    System.out.print("Product ID: ");
                                    double prod_id = scanner.nextDouble();
                                    scanner.nextLine();
                                    int flag_prod_id = 0;
                                    int curr_prod_indx = 0;
                                    for(int i = 0; i < Product.getProducts().size(); i++){
                                        if(Product.getProducts().get(i).getId() == prod_id){
                                            flag_prod_id = 1;
                                            curr_prod_indx = i;
                                            break;
                                        }
                                    }
                                    if(flag_prod_id == 0){
                                        System.out.println("Product doesn't exist. Please try again");
                                    }
                                    else{
                                        Product curr_prod = Product.getProducts().get(curr_prod_indx);
                                        System.out.println("There are currently "+ curr_prod.getQuantity() + " number of products of name "+ curr_prod.getName() + " and ID: " + curr_prod.getId());
                                        System.out.println(" ");
                                        ArrayList<Product> temp = new ArrayList<>();
                                        temp.add(curr_prod);
                                        temp.add(null);
                                        //THIS CONDITION CHECKS IF ITEM ALREADY IN CART AND ASKS IF ADDITIONAL NEED TO BE ADDED
                                        if(current_user.getCart().containsKey(temp)){
                                            int curr_quant_added = current_user.getCart().get(temp);
                                            System.out.println("Your cart already has this product. How many additional would you like to add? (Enter 0 if no more needed)");
                                            int prod_quantity = scanner.nextInt();
                                            scanner.nextLine();
                                            int prod_quantity_org = curr_prod.getQuantity();
                                            if(prod_quantity > prod_quantity_org){
                                                System.out.println("There are only " + curr_prod.getQuantity() + " number of products in stock for given ID. Please try again later");
                                            }
                                            else{
                                                current_user.getCart().put(temp, (curr_quant_added+prod_quantity));
                                                curr_prod.setQuantity(prod_quantity_org - prod_quantity);
                                            }
                                        }
                                        else{
                                            System.out.println("Product Quantity: ");
                                            int prod_quantity = scanner.nextInt();
                                            scanner.nextLine();
                                            int prod_quantity_org = curr_prod.getQuantity();
                                            if(prod_quantity > prod_quantity_org){
                                                System.out.println("There are only " + curr_prod.getQuantity() + " number of products in stock for given ID. Please try again later");
                                            }
                                            else{
                                                current_user.getCart().put(temp, prod_quantity);
                                                curr_prod.setQuantity(prod_quantity_org - prod_quantity);
                                            }
                                        }
                                    }
                                }
                                //ADD DEAL TO CART (ONLY ALLOWED TO ADD ONE QTY OF DEAL)
                                else if (choice_student_second == 4) {
                                    System.out.println("Enter Deal ID you want to add to Cart: ");
                                    int deal_input = scanner.nextInt();
                                    scanner.nextLine();
                                    int flag_deal = 0;
                                    int deal_id = 0;
                                    for(Integer i:Admin.getDeal_ids().keySet()){
                                        if(i == deal_input){
                                            flag_deal = 1;
                                            deal_id = i;
                                        }
                                    }
                                    if(flag_deal == 0){
                                        System.out.println("Given Deal doesn't exist, please try again");
                                    }
                                    else{
                                        ArrayList<Product> curr_deal = Admin.getDeal_ids().get(deal_id);
                                        int deal_quant = 1;
                                        if(current_user.getCart().containsKey(curr_deal)){
                                            System.out.println("You are only allowed to add this deal once in your cart");
                                        }
                                        else{
                                            Product curr_deal_prod1 = curr_deal.get(0);
                                            Product curr_deal_prod2 = curr_deal.get(1);
                                            int quant1 = curr_deal_prod1.getQuantity();
                                            int quant2 = curr_deal_prod2.getQuantity();
                                            if(deal_quant > quant1 || deal_quant > quant2){
                                                System.out.println("These many items are not available for the given deal, please try again");
                                            }
                                            else{
                                                current_user.getCart().put(curr_deal, deal_quant);
                                                curr_deal_prod1.setQuantity(quant1-deal_quant);
                                                curr_deal_prod2.setQuantity(quant2-deal_quant);
                                                System.out.println("Deal Added to Cart");
                                            }
                                        }
                                    }
                                }
                                //VIEW COUPONS
                                else if (choice_student_second == 5) {
                                    if(current_user.getCoupons().size() == 1){
                                        System.out.println("You have no coupons, sorry!");
                                    }
                                    else{
                                        for(int i = 0; i < current_user.getCoupons().size(); i++){
                                            System.out.println((i+1) + ". " + current_user.getCoupons().get(i) + "%");
                                        }
                                    }
                                }
                                //CHECK ACCOUNT BALANCE
                                else if (choice_student_second == 6) {
                                    System.out.println("Current Account Balance is: " + current_user.getWallet());
                                }
                                //VIEW CART
                                else if (choice_student_second == 7) {
                                    if(current_user.getCart().size() == 0){
                                        System.out.println("Your cart is currently empty");
                                    }
                                    else{
                                        for(ArrayList<Product> temp: current_user.getCart().keySet()){
                                            if(temp.get(1) == null){ //talking to a product here
                                                System.out.println("Product: ");
                                                System.out.println(temp.get(0).toString());
                                                System.out.println("Quantity in Cart: " + current_user.getCart().get(temp));
                                                System.out.println("Price(before discount): " + temp.get(0).getPrice());
                                            }
                                            else{ // A Deal
                                                System.out.println("Deal: ");
                                                System.out.println("Product 1: " + temp.get(0).getName());
                                                System.out.println("Product 2: " + temp.get(1).getName());
                                                System.out.println("Deal Price:");
                                                System.out.println("For Normal Users: " + Admin.getDeal_prices_normal().get(temp));
                                                System.out.println("For Prime Users: " + Admin.getDeal_prices_prime().get(temp));
                                                System.out.println("For Elite Users: " + Admin.getDeal_prices_elite().get(temp));
                                                System.out.println("Quantity in Cart: "+ current_user.getCart().get(temp));
                                            }
                                        }
                                    }
                                }
                                //EMPTY CART
                                else if (choice_student_second == 8) {
                                    if(current_user.getCart().size() == 0){
                                        System.out.println("Your cart is currently empty");
                                    }
                                    else{
                                        for(ArrayList<Product> temp : current_user.getCart().keySet()){
                                            if(temp.get(1) == null){ // A Product
                                                int quant_add = current_user.getCart().get(temp);
                                                Product tb_del = temp.get(0);
                                                int org_quant = tb_del.getQuantity();
                                                tb_del.setQuantity(org_quant+quant_add);
                                            }
                                            else{ // A Deal
                                                int quant_add = current_user.getCart().get(temp);
                                                Product tb_del1 = temp.get(0);
                                                Product tb_del2 = temp.get(1);
                                                int org_quant1 = tb_del1.getQuantity();
                                                tb_del1.setQuantity(org_quant1+quant_add);
                                                int org_quant2 = tb_del2.getQuantity();
                                                tb_del2.setQuantity(org_quant2+quant_add);
                                            }
                                        }
                                        current_user.getCart().clear();
                                        System.out.println("Cart Cleared");
                                    }
                                }
                                //CHECKOUT CART
                                else if (choice_student_second == 9) {
                                    double final_order_value = 0;
                                    double org_cart_value = 0; //For delivery charges
                                    ArrayList<Integer> checker_coupons = new ArrayList<>();
                                    for(ArrayList<Product> temp : current_user.getCart().keySet()){
                                        //CURRENT USER IS ELITE
                                        if(user_check[0] == 0){
                                            if(temp.get(1) == null){ //Product
                                                Product curr_prod = temp.get(0);
                                                if(!Product.getProducts().contains(curr_prod)){
                                                    System.out.println("Given Product: " + temp.get(0).getName() + " has been removed from stock and cannot be ordered right now.");
                                                }
                                                else {
                                                    org_cart_value += (curr_prod.getPrice()*(current_user.getCart().get(temp)));
                                                    double disc1 = current_user.getDefault_discount();
                                                    double disc2 = curr_prod.getDiscount_elite();
                                                    double disc3 = Collections.max(current_user.getCoupons());
                                                    double disc_applied = Math.max(disc1, Math.max(disc2, disc3));
                                                    if(disc_applied == disc3){
                                                        checker_coupons.add(1);
                                                    }
                                                    final_order_value += ((1-(disc_applied/100))*(curr_prod.getPrice())*(current_user.getCart().get(temp)));
                                                }
                                            }
                                            else{
                                                Product curr_prod1 = temp.get(0);
                                                Product curr_prod2 = temp.get(1);
                                                if(!Product.getProducts().contains(curr_prod1) || !Product.getProducts().contains(curr_prod2)){
                                                    System.out.println("Deal containing Products " + curr_prod1.getName() + " and " + curr_prod2.getName() + " has been deleted and won't be added to your order.");
                                                    Admin.getDeal_prices_normal().remove(temp);
                                                    Admin.getDeal_prices_elite().remove(temp);
                                                    Admin.getDeal_prices_prime().remove(temp);
                                                }
                                                else{
                                                    org_cart_value += (curr_prod1.getPrice()+curr_prod2.getPrice())*(current_user.getCart().get(temp));
                                                    double price_applied = Admin.getDeal_prices_elite().get(temp);
                                                    final_order_value += price_applied*(current_user.getCart().get(temp));
                                                }
                                            }
                                        }
                                        //CURRENT USER IS PRIME
                                        else if(user_check[0] == 1){
                                            if(temp.get(1) == null){ //Product
                                                Product curr_prod = temp.get(0);
                                                if(!Product.getProducts().contains(curr_prod)){
                                                    System.out.println("Given Product: " + temp.get(0).getName() + " has been removed from stock and cannot be ordered right now.");
                                                }
                                                else {
                                                    org_cart_value += (curr_prod.getPrice()*(current_user.getCart().get(temp)));
                                                    double disc1 = current_user.getDefault_discount();
                                                    double disc2 = curr_prod.getDiscount_prime();
                                                    double disc3 = Collections.max(current_user.getCoupons());
                                                    double disc_applied = Math.max(disc1, Math.max(disc2, disc3));
                                                    if(disc_applied == disc3){
                                                        checker_coupons.add(1);
                                                    }
                                                    final_order_value += ((1-(disc_applied/100))*(curr_prod.getPrice())*(current_user.getCart().get(temp)));
                                                }
                                            }
                                            else{
                                                Product curr_prod1 = temp.get(0);
                                                Product curr_prod2 = temp.get(1);
                                                if(!Product.getProducts().contains(curr_prod1) || !Product.getProducts().contains(curr_prod2)){
                                                    System.out.println("Deal containing Products " + curr_prod1.getName() + " and " + curr_prod2.getName() + " has been deleted and won't be added to your order.");
                                                    Admin.getDeal_prices_normal().remove(temp);
                                                    Admin.getDeal_prices_elite().remove(temp);
                                                    Admin.getDeal_prices_prime().remove(temp);
                                                }
                                                else{
                                                    org_cart_value += (curr_prod1.getPrice()+curr_prod2.getPrice())*(current_user.getCart().get(temp));
                                                    double price_applied = Admin.getDeal_prices_prime().get(temp);
                                                    final_order_value += price_applied*(current_user.getCart().get(temp));
                                                }
                                            }
                                        }
                                        //CURRENT USER IS NORMAL
                                        else{
                                            if(temp.get(1) == null){ //Product
                                                Product curr_prod = temp.get(0);
                                                if(!Product.getProducts().contains(curr_prod)){
                                                    System.out.println("Given Product: " + temp.get(0).getName() + " has been removed from stock and cannot be ordered right now.");
                                                }
                                                else {
                                                    org_cart_value += (curr_prod.getPrice()*(current_user.getCart().get(temp)));
                                                    double disc1 = current_user.getDefault_discount();
                                                    double disc2 = curr_prod.getDiscount_normal();
                                                    double disc_applied = Math.max(disc1, disc2);
                                                    final_order_value += ((1-(disc_applied/100))*(curr_prod.getPrice())*(current_user.getCart().get(temp)));
                                                }
                                            }
                                            else{
                                                Product curr_prod1 = temp.get(0);
                                                Product curr_prod2 = temp.get(1);
                                                if(!Product.getProducts().contains(curr_prod1) || !Product.getProducts().contains(curr_prod2)){
                                                    System.out.println("Deal containing Products " + curr_prod1.getName() + " and " + curr_prod2.getName() + " has been deleted and won't be added to your order.");
                                                    Admin.getDeal_prices_normal().remove(temp);
                                                    Admin.getDeal_prices_elite().remove(temp);
                                                    Admin.getDeal_prices_prime().remove(temp);
                                                }
                                                else{
                                                    org_cart_value += (curr_prod1.getPrice()+curr_prod2.getPrice())*(current_user.getCart().get(temp));
                                                    double price_applied = Admin.getDeal_prices_normal().get(temp);
                                                    final_order_value += price_applied*(current_user.getCart().get(temp));
                                                }
                                            }
                                        }
                                    }

                                    System.out.println("Final order value without discounts is: "+ org_cart_value);

                                    //DELIVERY IS APPLIED ON ORIGINAL PRICE WITHOUT DISCOUNTS

                                    double delivery_charges = (current_user.getFixed_delivery()) + (current_user.getFlex_delivery()*org_cart_value);
                                    System.out.println("Your final order value after discounts is: " + final_order_value);
                                    System.out.println("Delivery Charges on your order are: " + delivery_charges);
                                    final_order_value += delivery_charges;
                                    System.out.println("Your final order value is: "+ final_order_value);
                                    double curr_wallet = current_user.getWallet();
                                    if(curr_wallet < final_order_value){
                                        System.out.println("You do not have enough money in your wallet to go ahead with this order. Please add " + (final_order_value-curr_wallet) + " to confirm this order");
                                    }
                                    else{
                                        if(checker_coupons.contains(1)){
                                            double disc_coupon = Collections.max(current_user.getCoupons());
                                            current_user.getCoupons().remove(disc_coupon);
                                        }
                                        if(org_cart_value >= 5000){
                                            if(user_check[0] == 0){ //ELITE gets 4 coupons ranging from 5-15% discount
                                                System.out.println("Congrats you have won coupons offering discounts: ");
                                                for(int i = 0; i < 4; i++){
                                                    int coupon_gen = random.nextInt(16) + 5;
                                                    current_user.getCoupons().add((double) coupon_gen);
                                                    System.out.println(coupon_gen + "%");
                                                }
                                            }
                                            else if(user_check[0] == 1){ //PRIME gets 2 coupons ranging from 5-15% discount
                                                System.out.println("Congrats you have won coupons offering discounts: ");
                                                for(int i = 0; i < 2; i++){
                                                    int coupon_gen = random.nextInt(16) + 5;
                                                    current_user.getCoupons().add((double) coupon_gen);
                                                    System.out.println(coupon_gen + "%");
                                                }
                                            }
                                        }

                                        System.out.println("Your order has been placed for the items in your Cart. " + "It will reach you in " + current_user.getDelivery_days() + " days");
                                        System.out.println("Your order details are as follows: ");
                                        for(ArrayList<Product> temp: current_user.getCart().keySet()){
                                            if(temp.get(1) == null){ //Product
                                                Product curr_prod = temp.get(0);
                                                if(Product.getProducts().contains(curr_prod)){
                                                    System.out.println("Product: ");
                                                    System.out.println(temp.get(0).toString());
                                                    System.out.println("Quantity in Cart: " + current_user.getCart().get(temp));
                                                    System.out.println("Price(before discount): " + temp.get(0).getPrice());
                                                }
                                            }
                                            else{ // A Deal
                                                Product curr_prod1 = temp.get(0);
                                                Product curr_prod2 = temp.get(1);
                                                if(Product.getProducts().contains(curr_prod1) || Product.getProducts().contains(curr_prod2)){
                                                    System.out.println("Deal: ");
                                                    System.out.println("Product 1: " + temp.get(0).getName());
                                                    System.out.println("Product 2: " + temp.get(1).getName());
                                                    System.out.println("Deal Price:");
                                                    System.out.println("For Normal Users: " + Admin.getDeal_prices_normal().get(temp));
                                                    System.out.println("For Prime Users: " + Admin.getDeal_prices_prime().get(temp));
                                                    System.out.println("For Elite Users: " + Admin.getDeal_prices_elite().get(temp));
                                                    System.out.println("Quantity in Cart: "+ current_user.getCart().get(temp));
                                                }
                                            }
                                        }
                                        current_user.setWallet(curr_wallet - final_order_value);
                                        current_user.getCart().clear();
                                    }
                                }
                                //UPGRADE STATUS
                                else if (choice_student_second == 10) {
                                    System.out.println("Current Status: "+ current_user.getStatus());
                                    System.out.print("Enter your new status: ");
                                    String status_upgrade = scanner.nextLine();
                                    if(user_check[0] == 0){
                                        Human.elite_customers.remove(current_user);
                                    }
                                    else if(user_check[0] == 1){
                                        Human.prime_customers.remove(current_user);
                                    }
                                    else{
                                        Human.normal_customers.remove(current_user);
                                    }
                                    double curr_wallet = current_user.getWallet();
                                    String curr_name = current_user.getUsername();
                                    String curr_pass = current_user.getPassword();
                                    if(status_upgrade.equals("Elite")){
                                        if(curr_wallet > 300){
                                            current_user = new Elite_User(curr_name, curr_pass);
                                            current_user.setWallet(curr_wallet-300);
                                            Human.elite_customers.add(current_user);
                                            System.out.println("User upgraded to ELITE status");
                                        }
                                        else{
                                            System.out.println("Insufficient Balance in Wallet");
                                            System.out.println("Add "+ (300-curr_wallet) + " to proceed with this transaction");
                                        }
                                    }
                                    else if(status_upgrade.equals("Prime")){
                                        if(curr_wallet > 200){
                                            current_user = new Prime_User(curr_name, curr_pass);
                                            current_user.setWallet(curr_wallet-200);
                                            Human.prime_customers.add(current_user);
                                            System.out.println("User upgraded to Prime status");
                                        }
                                        else{
                                            System.out.println("Insufficient Balance in Wallet");
                                            System.out.println("Add "+ (200-curr_wallet) + " to proceed with this transaction");
                                        }
                                    }
                                    else{
                                        System.out.println("Not a valid status to upgrade to.");
                                    }
                                }
                                //ADD AMOUNT TO WALLET
                                else if (choice_student_second == 11) {
                                    System.out.println("Current Amount in Wallet: "+ current_user.getWallet());
                                    System.out.print("How much amount would you like to add?: ");
                                    double amt_wallet = scanner.nextDouble();
                                    scanner.nextLine();
                                    current_user.setWallet(current_user.getWallet()+amt_wallet);
                                    System.out.println("Added Successfully");
                                }
                                else if (choice_student_second == 12) {
                                    System.out.println("Bye " + current_user.getUsername());
                                    break;
                                }
                                else {
                                    System.out.println("Invalid choice");
                                }
                            }
                        }
                    }
                    else if (choice_customer_first == 3) {
                        break;
                    }
                    else{
                        System.out.println("Invalid Choice");
                    }
                }
            }
            else if(choice1 == 5){
                break;
            }
            else{
                System.out.println("Invalid Choice");
            }
        }
        scanner.close();
    }
    static int[] check_customer_type(Customer customer){
        int[] return_val = new int[2];
        return_val[0] = -1;
        return_val[1] = -1;
        for(int i = 0; i < Human.elite_customers.size(); i++){
            if(Human.elite_customers.get(i).getUsername().equals(customer.getUsername()) && Human.elite_customers.get(i).getPassword().equals(customer.getPassword())){
                return_val[0] = 0;
                return_val[1] = i;
                return return_val;
            }
        }
        for(int i = 0; i < Human.prime_customers.size(); i++){
            if(Human.prime_customers.get(i).getUsername().equals(customer.getUsername()) && Human.prime_customers.get(i).getPassword().equals(customer.getPassword())){
                return_val[0] = 1;
                return_val[1] = i;
                return return_val;
            }
        }
        for(int i = 0; i < Human.normal_customers.size(); i++){
            if(Human.normal_customers.get(i).getUsername().equals(customer.getUsername()) && Human.normal_customers.get(i).getPassword().equals(customer.getPassword())){
                return_val[0] = 2;
                return_val[1] = i;
                return return_val;
            }
        }
        return return_val;
    }
    static int @NotNull [] Category_Checker(){
        int[] ret = new int[2];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Add Category ID: ");
        double id_input = scanner.nextDouble();
        scanner.nextLine();
        int flag_category_id = 0;
        int indx_flag = 0;
        for(int i = 0; i < Category.getCategories().size(); i++){
            if(Category.getCategories().get(i).getId() == id_input){
                flag_category_id = 1;
                indx_flag = i;
                break;
            }
        }
        ret[0] = flag_category_id;
        ret[1] = indx_flag;
        return ret;
    }
}
