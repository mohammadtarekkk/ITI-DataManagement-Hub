import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SingleLine extends JPanel {

    int startX, startY, endX, endY;
    boolean dragging = false;

    public SingleLine() {
        addMouseListener(new MyMouseListener());
        addMouseMotionListener(new MyMouseMotionListener());
    }

    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(Color.RED);
        g.drawLine(startX, startY, endX, endY);
    }

    class MyMouseListener implements MouseListener {
        public void mousePressed(MouseEvent e) {
            startX = e.getX();
            startY = e.getY();
            dragging = true;
        }

        public void mouseReleased(MouseEvent e) {
            endX = e.getX();
            endY = e.getY();
            dragging = false;
            repaint();
        }

        public void mouseClicked(MouseEvent e) {}
        public void mouseEntered(MouseEvent e) {}
        public void mouseExited(MouseEvent e) {}
    }

    class MyMouseMotionListener implements MouseMotionListener {
        public void mouseDragged(MouseEvent e) {
            endX = e.getX();
            endY = e.getY();
            repaint();
        }

        public void mouseMoved(MouseEvent e) {}
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Draw Line");
        SingleLine panel = new SingleLine();
        frame.add(panel);
        frame.setSize(500, 400);
        frame.setVisible(true);
    }
}