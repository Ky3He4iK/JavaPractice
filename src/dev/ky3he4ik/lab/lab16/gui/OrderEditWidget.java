package dev.ky3he4ik.lab.lab16.gui;

import dev.ky3he4ik.lab.lab16.*;
import dev.ky3he4ik.lab.lab16.MenuItem;

import javax.swing.*;
import java.awt.*;

public class OrderEditWidget extends JPanel {
    private boolean inBar;
    private int tableNumber = -1;
    private int row = -1;
    private Customer customer;
    private Order order;
    private int[] drinksCnt;
    private Drink[] drinks;

    private JButton changeCustomerBtn;
    private JSpinner age;
    private JLabel customerInfo;
    private JSpinner[] drinksSpinner;
    private JLabel orderInfo;
    private JButton applyBtn;


    OrderEditWidget(OrdersManager ordersManager, OrderEditWidgetListener callback, boolean inBar) {
        this.inBar = inBar;
        if (inBar)
            customer = Customer.MATURE_UNKNOWN_CUSTOMER;
        else
            customer = new Customer("name", "surname", 19, Address.fromString("A  1  A  A  1"));

        GridBagLayout layout = new GridBagLayout();
        setLayout(layout);
        GridBagConstraints constraints = new GridBagConstraints();

        JLabel label = new JLabel("Age: ");
        add(label, constraints);

        constraints.gridy = 0;
        constraints.gridx = 1;
        age = new JSpinner(new SpinnerNumberModel(20, 8, 99, 1));
        age.addChangeListener(changeEvent -> {
            if ((int) age.getValue() < 18 && customer.getAge() >= 18) {
                for (int i = 0; i < drinks.length; i++) {
                    if (drinks[i].isAlcoholicDrink()) {
                        drinksSpinner[i].setEnabled(false);
                        drinksSpinner[i].setValue(0);
                        drinksCnt[i] = 0;
                    }
                }
            } else if ((int) age.getValue() >= 18 && customer.getAge() < 18) {
                for (int i = 0; i < drinks.length; i++)
                    if (drinks[i].isAlcoholicDrink())
                        drinksSpinner[i].setEnabled(true);
            }
            customer.setAge((int) age.getValue());
        });
        add(age, constraints);

        if (!inBar) {
            constraints.gridy++;
            constraints.gridx = 0;
            customerInfo = new JLabel();
            add(customerInfo, constraints);

            constraints.gridx = 1;
            changeCustomerBtn = new JButton("change");
            changeCustomerBtn.addActionListener(actionEvent -> registerCustomer());
            add(changeCustomerBtn, constraints);
        } else {
            changeCustomerBtn = new JButton();
            customerInfo = new JLabel();
        }

        constraints.gridy++;
        constraints.gridx = 0;
        add(new JLabel(toMultilineStr(" ")), constraints);

        DrinkTypeEnum[] drinksEnum = DrinkTypeEnum.values();
        drinksSpinner = new JSpinner[drinksEnum.length];
        drinksCnt = new int[drinksEnum.length];
        drinks = new Drink[drinksEnum.length];
        for (int i = 0; i < drinksEnum.length; i++) {
            drinksCnt[i] = 0;
            drinks[i] = drinksEnum[i].getValue();
            constraints.gridy++;
            constraints.gridx = 0;
            label = new JLabel(drinks[i].getName());
            label.setToolTipText(toMultilineStr(drinks[i].getDescription() + "\nAlcohol: " +
                    (drinks[i].getAlcoholVol() * 100) + "%\nPrice: " + drinks[i].getCost()));
            add(label, constraints);

            constraints.gridx = 1;
            drinksSpinner[i] = new JSpinner(new SpinnerNumberModel(0, 0, 20, 1));
            drinksSpinner[i].setToolTipText(label.getToolTipText());
            int finalI = i;
            drinksSpinner[i].addChangeListener(changeEvent -> {
                int diff = (int) drinksSpinner[finalI].getValue() - drinksCnt[finalI];
                while (diff > 0) {
                    order.add(drinks[finalI]);
                    diff--;
                }
                while (diff < 0) {
                    order.remove(drinks[finalI]);
                    diff++;
                }
                drinksCnt[finalI] = (int) drinksSpinner[finalI].getValue();
                setOrderInfoText();
            });
            add(drinksSpinner[i], constraints);
        }

        constraints.gridy += 1;
        constraints.gridx = 0;
        orderInfo = new JLabel();
        add(orderInfo, constraints);

        constraints.gridx = 1;
        applyBtn = new JButton("Apply");
        applyBtn.addActionListener(actionEvent -> {
            if (order.itemsQuantity() == 0) {
                JOptionPane.showMessageDialog(this, "No drinks selected!");
                return;
            }
            if (inBar) {
                if (row == -1) {
                    try {
                        ((TableOrdersManager) ordersManager).add((TableOrder) order, tableNumber);
                    } catch (OrderAlreadyAddedException e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(this, "Error: order for this table already exists!");
                        return;
                    }
                }
            } else {
                if (row == -1) {
                    try {
                        ((InternetOrdersManager) ordersManager).add(order);
                    } catch (OrderAlreadyAddedException e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(this, "Error: order for this address  already exists!");
                        return;
                    }
                }
            }
            callback.finished(order, row);
            clear();
            setEnabled(false);
        });
        add(applyBtn, constraints);

        fill();
        setEnabled(false);
    }

    void load(Order order, int row) {
        this.row = row;
        this.order = order;
        for (int i = 0; i < drinksCnt.length; i++)
            drinksCnt[i] = 0;
        for (MenuItem item : order.getItems()) {
            for (int i = 0; i < drinksCnt.length; i++)
                if (item.getName().equals(drinks[i].getName())) {
                    drinksCnt[i] += 1;
                    break;
                }
        }
        for (int i = 0; i < drinksCnt.length; i++)
            drinksSpinner[i].setValue(drinksCnt[i]);
        customer = order.getCustomer();
        setOrderInfoText();
        customerInfo.setText(toMultilineStr(customer.toString()));
    }

    void newOrder(int tableNumber) {
        clear();
        if (inBar) {
            order = new TableOrder();
            int ageI = getAge();
            if (ageI == -1)
                return;
            customer.setAge(ageI);
            age.setValue(ageI);
            order.setCustomer(customer);
        } else {
            order = new InternetOrder();
            if (!registerCustomer()) {
                setEnabled(false);
                return;
            }
        }
        this.tableNumber = tableNumber;
        setEnabled(true);
        setOrderInfoText();
        if ((int)age.getValue() < 18) {
            for (int i = 0; i < drinks.length; i++) {
                if (drinks[i].isAlcoholicDrink()) {
                    drinksSpinner[i].setEnabled(false);
                    drinksSpinner[i].setValue(0);
                    drinksCnt[i] = 0;
                }
            }
        }
        customerInfo.setText(toMultilineStr(customer.toString()));
    }

    void clear() {
        setEnabled(false);
        customer = Customer.MATURE_UNKNOWN_CUSTOMER;
        age.setValue(customer.getAge());
        customerInfo.setText(toMultilineStr(customer.toString()));
        for (int i = 0; i < drinksSpinner.length; i++) {
            drinksCnt[i] = 0;
            drinksSpinner[i].setValue(0);
        }
        order = null;
        setOrderInfoText();

        row = -1;
        tableNumber = -1;
    }

    private void fill() {
        if (!inBar) {
            if (customer == null)
                customerInfo.setText("No customer account selected!");
            else
                customerInfo.setText(toMultilineStr(customer.toString()));
        }
        age.setValue(customer.getAge());
        setOrderInfoText();
    }

    private void setOrderInfoText() {
        if (order == null)
            orderInfo.setText(toMultilineStr("Total items: 0\nTotal cost: 0 "));
        else
            orderInfo.setText(toMultilineStr("Total items:" + order.itemsQuantity() + "\nTotal cost:" + order.costTotal()));
    }

    private boolean registerCustomer() {
        String name = JOptionPane.showInputDialog(
                this,
                "Enter your name and surname separated by space:",
                "Registration: Name",
                JOptionPane.PLAIN_MESSAGE);
        if (name == null || name.isEmpty())
            return false;
        String[] n = name.split(" ");
        if (n.length != 2) {
            JOptionPane.showMessageDialog(this, "Invalid name!");
            return false;
        }
        int ageI = getAge();
        if (ageI == -1)
            return false;
        String s = JOptionPane.showInputDialog(
                this,
                "Enter your address in this: format\n"
                        + "City name, zip_code, street name, building_letter, apartment_number",
                "Registration: Delivery address",
                JOptionPane.PLAIN_MESSAGE);
        if (s == null || s.isEmpty())
            return false;
        String[] a = s.split(", ");
        if (a.length == 5) {
            try {
                Address address = new Address(a[0], Integer.parseInt(a[1]), a[2], a[3].charAt(0), Integer.parseInt(a[4]));
                customer = new Customer(n[0], n[1], ageI, address);
                order.setCustomer(customer);
                customerInfo.setText(toMultilineStr(customer.toString()));
                age.setValue(customer.getAge());
                return true;
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            }
        }
        JOptionPane.showMessageDialog(this, "Invalid address!");
        return false;
    }

    private int getAge() {
        String ageS = JOptionPane.showInputDialog(
                this,
                "Enter your age",
                "Registration: Age",
                JOptionPane.PLAIN_MESSAGE);
        if (ageS == null || ageS.isEmpty())
            return -1;
        int ageI = -1;
        try {
            ageI = Integer.parseInt(ageS);
        } catch (NumberFormatException e) {
        }
        if (ageI < 8) {
            JOptionPane.showMessageDialog(this, "Invalid age!");
            return -1;
        }
        return ageI;
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        age.setEnabled(enabled);
        changeCustomerBtn.setEnabled(enabled);
        applyBtn.setEnabled(enabled);
        for (JSpinner drink : drinksSpinner)
            drink.setEnabled(enabled);
        setOrderInfoText();
    }

    private static String toMultilineStr(String text) {
        return "<html>" + text.replace("\n", "<br>");
    }
}
