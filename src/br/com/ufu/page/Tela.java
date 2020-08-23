package br.com.ufu.page;

import javax.swing.*;
import java.lang.reflect.Field;
import java.util.*;
import java.util.List;

public class Tela {

    private String name;
    private Class object;
    private HashMap<String, JTextField> attributtes = new HashMap<>();
    private int attr = 0;
    public JButton submit;
    public JFrame frame;

    public Tela(String name, Class object) {
        this.name = name;
        this.object = object;
        start();
    }

    public int getAttr() {
        return attr;
    }

    public HashMap<String, JTextField> getAttributtes() {
        return attributtes;
    }

    public void start() {
        frame = new JFrame(name);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int heighSize = 50 * (this.object.getSuperclass().getDeclaredFields().length + this.object.getDeclaredFields().length);

        frame.setBounds(100, 100, 500, 100 + heighSize);
        frame.getContentPane().setLayout(null);

        for (Field field : object.getDeclaredFields()) {
            this.setAttributes(field, attr);
            attr += 1;
        }
        for (Field field : object.getSuperclass().getDeclaredFields()) {
            this.setAttributes(field, attr);
            attr += 1;
        }

        submit = new JButton("Incluir");
        submit.setBounds(65, 50 + (30 * attr), 89, 28);
        frame.getContentPane().add(submit);
    }



    private void setAttributes(Field field, int index) {
        JLabel label = new JLabel(field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1).toLowerCase());
        label.setBounds(65, 31 + (30 * index), 100, 14);
        frame.getContentPane().add(label);

        JTextField textField = new JTextField();
        textField.setBounds(128, 31 + (30 * index), 180, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        attributtes.put(field.getName(), textField);
    }
}
