
package ecommerce;

import java.util.ArrayList;

public class Cart {

    ArrayList<Product> cartItems = new ArrayList<>();
    ArrayList<Integer> quantities = new ArrayList<>();

    // Add Product to Cart
    public void addToCart(Product product, int quantity) {

        if (quantity <= 0) {
            System.out.println("Quantity must be greater than zero!");
            return;
        }

        if (quantity > product.stock) {
            System.out.println("Insufficient stock!");
            return;
        }

        int index = cartItems.indexOf(product);

        if (index != -1) {

            int newQuantity = quantities.get(index) + quantity;

            if (newQuantity > product.stock) {
                System.out.println("Requested quantity exceeds available stock!");
                return;
            }

            quantities.set(index, newQuantity);

        } else {

            cartItems.add(product);
            quantities.add(quantity);
        }

        System.out.println("Product added to cart successfully!");
    }

    // View Cart
    public void viewCart() {

        if (cartItems.isEmpty()) {
            System.out.println("\nYour shopping cart is empty.");
            return;
        }

        double total = 0;

        System.out.println("\n========== SHOPPING CART ==========");

        for (int i = 0; i < cartItems.size(); i++) {

            Product p = cartItems.get(i);
            int quantity = quantities.get(i);

            double amount = p.price * quantity;
            total += amount;

            System.out.println("\nProduct ID : " + p.productId);
            System.out.println("Name       : " + p.productName);
            System.out.println("Price      : Rs. " + p.price);
            System.out.println("Quantity   : " + quantity);
            System.out.println("Amount     : Rs. " + amount);
        }

        System.out.println("\nTotal Amount: Rs. " + total);
        System.out.println("===================================");
    }

    // Remove Product
    public void removeFromCart(int id) {

        for (int i = 0; i < cartItems.size(); i++) {

            if (cartItems.get(i).productId == id) {

                cartItems.remove(i);
                quantities.remove(i);

                System.out.println("Product removed from cart!");
                return;
            }
        }

        System.out.println("Product not found in cart!");
    }

    // Calculate Total
    public double calculateTotal() {

        double total = 0;

        for (int i = 0; i < cartItems.size(); i++) {

            total += cartItems.get(i).price * quantities.get(i);
        }

        return total;
    }

    // Clear Cart
    public void clearCart() {

        cartItems.clear();
        quantities.clear();
    }
}
