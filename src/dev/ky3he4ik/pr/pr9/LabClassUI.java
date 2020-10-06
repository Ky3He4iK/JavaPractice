package dev.ky3he4ik.pr.pr9;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;

public class LabClassUI extends JFrame {
    private final LabTableModel labTableModel;
    private final LabClass labClass;

    public LabClassUI (LabClass labClass) {
        super("Lab class");
        this.labClass = labClass;

        setLayout(new BorderLayout());
        setSize(500, 500);
        setMinimumSize(new Dimension(300, 300));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        labTableModel = new LabTableModel();

        JTable table = new JTable(labTableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        JPanel panel = new JPanel(new GridLayout(2, 2));
        add(panel, BorderLayout.SOUTH);

        JButton sortButton = new JButton("Sort table");
        sortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labTableModel.sortByGPA();
            }
        });
        panel.add(sortButton);

        JButton shuffleButton = new JButton("Shuffle table");
        shuffleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labTableModel.shuffle();
            }
        });
        panel.add(shuffleButton);

        JTextField textField = new JTextField();
        textField.setHorizontalAlignment(JTextField.CENTER);
        panel.add(textField);

        JButton findButton = new JButton("Find student by name");
        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String name = textField.getText();
                    if (name == null || name.isEmpty() || name.isBlank()) {
                        throw new EmptyStringException();
                    }
                    Student student = LabClassDriver.findByName(name, labClass.getStudents());
                    if (student == null) {
                        throw new StudentNotFoundException(name);
                    } else {
                        JOptionPane.showMessageDialog(LabClassUI.this,
                                "Statistics of student:\n" + student);
                    }
                } catch (EmptyStringException | StudentNotFoundException exception) {
                    JOptionPane.showMessageDialog(LabClassUI.this,
                            exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(findButton);

        setVisible(true);
    }

    public void addStudentToTable(Student student) {
        labTableModel.addRow(student);
    }

    public void removeStudentFromTable(int studentIndex) {
        labTableModel.removeRow(studentIndex);
    }

    private class LabTableModel extends AbstractTableModel {
        private final String[] columnNames = {
                "Name", "ID number", "Final marks"
        };

        @Override
        public int getRowCount() {
            return labClass.getStudents().size();
        }

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public String getColumnName(int columnIndex) {
            return columnNames[columnIndex];
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return String.class;
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            final Student student = labClass.getStudents().get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return student.getName();
                case 1:
                    return student.getIDNumber();
                case 2:
                    return Arrays.toString(student.getFinalMarks());
                default:
                    return "";
            }
        }

        public void removeRow(int rowIndex) {
            labClass.getStudents().remove(rowIndex);
            fireTableRowsDeleted(rowIndex, rowIndex);
        }

        public void addRow(Student student) {
            labClass.getStudents().add(student);
            final int last = labClass.getStudents().size() - 1;
            fireTableRowsInserted(last, last);
        }

        public void sortByGPA() {
            LabClassDriver.sort(labClass.getStudents());
            fireTableRowsUpdated(0, labClass.getStudents().size() - 1);
        }

        public void shuffle() {
            Collections.shuffle(labClass.getStudents());
            fireTableRowsUpdated(0, labClass.getStudents().size() - 1);
        }
    }
}
