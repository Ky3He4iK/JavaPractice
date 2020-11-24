package dev.ky3he4ik.pr.pr12;


import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.AccessDeniedException;

public class Redactor extends JFrame {
    private ICreateDocument createDocument;
    private IDocument document;
    private JTextArea textArea;
    private JFileChooser fileChooser;

    public Redactor(ICreateDocument concreteCreateDocument) {
        createDocument = concreteCreateDocument;
        fileChooser = new JFileChooser(".");

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
            int resultCode = fileChooser.showOpenDialog(this);
            if (resultCode == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                IDocument tDocument = createDocument.CreateOpen(file);
                if (tDocument == null)
                    JOptionPane.showMessageDialog(null, "Can't open this file!");
                else {
                    document = tDocument;
                    textArea.setEditable(true);
                    textArea.setText(document.getData());
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
            int resultCode = fileChooser.showSaveDialog(this);
            if (resultCode == JFileChooser.APPROVE_OPTION) {
                document.setData(textArea.getText());
                File file = fileChooser.getSelectedFile();
                try {
                    document.save(file);
                } catch (AccessDeniedException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Can't save to " + file.getPath() + ": not enough rights");
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Can't save to " + file.getPath());
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
