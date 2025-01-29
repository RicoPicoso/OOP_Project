import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Cart cart = new Cart();
        Scanner sc = new Scanner(System.in);

        //Items for testing
        inventory.addItem(new Item("Lacasitos", 2.49, 15));
        inventory.addItem(new Item("Sandwich", 49.99, 50));
        inventory.addItem(new Item("Bocata", 5, 3));
        inventory.addItem(new Item("TV", 1000, 1));

        inventory.displayInventory();

        while(true){
            System.out.println("1. Add product to cart.");
            System.out.println("2. View cart");
            System.out.println("3. Checkout");
            System.out.println("4. Exit.");
            System.out.println("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter product name: ");
                    String productName = sc.nextLine();
                    Item product = inventory.findItem(productName);
                    if (product != null) {
                        System.out.print("Enter quantity: ");
                        int quantity = sc.nextInt();
                        cart.addToCart(product, quantity);
                        inventory.displayInventory();
                    } else {
                        System.out.println("Product not found.");
                    }
                }
                case 2 -> {
                    cart.displayCart();
                    double total = cart.totalPrice();
                    System.out.println("Total: " + total + (" €"));
                }
                case 3 -> {
                    double totalAmount = cart.totalPrice();
                    System.out.println("Total before discount: " + totalAmount + " €");
                    System.out.print("Enter discount percentage: ");
                    double discount = sc.nextDouble();
                    double finalAmount = cart.applyDiscount(totalAmount, discount);
                    System.out.println("Total after discount: " + finalAmount + " €");
                    cart.emptyCart();
                }
                case 4 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid option.");
            }

        }

    }
}