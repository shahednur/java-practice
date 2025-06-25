package map;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedHashMap;
import java.util.HashMap;
import java.util.Map;

public class BookCatalogGUI extends JFrame {
    private Map<String, String> bookCatalog = new HashMap<>();
    private JTextField isbnField, titleField;
    private BookPanel bookPanel;

    public BookCatalogGUI() {
        setTitle("Library Book Catalog");
        setSize(650, 550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Input panel
        JPanel topPanel = new JPanel();
        isbnField = new JTextField(10);
        titleField = new JTextField(15);
        JButton addButton = new JButton("Add Book");
        JButton removeButton = new JButton("Remove");
        JButton searchButton = new JButton("Search");

        topPanel.add(new JLabel("ISBN:"));
        topPanel.add(isbnField);
        topPanel.add(new JLabel("Title"));
        topPanel.add(titleField);
        topPanel.add(addButton);
        topPanel.add(removeButton);
        topPanel.add(searchButton);

        add(topPanel, BorderLayout.NORTH);

        // Catalog display panel
        bookPanel = new BookPanel();
        JScrollPane scrollPane = new JScrollPane(bookPanel);
        add(scrollPane, BorderLayout.CENTER);

        // Add Logic
        addButton.addActionListener(e -> {
            String isbn = isbnField.getText().trim();
            String title = titleField.getText().trim();
            if (!isbn.isEmpty() && !title.isEmpty()) {
                bookCatalog.put(isbn, title);
                bookPanel.animatedAdd();
            }
        });

        // Remove Logic
        removeButton.addActionListener(e -> {
            String isbn = isbnField.getText().trim();
            if (bookCatalog.containsKey(isbn)) {
                bookCatalog.remove(isbn);
                bookPanel.repaint();
            }
        });

        // Search Logic
        searchButton.addActionListener(e -> {
            String isbn = isbnField.getText().trim();
            String title = bookCatalog.get(isbn);
            if (title != null) {
                JOptionPane.showMessageDialog(this, "Title: " + title);
            } else {
                JOptionPane.showMessageDialog(this, "ISBN not found.");
            }
        });
    }

    // Panel to draw books
    class BookPanel extends JPanel {
        private int animationY = 0;

        public BookPanel() {
            setPreferredSize(new Dimension(600, 1500));
        }

        public void animatedAdd() {
            animationY = 0;
            Timer timer = new Timer(10, null);
            timer.addActionListener(e -> {
                animationY += 10;
                repaint();
                if (animationY >= 60)
                    timer.stop();
            });
            timer.start();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            setBackground(new Color(253, 250, 240));

            int y = 20;
            int height = 60;

            for (Map.Entry<String, String> entry : bookCatalog.entrySet()) {
                if (y > animationY)
                    break;

                // Book card background
                g.setColor(new Color(255, 255, 255));
                g.fillRoundRect(30, y, 560, height, 15, 15);

                // Book cover reactangle (left)
                int hashColor = Math.abs(entry.getKey().hashCode() % 0xFFFFFF);
                g.setColor(new Color(hashColor));
                g.fillRoundRect(40, y + 10, 40, 40, 10, 10);

                // Book details
                g.setColor(Color.DARK_GRAY);
                g.setFont(new Font("Arial", Font.BOLD, 14));
                g.drawString("Title: " + entry.getValue(), 100, y + 30);
                g.setFont(new Font("Arial", Font.PLAIN, 12));
                g.drawString("ISBN: " + entry.getKey(), 100, y + 50);

                y += height + 15;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BookCatalogGUI gui = new BookCatalogGUI();
            gui.setVisible(true);
        });
    }
}
