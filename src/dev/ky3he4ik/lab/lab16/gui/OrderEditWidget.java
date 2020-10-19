package dev.ky3he4ik.lab.lab16.gui;

import dev.ky3he4ik.lab.lab16.Order;
import dev.ky3he4ik.lab.lab16.OrdersManager;

import javax.swing.*;

public class OrderEditWidget extends JPanel {
    private OrdersManager ordersManager;
    private OrderEditWidgetListener listener;

    OrderEditWidget(OrdersManager ordersManager, OrderEditWidgetListener listener) {
        this.ordersManager = ordersManager;
        this.listener = listener;
//        super();
        //todo
    }

    void setEditable(boolean editable) {
        //todo
    }

    void load(Order order, int row) {
        //todo
    }

    void newOrder() {
//        load(ordersManager.)
        setEditable(true);
        //todo
    }

    void clear() {
        setEditable(false);
        //todo
    }
}
