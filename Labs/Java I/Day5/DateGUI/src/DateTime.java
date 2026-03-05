import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class DateTime extends JPanel implements Runnable {

    Thread th;
    public DateTime() {
        th = new Thread(this);
        th.start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Date d = new Date();
        g.drawString(d.toString(), 100, 200);
    }

    public void run() {
        while (true) {
            repaint();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        JFrame f = new JFrame("Date and Time");
        DateTime dt = new DateTime();
        f.add(dt);
        f.setSize(400, 400);
        f.setVisible(true);
    }
}