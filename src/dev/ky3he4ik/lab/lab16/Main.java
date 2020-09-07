package dev.ky3he4ik.lab.lab16;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    private boolean wasInterrupt = false;
    private Customer account;
    private InternetOrdersManager internetOrdersManager = new InternetOrdersManager();
    private TableOrdersManager tableOrdersManager = new TableOrdersManager();

    private void doWork() {
        while (true) {
            try {
                System.out.println("Welcome to Va-11 Hall-a. What do you want?\n"
                        + "1) Add a new order by internet\n"
                        + "2) Edit an order by internet\n"
                        + "3) Get information about orders by internet\n"
                        + "4) Get an order by internet\n"
                        + "5) Add a new order in bar\n"
                        + "6) Edit an order in bar\n"
                        + "7) Get information about orders in bar\n"
                        + "8) Get an order in bar\n"
                        + "9) Use a new customer account\n"
                        + "0) Exit"
                );
                int action = getNumber(10, true);
                switch (action) {
                    case 0:
                        System.out.println("Goodbye!");
                        return;
                    case 1:
                        addOrderInternet();
                        break;
                    case 2:
                        editOrderInternet();
                        break;
                    case 3:
                        ordersInfoInternet();
                        break;
                    case 4:
                        getOrderInternet();
                        break;
                    case 5:
                        addOrderTable();
                        break;
                    case 6:
                        editOrderTable();
                        break;
                    case 7:
                        ordersInfoTable();
                        break;
                    case 9:
                        addCustomer();
                        break;
                    case 8:
                        getOrderTable();
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("I am afraid this program is quite unstable. Please try again later");
            }
        }
    }

    private void addOrderInternet() {
        if (account == null) {
            System.out.println("Please register first");
            return;
        }
        InternetOrder order = new InternetOrder();
        order.setCustomer(account);
        fillOrder(order);
        if (order.itemsQuantity() == 0)
            return;
        try {
            internetOrdersManager.add(order);
        } catch (OrderAlreadyAddedException e) {
            System.out.println("This address already has an order!");
            return;
        }
        System.out.println("We will deliver your order as soon as possible");
    }

    private void addOrderTable() {
        if (tableOrdersManager.freeTableNumber() == -1) {
            System.out.println("Sorry but we don't have any table available");
            return;
        }
        System.out.println("Please enter your age");
        int age = getNumber(200, false);
        TableOrder order = new TableOrder();
        order.setCustomer((age < 18) ? Customer.NOT_MATURE_UNKNOWN_CUSTOMER : Customer.MATURE_UNKNOWN_CUSTOMER);
        fillOrder(order);
        if (order.itemsQuantity() == 0)
            return;
        System.out.println("On which table will you wait?");
        int[] availableTables = tableOrdersManager.freeTableNumbers();
        int j = 0;
        for (int table : availableTables) {
            j++;
            System.out.println("" + j + ") " + table);
        }
        j = getNumber(availableTables.length + 1, false);
        try {
            tableOrdersManager.add(order, availableTables[j - 1]);
        } catch (OrderAlreadyAddedException e) {
            System.out.println("Somehow you table is not available anymore");
            return;
        }
        System.out.println("Please wait while we a preparing your order");
    }

    private void fillOrder(Order order) {
        while (true) {
            System.out.println("What do you want?");
            int j = 0;
            for (DrinkTypeEnum drinkType : DrinkTypeEnum.values()) {
                j++;
                if (order.getCustomer().getAge() >= 18 || !drinkType.getValue().isAlcoholicDrink())
                    System.out.println("" + j + ") " + drinkType.getValue().getName() + " - " + drinkType.getValue().getCost() + " - " + drinkType.getValue().getDescription());
            }
            if (order.itemsQuantity() == 0)
                System.out.println("0) Main menu");
            else
                System.out.println("0) Finish order");

            j = getNumber(DrinkTypeEnum.values().length + 1, true);
            if (j == 0)
                break;
            Drink drink = DrinkTypeEnum.values()[j - 1].getValue();
            if (drink.isAlcoholicDrink() && order.getCustomer().getAge() < 18)
                System.out.println("We do not sell alcohol to kids!");
            else {
                order.add(drink);
                System.out.println("Successfully added " + drink.getName());
            }
        }
    }

    private void editOrderInternet() {
        Order[] orders = internetOrdersManager.getOrders();
        int j = selectOrderInternet(orders);
        if (j == 0)
            return;
        Order order = orders[j - 1];
        while (true) {
            System.out.println("Order info:\nCustomer: " + order.getCustomer().toString() + "\n" + order.itemsQuantity() +
                    " items with total cost " + order.costTotal() + "\nItems:");
            for (MenuItem item : order.sortedItemsByCostDesc())
                System.out.println(item.getName() + ' ' + item.getCost() + ' ' + item.getCost() + '\n');
            System.out.println("1) Add item\n"
                    + "2) Remove items\n"
                    + "3) Remove order\n"
                    + "0) Main menu\n"
            );
            j = getNumber(4, true);
            switch (j) {
                case 0:
                    return;
                case 1:
                    fillOrder(order);
                    break;
                case 2:
                    String[] names = order.itemsNames();
                    System.out.println("What do you want to remove?");
                    for (int i = 1; i <= names.length; i++)
                        System.out.println("" + i + ") " + names[i - 1]);
                    System.out.println("0) Nothing");
                    j = getNumber(names.length + 1, true);
                    if (j == 0)
                        break;
                    int k = order.removeAll(names[j - 1]);
                    System.out.println("Successfully removed " + k + " occurrences of " + names[j - 1]);
                    break;
                case 3:
                    internetOrdersManager.remove(order.getCustomer().getAddress());
                    System.out.println("Ok");
                    return;
            }
        }
    }

    private void editOrderTable() {
        TableOrder[] orders = tableOrdersManager.getOrders();
        int j = selectOrderTable(orders);
        if (j == 0)
            return;
        TableOrder order = orders[j - 1];
        while (true) {
            System.out.println("Order №" + j + " info:\nTable: " + order.getTable() + "\n" + order.itemsQuantity() +
                    " items with total cost " + order.costTotal() + "\nItems:");
            for (MenuItem item : order.sortedItemsByCostDesc())
                System.out.println(item.getName() + ' ' + item.getCost() + ' ' + item.getCost() + '\n');
            System.out.println("1) Add item\n"
                    + "2) Remove items\n"
                    + "3) Remove order\n"
                    + "0) Main menu\n"
            );
            j = getNumber(4, true);
            switch (j) {
                case 0:
                    return;
                case 1:
                    fillOrder(order);
                    break;
                case 2:
                    String[] names = order.itemsNames();
                    System.out.println("What do you want to remove?");
                    for (int i = 1; i <= names.length; i++)
                        System.out.println("" + i + ") " + names[i - 1]);
                    System.out.println("0) Nothing");
                    j = getNumber(names.length + 1, true);
                    if (j == 0)
                        break;
                    int k = order.removeAll(names[j - 1]);
                    System.out.println("Successfully removed " + k + " occurrences of " + names[j - 1]);
                    break;
                case 3:
                    tableOrdersManager.remove(order.getTable());
                    System.out.println("Ok");
                    return;
            }
        }
    }

    private void ordersInfoInternet() {
        Order[] orders = internetOrdersManager.getOrders();
        while (true) {
            int j = selectOrderInternet(orders);
            if (j == 0)
                return;
            Order order = orders[j - 1];
            System.out.println("Order info:\nCustomer: " + order.getCustomer().toString() + "\n" + order.itemsQuantity() +
                    " items with total cost " + order.costTotal() + "\nItems:");
            for (MenuItem item : order.sortedItemsByCostDesc())
                System.out.println(item.getName() + ' ' + item.getCost() + ' ' + item.getCost() + '\n');
        }
    }

    private void ordersInfoTable() {
        TableOrder[] orders = tableOrdersManager.getOrders();
        while (true) {
            int j = selectOrderTable(orders);
            if (j == 0)
                return;
            TableOrder order = orders[j - 1];
            System.out.println("Order №" + j + " info:\nTable: " + order.getTable() + "\n" + order.itemsQuantity() +
                    " items with total cost " + order.costTotal() + "\nItems:");
            for (MenuItem item : order.sortedItemsByCostDesc())
                System.out.println(item.getName() + ' ' + item.getCost() + ' ' + item.getCost() + '\n');
        }
    }

    private void getOrderInternet() {
        Order[] orders = internetOrdersManager.getOrders();
        System.out.println("What is your order?");

        for (int i = 1; i <= orders.length; i++)
            System.out.println("" + i + ") Order for " + orders[i - 1].getCustomer() + ". $" + orders[i - 1].costTotal());
        System.out.println("0) Main menu");
        int j = getNumber(orders.length + 1, true);
        if (j == 0)
            return;
        Order order = internetOrdersManager.remove(orders[j - 1].getCustomer().getAddress());
        if (order == null) {
            System.out.println("Ooops looks like your order has lost somewhere");
            return;
        }
        System.out.println("Bone appetite! Your order with " + order.itemsQuantity() + " items that cost " + order.costTotal() + " delivered! You got: ");
        for (MenuItem item : order.getItems())
            System.out.println(item.getName() + ' ' + item.getCost() + ' ' + item.getCost() + '\n');
    }

    private void getOrderTable() {
        TableOrder[] orders = tableOrdersManager.getOrders();
        System.out.println("What is your order?");
        for (int i = 1; i <= orders.length; i++)
            System.out.println("" + i + ") Order for table №" + orders[i - 1].getTable() + ". $" + orders[i - 1].costTotal());
        System.out.println("0) Main menu");
        int j = getNumber(orders.length + 1, true);
        if (j == 0)
            return;
        TableOrder order = orders[j - 1];
        tableOrdersManager.remove(order.getTable());
        System.out.println("Bone appetite! Your order with " + order.itemsQuantity() + " items that cost " + order.costTotal() + " delivered! You got: ");
        for (MenuItem item : order.getItems())
            System.out.println(item.getName() + ' ' + item.getCost() + ' ' + item.getCost() + '\n');
    }

    private void addCustomer() {
        System.out.println("Please enter your first name");
        String name = getLine();
        System.out.println("Please enter your second name");
        String surName = getLine();
        System.out.println("Please enter your age");
        int age = getNumber(200, false);
        System.out.println("Please enter city you live");
        String city = getLine();
        System.out.println("Please enter zip code");
        int zipCode = getNumber(1000000, false);
        System.out.println("Please enter street name");
        String street = getLine();
        System.out.println("Please enter building letter (leave empty if no building letter)");
        char buildingLetter = getLine(true).charAt(0);
        System.out.println("Please enter apartment number");
        int apartment = getNumber(10000, true);
        account = new Customer(name, surName, age, new Address(city, zipCode, street, buildingLetter, apartment));
    }

    private int selectOrderInternet(Order[] orders) {
        System.out.println("There are " + orders.length + " orders waiting to be delivered.\nSummary cost is " + internetOrdersManager.ordersCostSummary());
        for (int i = 1; i <= orders.length; i++)
            System.out.println("" + i + ") Order №" + i + " for " + orders[i - 1].getCustomer());
        System.out.println("0) Main menu");
        return getNumber(orders.length + 1, true);
    }

    private int selectOrderTable(TableOrder[] orders) {
        System.out.println("There are " + orders.length + " orders waiting to be delivered.\nSummary cost is " + tableOrdersManager.ordersCostSummary());
        for (int i = 1; i <= orders.length; i++)
            System.out.println("" + i + ") Order №" + i + " at table №" + orders[i - 1].getTable());
        System.out.println("0) Main menu");
        return getNumber(orders.length + 1, true);
    }

    private int getNumber(int cap, boolean allowZero) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("> ");
                int res = scanner.nextInt();
                wasInterrupt = false;
                if ((res > 0 && res < cap) || (allowZero && res == 0))
                    return res;
            } catch (InputMismatchException e) {
                scanner.nextLine();
            } catch (NoSuchElementException e) {
                System.err.println("No input found!");
                System.exit(1);
            } catch (Exception e) {
                if (wasInterrupt)
                    System.exit(2);
                else
                    wasInterrupt = true;
                e.printStackTrace();
            }
        }
    }

    private String getLine() {
        return getLine(false);
    }

    private String getLine(boolean mayBeEmpty) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("> ");
                String res = scanner.nextLine();
                wasInterrupt = false;
                if (mayBeEmpty || !res.isEmpty())
                    return res;
            } catch (InputMismatchException e) {
                scanner.nextLine();
            } catch (NoSuchElementException e) {
                System.err.println("No input found!");
                System.exit(1);
            } catch (Exception e) {
                if (wasInterrupt)
                    System.exit(2);
                else
                    wasInterrupt = true;
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Main().doWork();
    }
}
