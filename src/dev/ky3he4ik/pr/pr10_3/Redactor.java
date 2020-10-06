package dev.ky3he4ik.pr.pr10_3;


import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class Redactor extends JFrame {
    private ICreateDocument createDocument;
    private IDocument document;
    private String filename;
    private JTextArea textArea;

    public Redactor(ICreateDocument concreteCreateDocument) {
        createDocument = concreteCreateDocument;

        setSize(1280, 720);
        setLocation(320, 180);

        setLayout(new CardLayout());

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setEnabled(true);
        add(textArea);

        Menu menu = new Menu("File");

        MenuItem menuItem = new MenuItem("New");
        menuItem.addActionListener(e -> {
            document = createDocument.CreateNew();
            textArea.setEditable(true);
            textArea.setText("");
        });
        menu.add(menuItem);

        menuItem = new MenuItem("Open");
        menuItem.addActionListener(e -> {
            filename = JOptionPane.showInputDialog(null, "Input filename");
            if (filename != null) {
                document = createDocument.CreateOpen(filename);
                if (document == null)
                    JOptionPane.showMessageDialog(null, "Can't open this file!");
                else {
                    textArea.setEditable(true);
                    textArea.setText(((TextDocument) document).getData());
                }
            }
        });
        menu.add(menuItem);

        menuItem = new MenuItem("Save");
        menuItem.addActionListener(e -> {
            if (document == null) {
                JOptionPane.showMessageDialog(null, "Nothing to save!");
                return;
            }
            filename = JOptionPane.showInputDialog(null, "Input filename to save");
            if (filename != null) {
                try {
                    ((TextDocument) document).setData(textArea.getText());
                    document.save(filename);
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Can't save to " + filename);
                }
            }
        });
        menu.add(menuItem);

        menuItem = new MenuItem("Exit");
        menuItem.addActionListener(e -> dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING)));
        menu.add(menuItem);

        MenuBar menuBar = new MenuBar();
        menuBar.add(menu);

        setMenuBar(menuBar);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Redactor(new TextCreateDocument());
    }
}

