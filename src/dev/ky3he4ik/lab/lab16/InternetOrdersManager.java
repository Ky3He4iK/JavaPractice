package dev.ky3he4ik.lab.lab16;

public class InternetOrdersManager implements OrdersManager {
    private QueueNode head;
    private QueueNode tail;
    private int size;

    public boolean add(Order order) {
        return false;//todo
    }

    public Order remove() {
        return null;//todo
    }

    public Order order() {
        return null;//todo
    }

    @Override
    public int itemsQuantity(String itemName) {
        return 0; //todo
    }

    @Override
    public int itemsQuantity(MenuItem item) {
        return 0;//todo
    }

    @Override
    public Order[] getOrders() {
        return new Order[0];//todo
    }

    @Override
    public int ordersCostSummary() {
        return 0;//todo
    }

    @Override
    public int ordersQuantity() {
        return 0;//todo
    }

}
