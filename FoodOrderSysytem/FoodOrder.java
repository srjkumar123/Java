import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FoodOrder {
    private static final Map<String, Cuisine> CUISINE = new HashMap<>();
    private static final Scanner Input = new Scanner(System.in);
    private static Cuisine selectCuisine = null;
    private static Order order = new Order();


    static {
        // Initialize cuisines and their dishes
        Cuisine indian = new Cuisine("Indian");
        indian.addDish("Paneer Butter Masala", 250.00);
        indian.addDish("Butter Naan", 40.00);
        indian.addDish("Biryani", 200.00);

        Cuisine italian = new Cuisine("Italian");
        italian.addDish("Margherita Pizza", 300.00);
        italian.addDish("Pasta Alfredo", 250.00);
        italian.addDish("Lasagna", 350.00);

        Cuisine chinese = new Cuisine("Chinese");
        chinese.addDish("Spring Rolls", 150.00);
        chinese.addDish("Kung Pao Chicken", 300.00);
        chinese.addDish("Fried Rice", 200.00);

        CUISINE.put("Indian", indian);
        CUISINE.put("Italian", italian);
        CUISINE.put("Chinese", chinese);
    }

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n ---Food Ordering System-----");
            System.out.println("1. Choose Cuisine");
            System.out.println("2. View Dishes in selected cuisine.");
            System.out.println("3. Place an Order");
            System.out.println("4. View Order Summary");
            System.out.println("5. exit");
            System.out.println("Please Choose an Option: ");


            int choice = Input.nextInt();
            Input.nextLine();

            switch (choice) {
                case 1:
                    chooseCuisine();
                    break;
                case 2:
                    viewDishes();
                    break;
                case 3:
                    placeOrder();
                    break;
                case 4:
                    viewOrderSummary();
                    break;
                case 5:
                    System.out.println("Thank you for using the Food Ordering System");
                    return;
                default:
                    System.out.println("Invalid Option. Try again...");
            }
        }
    }


    public static void chooseCuisine() {
        System.out.println("\n ----------Choose cuisine--------------");
        int index = 1;
        for (String cuisineName : CUISINE.keySet()) {
            System.out.println(index++ + ". " + cuisineName);
        }
        System.out.println("Which cuisine would you like to have? ");
        int cuisineChoice = Input.nextInt();
        Input.nextLine();

        if (cuisineChoice >= 1 && cuisineChoice <= CUISINE.size()) {
            selectCuisine = CUISINE.get(CUISINE.keySet().toArray()[cuisineChoice - 1]);
            System.out.println("Selected Cuisine: " + selectCuisine.getName());
        } else {
            System.out.println("Invalid selction. Try Again....");
        }
    }

    //view dishes

    public static void viewDishes() {
        if (selectCuisine == null) {
            System.out.println("Please select a cuisine first");
            return;
        }
        selectCuisine.viewDishes();
    }


    //place order
    public static void placeOrder() {
        if (selectCuisine == null) {
            System.out.println("Please choose a cuisine first.");
            return;
        }

        System.out.println("Plase enter the dish name or 'done' to finish.");
        while (true) {
            String dish = Input.nextLine();
            if (dish.equalsIgnoreCase("done")) {
                break;
            }

            Double price = selectCuisine.getDishes().get(dish);
            if (price != null) {
                order.addItem(dish, price);
                System.out.println(dish + " has been add to your order.");
            } else {
                System.out.println("Invalid dish name");
            }

            System.out.println("Plase enter the dish name or 'done' to finish.");
        }
    }


    public static void viewOrderSummary() {
        order.displayOrderSummary();
    }
}
