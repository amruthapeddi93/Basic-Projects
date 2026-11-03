
package ecommerce;

public class Product {

    int productId;
    String productName;
    String category;
    double price;
    int stock;

    public Product(int productId, String productName,
                   String category, double price, int stock) {

        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.stock = stock;
    }

    public void displayProduct() {

        System.out.println("\n========== PRODUCT DETAILS ==========");
        System.out.println("Product ID   : " + productId);
        System.out.println("Product Name : " + productName);
        System.out.println("Category     : " + category);
        System.out.println("Price        : Rs. " + price);
        System.out.println("Stock        : " + stock);
        System.out.println("=====================================");
    }
}
