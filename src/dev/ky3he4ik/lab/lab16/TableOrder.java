package dev.ky3he4ik.lab.lab16;

public class TableOrder implements Order {
    private int size;
    private MenuItem[] items;
    private Customer customer;

    @Override
    public boolean add(MenuItem item) {
        return false;//todo
    }

    @Override
    public String[] itemsNames() {
        return new String[0];//todo
    }

    @Override
    public int itemsQuantity() {
        return size;
    }

    @Override
    public int itemQuantity(String itemName) {
        return 0;//todo
    }

    @Override
    public int itemQuantity(MenuItem item) {
        return 0;//todo
    }

    @Override
    public MenuItem[] getItems() {
        return new MenuItem[0];//todo
    }

    @Override
    public boolean remove(String itemName) {
        return false;//todo
    }

    @Override
    public boolean remove(MenuItem item) {
        return false;//todo
    }

    @Override
    public int removeAll(String itemName) {
        return 0;//todo
    }

    @Override
    public int removeAll(MenuItem item) {
        return 0;//todo
    }

    @Override
    public MenuItem[] sortedItemsByCostDesc() {
        return new MenuItem[0];//todo
    }

    @Override
    public int costTotal() {
        return 0;//todo
    }

    @Override
    public Customer getCustomer() {
        return customer;
    }

    @Override
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
