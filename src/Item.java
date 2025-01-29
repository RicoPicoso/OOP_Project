public class Item {
    private String name;
    private double price;
    private int quantity;
    private double tax;

    public Item(String name, double price, int quantity, double tax) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.tax = tax;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTax() {
        return tax;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    @Override
    public String toString() {
        return name + " " + price + " - €" + " (Amount: " + quantity + ", Tax rate: "
        + tax + "%)";
    }
}
