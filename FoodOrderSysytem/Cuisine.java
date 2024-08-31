import java.util.HashMap;
import java.util.Map;

public class Cuisine {
    private final String name;
    private final Map<String, Double> dishes;


    public Cuisine(String name) {
        this.dishes = new HashMap<>();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addDish(String dishname, Double price) {
        dishes.put(dishname, price);
    }

    public Map<String, Double> getDishes() {
        return dishes;
    }

    public void viewDishes() {
        System.out.println("\n--- Dishes in " + name + "Cuisine---");
        if (dishes.isEmpty()) {
            System.out.println("No dishes available. ");
        } else {
            dishes.forEach((d, p) -> System.out.println(d + "- Rs." + p));
        }
    }
}
