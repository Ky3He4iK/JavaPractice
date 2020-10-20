package dev.ky3he4ik.lab.lab16.gui;

import javax.swing.table.DefaultTableModel;

public class MyTableModel extends DefaultTableModel {
    public MyTableModel(Object[] columnNames, int rowCount) {
        super(columnNames, rowCount);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}
