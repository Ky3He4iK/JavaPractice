package dev.ky3he4ik.lab.lab16.gui;

import dev.ky3he4ik.lab.lab16.*;

import javax.swing.*;
import java.awt.*;

public class OrderEditWidget extends JPanel {
    private OrdersManager ordersManager;
    private OrderEditWidgetListener listener;
    private boolean inBar;
    private int tableNumber = -1;
    private Customer customer;
    private Order order;
    //todo: customer changing

    private JButton changeCustomerBtn;
    private JSpinner age;
    private JLabel customerInfo;
    private JSpinner[] drinks;
    private JLabel orderInfo;
    private JButton applyBtn;


    OrderEditWidget(OrdersManager ordersManager, OrderEditWidgetListener listener, boolean inBar) {
        this.ordersManager = ordersManager;
        this.listener = listener;

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

        constraints.gridx = 1;
        age = new JSpinner(new SpinnerNumberModel(20, 8, 99, 1));
        age.addChangeListener(changeEvent -> {
            // TODO
        });
        add(age, constraints);

        if (!inBar) {
            constraints.gridy++;
            constraints.gridx = 0;
            customerInfo = new JLabel();
            add(customerInfo, constraints);

            constraints.gridx = 1;
            changeCustomerBtn = new JButton("change");
            changeCustomerBtn.addActionListener(actionEvent -> {
                //todo: change customer
            });
            add(changeCustomerBtn, constraints);
        } else
            changeCustomerBtn = new JButton();

        constraints.gridy++;
        constraints.gridx = 0;
        add(new JLabel(toMultilineStr(" ")), constraints);

        DrinkTypeEnum[] drinksEnum = DrinkTypeEnum.values();
        drinks = new JSpinner[drinksEnum.length];
        for (int i = 0; i < drinksEnum.length; i++) {
            constraints.gridy++;
            constraints.gridx = 0;
            Drink drink = drinksEnum[i].getValue();
            label = new JLabel(drink.getName());
            label.setToolTipText(toMultilineStr(drink.getDescription() + "\nAlcohol: " +
                    (drink.getAlcoholVol() * 100) + "%\nPrice: " + drink.getCost()));
            add(label, constraints);

            constraints.gridx = 1;
            drinks[i] = new JSpinner(new SpinnerNumberModel(0, 0, 20, 1));
            drinks[i].setToolTipText(label.getToolTipText());
            drinks[i].addChangeListener(changeEvent -> {
                //todo
            });
            add(drinks[i], constraints);
        }

        constraints.gridy += 1;
        constraints.gridx = 0;
        orderInfo = new JLabel();
        add(orderInfo, constraints);

        constraints.gridx = 1;
        applyBtn = new JButton("Apply");
        applyBtn.addActionListener(actionEvent -> {
            //todo
        });
        add(applyBtn, constraints);

        fill();
        setEnabled(false);
    }

    void load(Order order, int row) {
        //todo
    }

    void newOrder(int tableNumber) {
        this.tableNumber = tableNumber;
//        load(ordersManager.)
        setEnabled(true);
        //todo
    }

    void clear() {
        setEnabled(false);
        age.setValue(20);
        for (JSpinner drink : drinks)
            drink.setValue(0);
        order = null;
        setOrderInfoText();
        //todo
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

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        age.setEnabled(enabled);
        changeCustomerBtn.setEnabled(enabled);
        applyBtn.setEnabled(enabled);
        for (JSpinner drink: drinks)
            drink.setEnabled(enabled);
    }

    private static String toMultilineStr(String text) {
        return "<html>" + text.replace("\n", "<br>");
    }
}
