package dev.ky3he4ik.lab.lab16;

public class TableOrdersManager implements OrdersManager {
    private Order[] orders;

    public void add(Order order, int tableNumber) {
        //todo
    }

    public void addItem(MenuItem item, int tableNumber) {
        //todo
    }

    public int freeTableNumber() {
        return 0;//todo
    }

    public int[] freeTableNumbers() {
        return new int[0];//todo
    }

    public Order getOrder(int tableNumber) {
        return null;//todo
    }

    public void remove(int tableNumber) {
        //todo
    }

    public int remove(Order order) {
        return 0;//todo
    }

    public int removeAll(Order order) {
        return 0;//todo
    }

    @Override
    public int itemsQuantity(String itemName) {
        return 0;//todo
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
