package map;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.Map;
import java.util.TreeMap;

public class VotingMachineGUI extends JFrame {
    private static Map<String, Integer> voteCount = new TreeMap<>();
    private JTextField candidateField;
    private VotePanel votePanel;

    public VotingMachineGUI() {
        setTitle("Voting Machine with Animation");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Top input panel
        JPanel topPanel = new JPanel();
        candidateField = new JTextField(15);
        JButton voteButton = new JButton("Vote");
        JButton resetButton = new JButton("Reset");

        topPanel.add(new JLabel("Candidate Name:"));
        topPanel.add(candidateField);
        topPanel.add(voteButton);
        topPanel.add(resetButton);
        add(topPanel, BorderLayout.NORTH);

        // Voting chart panel
        votePanel = new VotePanel();
        add(votePanel, BorderLayout.CENTER);

        // Vote button Logic
        voteButton.addActionListener(e -> {
            String name = candidateField.getText().trim();
            if (!name.isEmpty()) {
                voteCount.merge(name, 1, Integer::sum);
                votePanel.repaint();
                SoundPlayer.playVoteSound();
            }
        });

        // Reset button logic
        resetButton.addActionListener(e -> {
            voteCount.clear();
            votePanel.repaint();
        });
    }

    private static class SoundPlayer {
        private static Clip voteClip;

        static {
            try {
                // Load the sound file once
                InputStream audioSrc = VotingMachineGUI.class.getResourceAsStream("/sounds/vote.wav");
                if (audioSrc != null) {
                    AudioInputStream audioStream = AudioSystem.getAudioInputStream(
                            new BufferedInputStream(audioSrc));
                    voteClip = AudioSystem.getClip();
                    voteClip.open(audioStream);
                }
            } catch (Exception e) {
                System.err.println("Error loading sound: " + e.getMessage());
            }
        }

        public static void playVoteSound() {
            if (voteClip != null) {
                // Rewind to start if already playing
                voteClip.setFramePosition(0);
                voteClip.start();
            } else {
                // Fallback to system beep
                java.awt.Toolkit.getDefaultToolkit().beep();
            }
        }
    }

    class VotePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            setBackground(Color.WHITE);

            int x = 50;
            int y = 50;
            int barHeight = 30;
            int gap = 10;
            int maxWidth = getWidth() - 100;

            g.setFont(new Font("Arial", Font.BOLD, 16));

            for (Map.Entry<String, Integer> entry : voteCount.entrySet()) {
                String candidate = entry.getKey();
                int votes = entry.getValue();

                // Bar length: scale based on max vote count
                int barLength = votes * 30;
                if (barLength > maxWidth)
                    barLength = maxWidth;

                // Randomized color per candidate
                g.setColor(new Color(candidate.hashCode() * 31 | 0xFF000000));
                g.fillRoundRect(x, y, barLength, barHeight, 12, 12);

                // Text label
                g.setColor(Color.WHITE);
                g.drawString(candidate + "(" + votes + ")", x + 5, y + 20);

                y += barHeight + gap;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VotingMachineGUI gui = new VotingMachineGUI();
            gui.setVisible(true);
        });
    }
}