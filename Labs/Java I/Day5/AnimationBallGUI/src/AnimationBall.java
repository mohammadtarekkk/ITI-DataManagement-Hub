import javax.swing.*;
import java.awt.*;

public class AnimationBall extends JPanel implements Runnable {

    int x = 100, y = 100;
    int dx = 3, dy = 3;
    int ballSize = 30;
    Thread th;

    public AnimationBall() {
        th = new Thread(this);
        th.start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.RED);
        g.fillOval(x, y, ballSize, ballSize);
    }

    public void run() {
        while (true) {
            x += dx;
            y += dy;
            if (x < 0 || x + ballSize > getWidth()) {
                dx = -dx;
            }
            if (y < 0 || y + ballSize > getHeight()) {
                dy = -dy;
            }
            repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("AnimationBall");
        AnimationBall ball = new AnimationBall();
        frame.add(ball);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}