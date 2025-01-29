import java.util.ArrayList;
import java.util.List;

public class Cart {

    private ArrayList<Item> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public void addToCart(Item item, int quantity) throws IllegalArgumentException {

        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be > 0.");
        }
        if (item.getQuantity() < quantity) {
            throw new IllegalArgumentException("Not enough stock for " + item.getName());
        }

        Item cartItem = new Item(item.getName(), item.getPrice(), quantity);
        items.add(cartItem);
        item.setQuantity(item.getQuantity() - quantity);
        System.out.println(quantity + " " + item.getName() + " added to the cart.");

    }

    public double totalPrice() {
        double total = 0;

        for (Item item : items) {
            total += item.getPrice() * item.getQuantity();
        }
        //Using Math class method.
        return Math.round(total * 100.0) / 100.0;
    }

    public double applyDiscount(double total, double discountPercentage) {
        return total * (1 - discountPercentage / 100);
    }

    public void displayCart() {
        System.out.println("Cart contents: ");

        for (Item item : items) {
            System.out.println(item);
        }
    }

    public void emptyCart(){
        items.clear();
    }
}
