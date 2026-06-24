package com.demo;

public class OrderSortingSystem {

    static class Order {
        private int orderId;
        private String customerName;
        private double totalPrice;

        public Order(int orderId, String customerName, double totalPrice) {
            this.orderId = orderId;
            this.customerName = customerName;
            this.totalPrice = totalPrice;
        }

        public double getTotalPrice() {
            return totalPrice;
        }

        @Override
        public String toString() {
            return "Order{" +
                    "orderId=" + orderId +
                    ", customerName='" + customerName + '\'' +
                    ", totalPrice=" + totalPrice +
                    '}';
        }
    }

    public static void bubbleSort(Order[] orders) {
        int n = orders.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(orders, low, high);
            quickSort(orders, low, pivotIndex - 1);
            quickSort(orders, pivotIndex + 1, high);
        }
    }

    public static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].getTotalPrice();
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (orders[j].getTotalPrice() <= pivot) {
                i++;

                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }

        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }

    public static void displayOrders(Order[] orders) {
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    public static void main(String[] args) {

        Order[] bubbleOrders = {
                new Order(101, "Alice", 2500),
                new Order(102, "Bob", 1200),
                new Order(103, "David", 4500),
                new Order(104, "Emma", 1800)
        };

        System.out.println("Before Bubble Sort:");
        displayOrders(bubbleOrders);

        bubbleSort(bubbleOrders);

        System.out.println("\nAfter Bubble Sort:");
        displayOrders(bubbleOrders);

        Order[] quickOrders = {
                new Order(101, "Alice", 2500),
                new Order(102, "Bob", 1200),
                new Order(103, "David", 4500),
                new Order(104, "Emma", 1800)
        };

        quickSort(quickOrders, 0, quickOrders.length - 1);

        System.out.println("\nAfter Quick Sort:");
        displayOrders(quickOrders);
    }
}
