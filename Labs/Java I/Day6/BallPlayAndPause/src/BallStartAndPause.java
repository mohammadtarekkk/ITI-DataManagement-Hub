import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;

public class BallStartAndPause extends JPanel implements Runnable {

    int x = 100, y = 100;
    int dx = 3, dy = 3;
    int ballSize = 30;

    boolean running = false;
    Thread th;

    JButton startBtn;
    JButton pauseBtn;

    public BallStartAndPause() {

        startBtn = new JButton("Start");
        pauseBtn = new JButton("Pause");

        startBtn.addActionListener(new StartLis());
        pauseBtn.addActionListener(new PauseLis());

        add(startBtn);
        add(pauseBtn);

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
            if (running) {
                x += dx;
                y += dy;
                if (x < 0 || x + ballSize > getWidth()) {
                    dx = -dx;
                }
                if (y < 0 || y + ballSize > getHeight()) {
                    dy = -dy;
                }
                repaint();
            }

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class StartLis implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            running = true;
        }
    }

    class PauseLis implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            running = false;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("BallStartAndPause");
        BallStartAndPause ball = new BallStartAndPause();
        frame.add(ball);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}