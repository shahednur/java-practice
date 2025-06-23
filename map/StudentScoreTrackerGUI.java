package map;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

public class StudentScoreTrackerGUI {
    private static Map<String, Integer> studentScores = new HashMap<>();

    public static void main(String[] args) {
        // Frame
        JFrame frame = new JFrame("Student Score Tracker");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Fields
        JTextField nameField = new JTextField(15);
        JTextField scoreField = new JTextField(5);
        JTextArea outputArea = new JTextArea(10, 40);
        outputArea.setEditable(false);

        // Buttons
        JButton addButton = new JButton("Add/Update");
        JButton searchButton = new JButton("Search");
        JButton removeButton = new JButton("Remove");
        JButton showAllButton = new JButton("Show All");
        JButton clearButton = new JButton("Clear All");

        // Add Student
        addButton.addActionListener(e -> {
            String name = nameField.getText();
            try {
                int score = Integer.parseInt(scoreField.getText());
                studentScores.put(name, score);
                outputArea.setText(name + " added/updated with score: " + score);
            } catch (NumberFormatException ex) {
                outputArea.setText("Invalid score. Enter a number");
            }
        });

        // Search
        searchButton.addActionListener(e -> {
            String name = nameField.getText();
            Integer score = studentScores.get(name);
            if (score != null) {
                outputArea.setText(name + "'s score: " + score);
            } else {
                outputArea.setText(name + " not found.");
            }
        });

        // Remove
        removeButton.addActionListener(e -> {
            String name = nameField.getText();
            if (studentScores.containsKey(name)) {
                studentScores.remove(name);
                outputArea.setText(name + " removed.");
            } else {
                outputArea.setText(name + " not found.");
            }
        });

        // Show All
        showAllButton.addActionListener(e -> {
            StringBuilder sb = new StringBuilder("All Students: \n");
            for (Map.Entry<String, Integer> entry : studentScores.entrySet()) {
                sb.append(entry.getKey()).append(" : ").append(entry.getValue()).append("\n");
            }

            outputArea.setText(sb.toString());
        });

        // Clear
        clearButton.addActionListener(e -> {
            studentScores.clear();
            outputArea.setText("All records cleared");
        });

        // Add to frame
        frame.add(new JLabel("Student Name:"));
        frame.add(nameField);
        frame.add(new JLabel("Score:"));
        frame.add(scoreField);
        frame.add(addButton);
        frame.add(searchButton);
        frame.add(removeButton);
        frame.add(showAllButton);
        frame.add(clearButton);
        frame.add(new JScrollPane(outputArea));

        frame.setVisible(true);
    }
}
