import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameGUI {
    private JFrame frame;
    private JTextArea outputArea;
    private JTextField inputField;
    private AlienNPC currentAlien;

    public GameGUI() {
        currentAlien = new LogicalAlien("Zarnok the Strategist");

        frame = new JFrame("Mystic Alien Negotiator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        JLabel alienName = new JLabel("Talking to: " + currentAlien.getName());
        alienName.setFont(new Font("Arial", Font.BOLD, 18));

        outputArea = new JTextArea(10, 40);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        inputField = new JTextField(30);
        JButton sendButton = new JButton("Send");

        JButton switchButton = new JButton("Switch Alien");

        JPanel inputPanel = new JPanel();
        inputPanel.add(inputField);
        inputPanel.add(sendButton);
        inputPanel.add(switchButton);

        frame.setLayout(new BorderLayout());
        frame.add(alienName, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(inputPanel, BorderLayout.SOUTH);

        sendButton.addActionListener(e -> {
            String playerInput = inputField.getText();
            String response = currentAlien.respondToPlayer(playerInput);
            outputArea.append("You: " + playerInput + "\n");
            outputArea.append(currentAlien.getName() + ": " + response + "\n\n");
            inputField.setText("");
        });

        switchButton.addActionListener(e -> {
            if (currentAlien instanceof LogicalAlien) {
                currentAlien = new EmotionalAlien("Lura the Dreamer");
            } else {
                currentAlien = new LogicalAlien("Zarnok the Strategist");
            }
            alienName.setText("Talking to: " + currentAlien.getName());
            outputArea.append("\n--- Switched to " + currentAlien.getName() + " ---\n\n");
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GameGUI::new);
    }
}
