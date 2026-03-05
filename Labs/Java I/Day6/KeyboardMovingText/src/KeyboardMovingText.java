import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KeyboardMovingText extends JPanel {

    int x = 150, y = 100;
    String text = "I LOVE JAVA";

    public KeyboardMovingText() {
        setFocusable(true);
        // requestFocusInWindow();

        addKeyListener(new MyKeyListener());
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setFont(new Font("Arial", Font.BOLD, 24));
        g.setColor(Color.BLUE);
        g.drawString(text, x, y);
    }

    class MyKeyListener implements KeyListener {
        public void keyPressed(KeyEvent e) {
            int code = e.getKeyCode();

            switch (code) {
                case KeyEvent.VK_LEFT:
                    x -= 10;
                    break;
                case KeyEvent.VK_RIGHT:
                    x += 10;
                    break;
                case KeyEvent.VK_UP:
                    y -= 10;
                    break;
                case KeyEvent.VK_DOWN:
                    y += 10;
                    break;
            }

            repaint();
        }

        public void keyReleased(KeyEvent e) {}
        public void keyTyped(KeyEvent e) {}
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("I LOVE JAVA");
        KeyboardMovingText panel = new KeyboardMovingText();
        frame.add(panel);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}