package com.demo;
import java.util.HashMap;
import java.util.Map;
class Product {
    private Integer productID;
    private String productName;
    private Integer quantity;
    private Double price;
    public Product(Integer productID, String productName, Integer quantity, Double price) {
        this.productID = productID;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }
    public Integer getProductID() {
        return productID;
    }
    public void setProductID(Integer productID) {
        this.productID = productID;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productID +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
class Inventory {
    private Map<Integer, Product> products;
    public Inventory() {
        products = new HashMap<>();
    }
    public void addProduct(Product product) {
        products.put(product.getProductID(), product);
        System.out.println("Product Added Successfully");
    }
    public void updateProduct(int productId, String name, int quantity, double price) {
        Product product = products.get(productId);
        if(product != null) {
            product.setProductName(name);
            product.setPrice(price);
            product.setQuantity(quantity);
            System.out.println("Product details updated successfully");
        } else {
            System.out.println("Product not found");
        }
    }
    public void deleteProduct(int productId) {
        if(products.remove(productId) != null) {
            System.out.println("Product Deleted successfully");
        } else {
            System.out.println("Product not found");
        }
    }
    public void displayProducts() {
        for(Product product: products.values()) {
            System.out.println(product);
        }
    }
}
public class InventoryManagement {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.addProduct(new Product(101, "Laptop", 20, 55000.00));
        inventory.addProduct(new Product(102, "Keyboard", 50, 1200.00));
        inventory.addProduct(new Product(103, "Mouse", 75, 700.00));
        System.out.println("\nInventory:");
        inventory.displayProducts();
        inventory.updateProduct(102, "Mechanical Keyboard", 45, 1800.00);
        inventory.deleteProduct(103);
        System.out.println("\nUpdated Inventory:");
        inventory.displayProducts();
    }
}
