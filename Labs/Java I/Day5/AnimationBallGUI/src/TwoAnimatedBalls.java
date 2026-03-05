import javax.swing.*;
import java.awt.*;

public class TwoAnimatedBalls extends JPanel implements Runnable {

    int x1 = 50, y1 = 50, dx1 = 2, dy1 = 3;
    int x2 = 200, y2 = 150, dx2 = -3, dy2 = -2;
    int ballSize = 30;
    Thread th;

    public TwoAnimatedBalls() {
        th = new Thread(this);
        th.start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.RED);
        g.fillOval(x1, y1, ballSize, ballSize);

        g.setColor(Color.BLUE);
        g.fillOval(x2, y2, ballSize, ballSize);
    }

    public void run() {
        while (true) {
            x1 += dx1;
            y1 += dy1;

            x2 += dx2;
            y2 += dy2;

            if (x1 < 0 || x1 + ballSize > getWidth()) dx1 = -dx1;
            if (y1 < 0 || y1 + ballSize > getHeight()) dy1 = -dy1;

            if (x2 < 0 || x2 + ballSize > getWidth()) dx2 = -dx2;
            if (y2 < 0 || y2 + ballSize > getHeight()) dy2 = -dy2;

            if (checkCollision()) {
                dx1 = -dx1;
                dy1 = -dy1;
                dx2 = -dx2;
                dy2 = -dy2;
            }

            repaint();

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean checkCollision() {
        int centerX1 = x1 + ballSize / 2;
        int centerY1 = y1 + ballSize / 2;
        int centerX2 = x2 + ballSize / 2;
        int centerY2 = y2 + ballSize / 2;

        double distance = Math.sqrt(Math.pow(centerX1 - centerX2, 2) + Math.pow(centerY1 - centerY2, 2));
        return distance < ballSize;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Two Bouncing Balls");
        TwoAnimatedBalls panel = new TwoAnimatedBalls();
        frame.add(panel);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}