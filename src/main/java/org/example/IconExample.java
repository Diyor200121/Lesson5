package org.example;

import javax.swing.*;
import java.awt.*;

public class IconExample {
        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
                JFrame frame = new JFrame("Icon Example");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                JPanel panel = new JPanel() {
                    @Override
                    protected void paintComponent(Graphics g) {
                        super.paintComponent(g);
                        drawIcon(g, "Aziz tog'o");
                    }
                };

                frame.add(panel);
                frame.setSize(200, 200);
                frame.setVisible(true);
            });
        }

        private static void drawIcon(Graphics g, String text) {
            g.setColor(Color.CYAN);
            g.fillRect(50, 50, 100, 100);

            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 20));
            FontMetrics fontMetrics = g.getFontMetrics();
            int textWidth = fontMetrics.stringWidth(text);
            int textHeight = fontMetrics.getHeight();
            int x = (100 - textWidth) / 2 + 50;
            int y = (100 - textHeight) / 2 + 50;
            g.drawString(text, x, y);
        }
    }

