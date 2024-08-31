import java.util.HashMap;
import java.util.Map;

public class Order {
    private final Map<String, Double> items;
    private double totalCost;


    public Order() {
        items = new HashMap<>();
        totalCost = 0;
    }


    public void addItem(String itemName, double price) {
        if (items.containsKey(itemName)) {
            items.put(itemName, items.get(itemName) + price);
        } else {
            items.put(itemName, price);
        }
        totalCost += price;
    }

    //display ordersummary
    public void displayOrderSummary() {
        if (items.isEmpty()) {
            System.out.println("Your order is empty.");
            return;
        }

        System.out.println("\n ------Order Summary-------");
        items.forEach((item, price)-> System.out.println(item + " - Rs."+price));
        System.out.println("Total Cost: Rs."+ totalCost);
    }

    //method to get total cost
    public double getTotal(){
        return totalCost;
    }


}
