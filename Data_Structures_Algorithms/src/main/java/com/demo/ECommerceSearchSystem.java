package com.demo;
public class ECommerceSearchSystem {
    static class Product {
        private int productId;
        private String productName;
        private String category;
        public Product(int productId, String productName, String category) {
            this.productId = productId;
            this.productName = productName;
            this.category = category;
        }
        public int getProductId() {
            return productId;
        }
        @Override
        public String toString() {
            return "Product{" +
                    "productId=" + productId +
                    ", productName='" + productName + '\'' +
                    ", category='" + category + '\'' +
                    '}';
        }
    }

    public static Product linearSearch(Product[] products, int targetId) {
        for (Product product : products) {
            if (product.getProductId() == targetId) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, int targetId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (products[mid].getProductId() == targetId) {
                return products[mid];
            }

            if (products[mid].getProductId() < targetId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
                new Product(101, "Laptop", "Electronics"),
                new Product(102, "Keyboard", "Accessories"),
                new Product(103, "Mouse", "Accessories"),
                new Product(104, "Monitor", "Electronics"),
                new Product(105, "Headphones", "Audio")
        };

        Product linearResult = linearSearch(products, 104);
        System.out.println("Linear Search Result:");
        System.out.println(linearResult);

        Product binaryResult = binarySearch(products, 104);
        System.out.println("\nBinary Search Result:");
        System.out.println(binaryResult);
    }
}