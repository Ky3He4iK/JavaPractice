package dev.ky3he4ik.lab.lab16.gui;

import dev.ky3he4ik.lab.lab16.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.WindowEvent;

public class Main extends JFrame implements OrderEditWidgetListener {
    private final boolean inBar;
    private final OrdersManager ordersManager;

    private final JTable table;
    private final MyTableModel tableModel;
    private final OrderEditWidget orderEditWidget;

    private Main(boolean inBar) {
        this.inBar = inBar;
        if (inBar)
            ordersManager = new TableOrdersManager();
        else
            ordersManager = new InternetOrdersManager();

        GridBagLayout layout = new GridBagLayout();
        setLayout(layout);
        GridBagConstraints constraints = new GridBagConstraints();

        String[] columnNames = {"Address", "Age", "Drinks count", "Cost"};
        if (inBar)
            columnNames[0] = "Table";

        tableModel = new MyTableModel(columnNames, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        table.setCellSelectionEnabled(false);
        table.setColumnSelectionAllowed(false);
        table.setRowSelectionAllowed(true);
        table.setDragEnabled(false);

        scrollPane.setMinimumSize(new Dimension(640, 500));
        add(scrollPane, constraints);

        constraints.gridx = 1;
        orderEditWidget = new OrderEditWidget(ordersManager, this, inBar);
        orderEditWidget.setEnabled(false);
        scrollPane = new JScrollPane(orderEditWidget);
        scrollPane.setMinimumSize(new Dimension(640, 500));
        orderEditWidget.setMinimumSize(scrollPane.getMinimumSize());
        add(scrollPane, constraints);

        constraints.gridy = 1;
        constraints.gridx = 0;
        JButton button = new JButton("Add order");
        button.addActionListener(actionEvent -> {
            int tableNum = -1;
            if (inBar) {
                int[] tables = ((TableOrdersManager) ordersManager).freeTableNumbers();
                if (tables.length == 0) {
                    JOptionPane.showMessageDialog(this, "All tables are busy now!");
                    return;
                }
                Object[] tablesObj = new Object[tables.length];
                for (int i = 0; i < tables.length; i++)
                    tablesObj[i] = tables[i];
                Object res = JOptionPane.showInputDialog(this, "Select table",
                        "Welcome to Va-11 Hall-a", JOptionPane.QUESTION_MESSAGE, null, tablesObj, tables[0]);
                if (res == null)
                    return;
                tableNum = (int) res;
            }
            orderEditWidget.newOrder(tableNum);
        });
        add(button, constraints);
        constraints.gridx = 1;
        button = new JButton("Edit order");
        button.addActionListener(actionEvent -> {
            Order order = getSelectedOrder();
            if (order == null) {
                orderEditWidget.clear();
            } else {
                orderEditWidget.load(order, getSelectedOrderRow());
                orderEditWidget.setEnabled(true);
            }
        });
        add(button, constraints);

        constraints.gridy = 2;
        constraints.gridx = 0;
        button = new JButton("Info about order");
        button.addActionListener(actionEvent -> {
            Order order = getSelectedOrder();
            if (order == null) {
                orderEditWidget.clear();
            } else {
                orderEditWidget.load(order, getSelectedOrderRow());
                orderEditWidget.setEnabled(false);
            }
        });
        add(button, constraints);
        constraints.gridx = 1;
        button = new JButton("Delete order");
        button.addActionListener(actionEvent -> {
            int orderRow = getSelectedOrderRow();
            orderEditWidget.clear();
            if (orderRow != -1) {
                Object val = tableModel.getValueAt(orderRow, 0);
                tableModel.removeRow(orderRow);
                if (inBar)
                    ((TableOrdersManager) ordersManager).remove((int) val);
                else
                    ((InternetOrdersManager) ordersManager).remove(Address.fromString((String) val));
                JOptionPane.showMessageDialog(this, "Deleted");
            }
        });
        add(button, constraints);

        constraints.gridy = 3;
        constraints.gridx = 0;
        button = new JButton("Get order");
        button.addActionListener(actionEvent -> {
            orderEditWidget.setEnabled(false);
            int orderRow = getSelectedOrderRow();
            if (orderRow != -1) {
                Object val = tableModel.getValueAt(orderRow, 0);
                tableModel.removeRow(orderRow);
                if (inBar)
                    ((TableOrdersManager) ordersManager).remove((int) val);
                else
                    ((InternetOrdersManager) ordersManager).remove(Address.fromString((String) val));
                JOptionPane.showMessageDialog(this, "Enjoy your drinks!");
            }
        });
        add(button, constraints);
        constraints.gridx = 1;
        button = new JButton("Exit");
        button.addActionListener(actionEvent -> dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING)));
        add(button, constraints);

        setSize(1280, 720);
        setLocation(320, 180);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Va-11 Hall-a cyberpunk bar");
    }

    private int getSelectedOrderRow() {
        if (table.getSelectedRowCount() == 1)
            return table.getSelectedRow();
        else
            JOptionPane.showMessageDialog(this, "No order selected!");
        return -1;
    }

    private Order getSelectedOrder() {
        int orderRow = getSelectedOrderRow();
        if (orderRow == -1)
            return null;
        Object location = tableModel.getDataVector().get(orderRow).get(0);
        if (inBar)
            return ((TableOrdersManager) ordersManager).getOrder((int) location);
        else
            return ((InternetOrdersManager) ordersManager).order(Address.fromString((String) location));
    }

    @Override
    public void finished(Order order, int row) {
        if (row == -1)
            tableModel.addRow(order.getBriefInfo());
        else {
            Object[] orderInfo = order.getBriefInfo();
            for (int col = 0; col < tableModel.getColumnCount(); col++)
                tableModel.setValueAt(orderInfo[col], row, col);
        }
    }

    public static void main(String[] args) {
        String ans = (String) JOptionPane.showInputDialog(null, "Where would you drink?", "Choose a delivery method",
                JOptionPane.QUESTION_MESSAGE, null, new String[]{"In bar", "At house"}, "In bar");
        if (ans != null)
            switch (ans) {
                case "In bar":
                    new Main(true);
                    break;
                case "At house":
                    new Main(false);
            }
    }
}
