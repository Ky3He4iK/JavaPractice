package dev.ky3he4ik.lab.lab16;

import java.util.HashMap;

public class TableOrder implements Order {
    private int size = 0;
    private MenuItem[] items = new MenuItem[1];
    private Customer customer;
    private int table;

    private void shrink(int nsize) {
        if (nsize * 2 <= items.length) {
            MenuItem[] new_items = new MenuItem[nsize];
            for (int i = 0, j = 0; i < size; i++)
                if (items[i] != null)
                    new_items[j++] = items[i];
            items = new_items;
        } else {
            for (int i = 0, j = 0; i < size; i++)
                if (items[i] != null)
                    items[j++] = items[i];
        }
        size = nsize;
    }

    @Override
    public boolean add(MenuItem item) {
        if (size == items.length) {
            MenuItem[] new_items = new MenuItem[(size == 0) ? 1 : (size * 2)];
            System.arraycopy(items, 0, new_items, 0, size);
            items = new_items;
        }
        items[size++] = item;
        return true;
    }

    @Override
    public String[] itemsNames() {
        MenuItem[] items = getItems();
        HashMap<String, Boolean> orders = new HashMap<>();
        for (int i = 0; i < size; i++)
            if (!orders.containsKey(items[i].getName()))
                orders.put(items[i].getName(), true);

        return (String[]) orders.keySet().toArray();
    }

    @Override
    public int itemsQuantity() {
        return size;
    }

    @Override
    public int itemQuantity(String itemName) {
        int cnt = 0;
        for (int i = 0; i < size; i++)
            if (items[i].getName().equals(itemName))
                cnt++;
        return cnt;
    }

    @Override
    public int itemQuantity(MenuItem item) {
        int cnt = 0;
        for (int i = 0; i < size; i++)
            if (item.equals(items[i]))
                cnt++;
        return cnt;
    }

    @Override
    public MenuItem[] getItems() {
        MenuItem[] new_items = new MenuItem[size];
        System.arraycopy(items, 0, new_items, 0, size);
        return new_items;
    }

    @Override
    public boolean remove(String itemName) {
        for (int i = size - 1; i >= 0; i--) {
            if (items[i].getName().equals(itemName)) {
                items[i] = null;
                shrink(size - 1);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(MenuItem item) {
        for (int i = size - 1; i >= 0; i--) {
            if (items[i].equals(item)) {
                items[i] = null;
                shrink(size - 1);
                return true;
            }
        }
        return false;
    }

    @Override
    public int removeAll(String itemName) {
        int nsize = size;
        for (int i = size - 1; i >= 0; i--) {
            if (items[i] != null && items[i].getName().equals(itemName)) {
                items[i] = null;
                nsize--;
            }
        }
        if (nsize == size)
            return 0;
        int loss = size - nsize;
        shrink(nsize);
        return loss;
    }

    @Override
    public int removeAll(MenuItem item) {
        int nsize = size;
        for (int i = size - 1; i >= 0; i--) {
            if (items[i] != null && items[i].equals(item)) {
                items[i] = null;
                nsize--;
            }
        }
        if (nsize == size)
            return 0;
        int loss = size - nsize;
        shrink(nsize);
        return loss;
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
        int sum = 0;
        for (int i = 0; i < size; i++)
            sum += items[i].getCost();
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
        return new Object[] {table, customer.getAge(), itemsQuantity(), costTotal()};
    }

    public int getTable() {
        return table;
    }

    public void setTable(int table) {
        this.table = table;
    }
}
