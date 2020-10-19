package dev.ky3he4ik.lab.lab16;

import java.util.HashMap;

public class InternetOrder implements Order {
    private int size = 0;
    private ListNode head = null;
    private ListNode tail = null;
    private Customer customer;

    public InternetOrder() {
    }

    public InternetOrder(MenuItem[] items) {
        for (MenuItem item : items)
            add(item);
    }


    @Override
    public boolean add(MenuItem item) {
        if (head.value == null)
            head.value = item;
        else if (tail == null)
            tail = new ListNode(head, item);
        else
            tail = new ListNode(tail, item);
        size++;
        return true;
    }

    @Override
    public String[] itemsNames() {
        MenuItem[] items = getItems();
        HashMap<String, Boolean> orders = new HashMap<>();
        for (MenuItem item : items)
            if (!orders.containsKey(item.getName()))
                orders.put(item.getName(), true);

        return (String[]) orders.keySet().toArray();
    }

    @Override
    public int itemsQuantity() {
        return size;
    }

    @Override
    public int itemQuantity(String itemName) {
        if (tail == null) {
            if (head.value != null && head.value.getName().equals(itemName)) {
                return 1;
            }
            return 0;
        }
        ListNode currNode = tail;
        int cnt = 0;
        while (currNode != null) {
            if (currNode.value.getName().equals(itemName)) {
                cnt++;
            }
            currNode = currNode.prev;
        }
        return cnt;
    }

    @Override
    public int itemQuantity(MenuItem item) {
        if (tail == null) {
            if (head.value != null && head.value.equals(item))
                return 1;
            return 0;
        }
        ListNode currNode = tail;
        int cnt = 0;
        while (currNode != null) {
            if (currNode.value.equals(item))
                cnt++;
            currNode = currNode.prev;
        }
        return cnt;
    }

    @Override
    public MenuItem[] getItems() {
        if (tail == null) {
            if (head.value != null)
                return new MenuItem[]{head.value};
            return new MenuItem[]{};
        }
        MenuItem[] items = new MenuItem[size];
        ListNode currNode = tail;
        int id = 1;
        while (currNode != null) {
            items[id++] = currNode.value;
            currNode = currNode.prev;
        }
        return items;
    }

    @Override
    public boolean remove(String itemName) {
        if (tail == null) {
            if (head.value != null && head.value.getName().equals(itemName)) {
                head.value = null;
                return true;
            }
            return false;
        }
        ListNode currNode = tail;
        ListNode prevNode = tail;
        while (currNode != null) {
            if (currNode.value.getName().equals(itemName)) {
                prevNode.prev = currNode.prev;
                return true;
            }
            prevNode = currNode;
            currNode = currNode.prev;
        }
        return false;
    }

    @Override
    public boolean remove(MenuItem item) {
        if (tail == null) {
            if (head.value != null && head.value.equals(item)) {
                head.value = null;
                return true;
            }
            return false;
        }
        ListNode currNode = tail;
        ListNode prevNode = tail;
        while (currNode != null) {
            if (currNode.value.equals(item)) {
                prevNode.prev = currNode.prev;
                return true;
            }
            prevNode = currNode;
            currNode = currNode.prev;
        }
        return false;
    }

    @Override
    public int removeAll(String itemName) {
        if (tail == null) {
            if (head.value != null && head.value.getName().equals(itemName)) {
                head.value = null;
                return 1;
            }
            return 0;
        }
        ListNode currNode = tail;
        ListNode prevNode = tail;
        int cnt = 0;
        while (currNode != null) {
            if (currNode.value.getName().equals(itemName)) {
                prevNode.prev = currNode.prev;
                cnt++;
            }
            prevNode = currNode;
            currNode = currNode.prev;
        }
        return cnt;
    }

    @Override
    public int removeAll(MenuItem item) {
        if (tail == null) {
            if (head.value != null && head.value.equals(item)) {
                head.value = null;
                return 1;
            }
            return 0;
        }
        ListNode currNode = tail;
        ListNode prevNode = tail;
        int cnt = 0;
        while (currNode != null) {
            if (currNode.value.equals(item)) {
                prevNode.prev = currNode.prev;
                cnt++;
            }
            prevNode = currNode;
            currNode = currNode.prev;
        }
        return cnt;
    }

    @Override
    public MenuItem[] sortedItemsByCostDesc() {
        MenuItem[] items = getItems();
        for (int i = 0; i < items.length; i++) {
            boolean wasSwap = false;
            for (int j = 1; j < items.length; j++) {
                if (items[j - 1].getCost() < items[j].getCost()) {
                    MenuItem tmp = items[j];
                    items[j] = items[j - 1];
                    items[j - 1] = tmp;
                    wasSwap = true;
                }
            }
            if (!wasSwap)
                break;
        }
        return items;
    }

    @Override
    public int costTotal() {
        if (tail == null) {
            if (head.value != null)
                return head.value.getCost();
            return 0;
        }
        ListNode currNode = tail;
        int sum = 0;
        while (currNode != null) {
            sum += currNode.value.getCost();
            currNode = currNode.prev;
        }
        return sum;
    }

    @Override
    public Customer getCustomer() {
        return customer;
    }

    @Override
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public Object[] getBriefInfo() {
        return new Object[] {customer.getAddress().toString(), customer.getAge(), itemsQuantity(), costTotal()};
    }
}
