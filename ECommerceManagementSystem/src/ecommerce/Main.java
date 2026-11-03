
package ecommerce;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ECommerce shop = new ECommerce();

        int choice = 0;

        do {

            System.out.println("\n======================================");
            System.out.println("        E-COMMERCE SHOPPING SYSTEM");
            System.out.println("======================================");
            System.out.println("1. View All Products");
            System.out.println("2. Search Product by ID");
            System.out.println("3. Search Product by Name");
            System.out.println("4. Add Product to Cart");
            System.out.println("5. View Shopping Cart");
            System.out.println("6. Remove Product from Cart");
            System.out.println("7. Calculate Total Bill");
            System.out.println("8. Place Order");
            System.out.println("9. View Order Details");
            System.out.println("10. Exit");
            System.out.println("======================================");

            System.out.print("Enter your choice (1-10): ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Enter a number.");
                sc.nextLine();
                continue;
            }

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    shop.viewProducts();
                    break;

                case 2:

                    System.out.print("Enter Product ID (e.g., 101): ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    Product product = shop.searchById(id);

                    if (product != null) {
                        product.displayProduct();
                    } else {
                        System.out.println("Product not found!");
                    }

                    break;

                case 3:

                    System.out.print("Enter Product Name to search: ");
                    String name = sc.nextLine();

                    shop.searchByName(name);
                    break;

                case 4:

                    System.out.print("Enter Product ID to add (e.g., 101): ");
                    id = sc.nextInt();

                    System.out.print("Enter Quantity: ");
                    int quantity = sc.nextInt();
                    sc.nextLine();

                    product = shop.searchById(id);

                    if (product != null) {
                        shop.cart.addToCart(product, quantity);
                    } else {
                        System.out.println("Product not found!");
                    }

                    break;

                case 5:

                    shop.cart.viewCart();
                    break;

                case 6:

                    System.out.print("Enter Product ID to remove: ");
                    id = sc.nextInt();
                    sc.nextLine();

                    shop.cart.removeFromCart(id);
                    break;

                case 7:

                    System.out.println("\nTotal Shopping Bill: Rs. "
                            + shop.cart.calculateTotal());

                    break;

                case 8:

                    System.out.print("Confirm order? (yes/no): ");
                    String confirm = sc.nextLine();

                    if (confirm.equalsIgnoreCase("yes")) {
                        shop.placeOrder();
                    } else {
                        System.out.println("Order cancelled.");
                    }

                    break;

                case 9:

                    shop.viewOrderDetails();
                    break;

                case 10:

                    System.out.println("\nThank you for shopping with us!");
                    break;

                default:

                    System.out.println("Invalid choice! Select 1-10.");
            }

        } while (choice != 10);

        sc.close();
    }
}
