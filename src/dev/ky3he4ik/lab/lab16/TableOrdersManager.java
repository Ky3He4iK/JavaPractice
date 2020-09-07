package dev.ky3he4ik.lab.lab16;

import org.jetbrains.annotations.Nullable;

public class TableOrdersManager implements OrdersManager {
    public static final int TABLES_NUM = 10;
    private Order[] orders = new Order[TABLES_NUM];
    private int ordersCount = 0;

    private void checkTableNumber(int tableNumber) {
        if (tableNumber > TABLES_NUM || tableNumber <= 0)
            throw new IllegalTableNumber("Table with number " + tableNumber + " does not exist");
    }

    public void add(Order order, int tableNumber) throws OrderAlreadyAddedException {
        checkTableNumber(tableNumber);
        if (orders[tableNumber - 1] != null)
            throw new OrderAlreadyAddedException("Table №" + tableNumber + " has already have an order");
        ordersCount++;
        orders[tableNumber - 1] = order;
    }

    public void addItem(MenuItem item, int tableNumber) {
        checkTableNumber(tableNumber);
        if (orders[tableNumber - 1] == null)
            throw new IllegalArgumentException("Table №" + tableNumber + " has no order!");
        orders[tableNumber - 1].add(item);
    }

    public int freeTableNumber() {
        for (int i = 0; i < TABLES_NUM; i++)
            if (orders[i] == null)
                return i;
        return -1;
    }

    public int[] freeTableNumbers() {
        int[] freeNumbers = new int[TABLES_NUM - ordersCount];
        int j = 0;
        for (int i = 0; i < TABLES_NUM; i++)
            if (orders[i] == null)
                freeNumbers[j++] = i + 1;
        return freeNumbers;
    }

    @Nullable
    public Order getOrder(int tableNumber) {
        checkTableNumber(tableNumber);
        return orders[tableNumber - 1];
    }

    public void remove(int tableNumber) {
        checkTableNumber(tableNumber);
        if (orders[tableNumber - 1] != null) {
            ordersCount--;
            orders[tableNumber - 1] = null;
        }
    }

    public int remove(Order order) {
        if (order == null)
            return 0;
        for (int i = 0; i < TABLES_NUM; i++) {
            if (order.equals(orders[i])) {
                orders[i] = null;
                ordersCount--;
                return 1;
            }
        }
        return 0;
    }

    public int removeAll(Order order) {
        if (order == null)
            return 0;
        int removeCnt = 0;
        for (int i = 0; i < TABLES_NUM; i++) {
            if (order.equals(orders[i])) {
                removeCnt++;
                orders[i] = null;
            }
        }
        ordersCount -= removeCnt;
        return removeCnt;
    }

    @Override
    public int itemsQuantity(String itemName) {
        int cnt = 0;
        for (Order order: orders) {
            if (order != null)
                cnt += order.itemQuantity(itemName);
        }
        return cnt;
    }

    @Override
    public int itemsQuantity(MenuItem item) {
        int cnt = 0;
        for (Order order: orders) {
            if (order != null)
                cnt += order.itemQuantity(item);
        }
        return cnt;
    }

    @Override
    public Order[] getOrders() {
        Order[] activeOrders = new Order[ordersCount];
        int j = 0;
        for (int i = 0; i < TABLES_NUM; i++)
            if (orders[i] != null)
                activeOrders[j++] = orders[i];
        return activeOrders;
    }

    @Override
    public int ordersCostSummary() {
        int cost = 0;
        for (Order order: orders) {
            if (order != null)
                cost += order.costTotal();
        }
        return cost;
    }

    @Override
    public int ordersQuantity() {
        return ordersCount;
    }
}
