package dev.ky3he4ik.lab.lab16;

public interface OrdersManager {
    int itemsQuantity(String itemName);

    int itemsQuantity(MenuItem item);

    Order[] getOrders();

    int ordersCostSummary();

    int ordersQuantity();
}
