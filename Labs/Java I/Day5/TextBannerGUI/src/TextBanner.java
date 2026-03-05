import javax.swing.*;
import java.awt.*;

public class TextBanner extends JPanel implements Runnable {
    int x = 400;
    Thread th;

    public TextBanner() {
        th = new Thread(this);
        th.start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.RED);
        g.setFont(new Font("Arial", Font.BOLD, 24));
        g.drawString("I HATE JAVA (So far)!", x, 100);
    }

    public void run() {
        while (true) {
            x += 5;
            if (x > getWidth()) {
                x = -getFontMetrics(getFont()).stringWidth("I HATE JAVA (So far)!");
            }
            repaint();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Text Banner");
        TextBanner banner = new TextBanner();
        frame.add(banner);
        frame.setSize(400, 200);
        frame.setVisible(true);
    }
}