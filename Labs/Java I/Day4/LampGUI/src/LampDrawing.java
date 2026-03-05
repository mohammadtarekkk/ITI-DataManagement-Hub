import javax.swing.*;
import java.awt.*;

public class LampDrawing extends JPanel {

    public void paint(Graphics g) {
        super.paint(g);

        // Upper Oval
        g.drawOval(100, 30, 100, 50);
        g.setColor(Color.YELLOW);
        g.fillOval(100, 30, 100, 50);

        g.setColor(Color.BLACK);
        g.drawLine(100, 50, 80, 100); // left line
        g.drawLine(200, 50, 220, 100); // right line

        g.drawArc(80, 60, 140, 80, 180, 180); // arc

        // Stand
        g.setColor(Color.BLACK);
        g.drawLine(160, 140, 170, 180); // Right
        g.drawLine(140, 140, 130, 180); // Left

        // Base
        g.setColor(Color.DARK_GRAY);
        g.drawRect(100, 180, 100, 10); 
        g.fillRect(100, 180, 100, 10);

        // Middle Oval
        g.setColor(Color.BLACK);
        g.drawOval(135, 85, 30, 50);
        g.setColor(Color.YELLOW);
        g.fillOval(135, 85, 30, 50);

        // Right Oval
        g.setColor(Color.BLACK);
        g.drawOval(185, 85, 20, 30);
        g.setColor(Color.YELLOW);
        g.fillOval(185, 85, 20, 30);

        // Left Oval
        g.setColor(Color.BLACK);
        g.drawOval(95, 85, 20, 30);
        g.setColor(Color.YELLOW);
        g.fillOval(95, 85, 20, 30);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Lamp Drawing");
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new LampDrawing());
        frame.setVisible(true);
    }
}