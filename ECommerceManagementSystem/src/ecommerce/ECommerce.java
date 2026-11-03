
package ecommerce;

import java.util.ArrayList;

public class ECommerce {

    ArrayList<Product> products = new ArrayList<>();

    Cart cart = new Cart();

    int orderNumber = 1001;
    String lastOrderDetails = "";

    // Constructor: Add Sample Products
    public ECommerce() {

        products.add(new Product(101, "Samsung Galaxy S24",
                "Mobiles", 45000, 10));

        products.add(new Product(102, "iPhone 15",
                "Mobiles", 60000, 8));

        products.add(new Product(103, "HP Laptop",
                "Laptops", 55000, 5));

        products.add(new Product(104, "Dell Laptop",
                "Laptops", 62000, 7));

        products.add(new Product(105, "Men's T-Shirt",
                "Clothing", 799, 20));

        products.add(new Product(106, "Women's Kurti",
                "Clothing", 999, 15));

        products.add(new Product(107, "Sports Shoes",
                "Footwear", 1999, 12));

        products.add(new Product(108, "Smart Watch",
                "Accessories", 2499, 10));

        products.add(new Product(109, "Headphones",
                "Accessories", 1499, 18));

        products.add(new Product(110, "Bluetooth Speaker",
                "Electronics", 2999, 9));
    }

    // View Products
    public void viewProducts() {

        System.out.println("\n========== AVAILABLE PRODUCTS ==========");

        for (Product p : products) {
            p.displayProduct();
        }
    }

    // Search by ID
    public Product searchById(int id) {

        for (Product p : products) {

            if (p.productId == id) {
                return p;
            }
        }

        return null;
    }

    // Search by Name
    public void searchByName(String name) {

        boolean found = false;

        for (Product p : products) {

            if (p.productName.toLowerCase()
                    .contains(name.toLowerCase())) {

                p.displayProduct();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching products found!");
        }
    }

    // Place Order
    public void placeOrder() {

        if (cart.cartItems.isEmpty()) {
            System.out.println("Your cart is empty!");
            return;
        }

        // Verify stock before processing
        for (int i = 0; i < cart.cartItems.size(); i++) {

            Product p = cart.cartItems.get(i);

            if (cart.quantities.get(i) > p.stock) {
                System.out.println("Insufficient stock for " + p.productName);
                return;
            }
        }

        double total = cart.calculateTotal();

        StringBuilder details = new StringBuilder();

        details.append("\n========== ORDER CONFIRMATION ==========\n");
        details.append("Order Number: ").append(orderNumber).append("\n");

        for (int i = 0; i < cart.cartItems.size(); i++) {

            Product p = cart.cartItems.get(i);
            int quantity = cart.quantities.get(i);

            details.append(p.productName)
                   .append(" | Quantity: ").append(quantity)
                   .append(" | Amount: Rs. ")
                   .append(p.price * quantity).append("\n");

            p.stock -= quantity;
        }

        details.append("Total Amount: Rs. ").append(total).append("\n");
        details.append("Order Status: Confirmed\n");
        details.append("========================================");

        lastOrderDetails = details.toString();

        System.out.println(lastOrderDetails);

        orderNumber++;

        cart.clearCart();
    }

    // View Last Order
    public void viewOrderDetails() {

        if (lastOrderDetails.isEmpty()) {
            System.out.println("No orders placed yet!");
            return;
        }

        System.out.println(lastOrderDetails);
    }
}
