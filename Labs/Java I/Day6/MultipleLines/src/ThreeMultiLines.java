import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ThreeMultiLines extends JPanel {

    int[] startX = new int[3];
    int[] startY = new int[3];
    int[] endX   = new int[3];
    int[] endY   = new int[3];

    int lineCount = 0;
    boolean dragging = false;

    public ThreeMultiLines() {
        addMouseListener(new MyMouseListener());
        addMouseMotionListener(new MyMouseMotionListener());
    }

    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(Color.RED);

        for (int i = 0; i < lineCount; i++) {
            g.drawLine(startX[i], startY[i], endX[i], endY[i]);
        }

        if (dragging && lineCount < 3) {
            g.drawLine(startX[lineCount], startY[lineCount], endX[lineCount], endY[lineCount]);
        }
    }

    class MyMouseListener implements MouseListener {

        public void mousePressed(MouseEvent e) {
            if (lineCount < 3) {
                startX[lineCount] = e.getX();
                startY[lineCount] = e.getY();
                dragging = true;
            }
        }

        public void mouseReleased(MouseEvent e) {
            if (lineCount < 3) {
                endX[lineCount] = e.getX();
                endY[lineCount] = e.getY();
                dragging = false;
                lineCount++;
                repaint();
            }
        }

        public void mouseClicked(MouseEvent e) {}
        public void mouseEntered(MouseEvent e) {}
        public void mouseExited(MouseEvent e) {}
    }

    class MyMouseMotionListener implements MouseMotionListener {
        public void mouseDragged(MouseEvent e) {
            if (lineCount < 3) {
                endX[lineCount] = e.getX();
                endY[lineCount] = e.getY();
                repaint();
            }
        }

        public void mouseMoved(MouseEvent e) {}
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Draw Three Lines");
        ThreeMultiLines panel = new ThreeMultiLines();
        frame.add(panel);
        frame.setSize(600, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}