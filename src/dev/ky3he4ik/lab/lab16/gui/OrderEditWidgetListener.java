package dev.ky3he4ik.lab.lab16.gui;

import dev.ky3he4ik.lab.lab16.Order;

public interface OrderEditWidgetListener {
    void finishedNew(Order order);

    void finishedEdit(Order order, int row);
}
