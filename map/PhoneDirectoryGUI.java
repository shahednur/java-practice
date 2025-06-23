package map;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class PhoneDirectoryGUI extends JFrame {
    private Map<String, String> phonebook = new LinkedHashMap<>();
    private JTextField nameField, phoneField;
    private ContactPanel contactPanel;

    public PhoneDirectoryGUI() {
        setTitle("Phone Directory");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Top panel
        JPanel inputPanel = new JPanel();
        nameField = new JTextField(10);
        phoneField = new JTextField(10);
        JButton addButton = new JButton("Add");
        JButton removeButton = new JButton("Remove");
        JButton searchButton = new JButton("Search");

        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Phone:"));
        inputPanel.add(phoneField);
        inputPanel.add(addButton);
        inputPanel.add(removeButton);
        inputPanel.add(searchButton);

        add(inputPanel, BorderLayout.NORTH);

        // Contact list panel
        contactPanel = new ContactPanel();
        JScrollPane scrollPane = new JScrollPane(contactPanel);
        add(scrollPane, BorderLayout.CENTER);

        // Button actions
        addButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            String phone = phoneField.getText().trim();
            if (!name.isEmpty() && !phone.isEmpty()) {
                phonebook.put(name, phone);
                contactPanel.animatedAdd();
            }
        });

        removeButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            if (phonebook.containsKey(name)) {
                phonebook.remove(name);
                contactPanel.repaint();
            }
        });

        searchButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            String phone = phonebook.get(name);
            if (phone != null) {
                JOptionPane.showMessageDialog(this, name + "'s number is " + phone);
            } else {
                JOptionPane.showMessageDialog(this, "Contact not found.");
            }
        });
    }

    // Panel to draw contact cards
    class ContactPanel extends JPanel {
        private int animationY = 0;

        public ContactPanel() {
            setPreferredSize(new Dimension(580, 1000));
        }

        public void animatedAdd() {
            animationY = 0;
            Timer timer = new Timer(10, null);
            timer.addActionListener(e -> {
                animationY += 10;
                repaint();
                if (animationY >= 50)
                    timer.stop();
            });
            timer.start();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            setBackground(Color.white);

            int y = 20;
            int cardHeight = 50;

            for (Map.Entry<String, String> entry : phonebook.entrySet()) {
                if (y > animationY)
                    break;

                // Draw contact card
                g.setColor(new Color(240, 248, 255));
                g.fillRoundRect(20, y, 520, cardHeight, 20, 20);

                // Icon circle
                g.setColor(new Color(entry.getKey().hashCode() * 17 | 0xFF000000));
                g.fillOval(30, y + 10, 30, 30);

                // Text
                g.setColor(Color.BLACK);
                g.setFont(new Font("Arial", Font.PLAIN, 14));
                g.drawString(entry.getKey(), 70, y + 25);
                g.drawString(entry.getValue(), 400, y + 25);

                y += cardHeight + 10;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PhoneDirectoryGUI app = new PhoneDirectoryGUI();
            app.setVisible(true);
        });
    }
}
