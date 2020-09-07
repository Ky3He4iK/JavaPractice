package dev.ky3he4ik.lab.lab16;

import org.jetbrains.annotations.Nullable;

public class InternetOrdersManager implements OrdersManager {
    private QueueNode head = null;
    private QueueNode tail = null;
    private int size = 0;

    @Nullable
    private QueueNode getOrderNode(Address address) {
        QueueNode node = head;
        while (node != null) {
            if (node.value.getCustomer().getAddress().equals(address))
                return node;
            node = node.next;
        }
        return null;
    }

    public boolean add(Order order) throws OrderAlreadyAddedException {
        if (head.value == null)
            head.value = order;
        else if (tail == null) {
            if (head.value.getCustomer().getAddress().equals(order.getCustomer().getAddress()))
                throw new OrderAlreadyAddedException("Address " + order.getCustomer().getAddress().toString() + " has already order");
            tail = new QueueNode(head, order);
            head.prev = tail;
        } else {
            QueueNode orderNode = getOrderNode(order.getCustomer().getAddress());
            if (orderNode != null)
                throw new OrderAlreadyAddedException("Address " + order.getCustomer().getAddress().toString() + " has already order");
            tail = new QueueNode(tail, order);
            (tail.prev).next = tail; // Set `node before tail`.next
        }
        size++;
        return true;
    }

    @Nullable
    public Order remove(Address orderAddress) {
        QueueNode orderNode = getOrderNode(orderAddress);
        if (orderNode == null)
            return null;
        if (orderNode.next != null)
            (orderNode.next).prev = orderNode.prev; // connect nodes before and after found node
        if (orderNode.prev != null)
            (orderNode.prev).next = orderNode.next;
        size--;
        return orderNode.value;
    }

    public Order order(Address orderAddress) {
        QueueNode orderNode = getOrderNode(orderAddress);
        if (orderNode == null)
            return null;
        else
            return orderNode.value;
    }

    @Override
    public int itemsQuantity(String itemName) {
        QueueNode node = head;
        int cnt = 0;
        while (node != null) {
            cnt += node.value.itemQuantity(itemName);
            node = node.next;
        }
        return cnt;
    }

    @Override
    public int itemsQuantity(MenuItem item) {
        QueueNode node = head;
        int cnt = 0;
        while (node != null) {
            cnt += node.value.itemQuantity(item);
            node = node.next;
        }
        return cnt;
    }

    @Override
    public Order[] getOrders() {
        QueueNode node = head;
        Order[] orders = new Order[size];
        int j = 0;
        while (node != null) {
            orders[j++] = node.value;
            node = node.next;
        }
        return orders;
    }

    @Override
    public int ordersCostSummary() {
        QueueNode node = head;
        int cost = 0;
        while (node != null) {
            cost += node.value.costTotal();
            node = node.next;
        }
        return cost;
    }

    @Override
    public int ordersQuantity() {
        return size;
    }

}
