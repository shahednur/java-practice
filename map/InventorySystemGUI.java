package map;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class InventorySystemGUI {
    private static Map<String, Integer> inventory = new LinkedHashMap<>();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Inventory System");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JTextField productField = new JTextField(15);
        JTextField quantityField = new JTextField(5);
        JTextArea outputArea = new JTextArea(10, 40);
        outputArea.setEditable(false);

        JButton addButton = new JButton("Add/Update");
        JButton removeButton = new JButton("Remove");
        JButton viewButton = new JButton("View All");
        JButton clearButton = new JButton("Clear Inventory");

        // Add/Update
        addButton.addActionListener(e -> {
            String product = productField.getText();

            try {
                int qty = Integer.parseInt(quantityField.getText());
                inventory.put(product, qty);
                outputArea.setText(product + " added/updated with quantity: " + qty);
            } catch (NumberFormatException ex) {
                outputArea.setText("Invalid quantity. Enter a number.");
            }
        });

        // Remove
        removeButton.addActionListener(e -> {
            String product = productField.getText();
            if (inventory.containsKey(product)) {
                inventory.remove(product);
                outputArea.setText(product + " removed.");
            } else {
                outputArea.setText("Product not found.");
            }
        });

        // View All
        viewButton.addActionListener(e -> {
            StringBuilder sb = new StringBuilder("Inventory:\n");
            for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
                sb.append(entry.getKey()).append(" -> ").append(entry.getValue()).append("\n");
            }

            outputArea.setText(sb.toString());
        });

        // Clear
        clearButton.addActionListener(e -> {
            inventory.clear();
            outputArea.setText("Inventory cleared.");
        });

        // Add to frame
        frame.add(new JLabel("Product Name: "));
        frame.add(productField);
        frame.add(new JLabel("Quantity:"));
        frame.add(quantityField);
        frame.add(addButton);
        frame.add(removeButton);
        frame.add(viewButton);
        frame.add(viewButton);
        frame.add(clearButton);
        frame.add(new JScrollPane(outputArea));

        frame.setVisible(true);
    }
}
