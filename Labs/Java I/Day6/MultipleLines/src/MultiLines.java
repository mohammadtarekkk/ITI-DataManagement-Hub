import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MultiLines extends JPanel {

    ArrayList<Integer> startX = new ArrayList<>();
    ArrayList<Integer> startY = new ArrayList<>();
    ArrayList<Integer> endX   = new ArrayList<>();
    ArrayList<Integer> endY   = new ArrayList<>();

    boolean dragging = false;

    public MultiLines() {
        addMouseListener(new MyMouseListener());
        addMouseMotionListener(new MyMouseMotionListener());
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.RED);

        for (int i = 0; i < endX.size(); i++) {
            g.drawLine(startX.get(i), startY.get(i), endX.get(i), endY.get(i));
        }

        if (dragging) {
            int last = startX.size() - 1;
            g.drawLine(startX.get(last), startY.get(last), endX.get(last), endY.get(last));
        }
    }

    class MyMouseListener implements MouseListener {

        public void mousePressed(MouseEvent e) {
            startX.add(e.getX());
            startY.add(e.getY());

            endX.add(e.getX());
            endY.add(e.getY());

            dragging = true;
        }

        public void mouseReleased(MouseEvent e) {
            int last = endX.size() - 1;
            endX.set(last, e.getX());
            endY.set(last, e.getY());

            dragging = false;
            repaint();
        }

        public void mouseClicked(MouseEvent e) {}
        public void mouseEntered(MouseEvent e) {}
        public void mouseExited(MouseEvent e) {}
    }

    class MyMouseMotionListener implements MouseMotionListener {
        public void mouseDragged(MouseEvent e) {
            int last = endX.size() - 1;
            endX.set(last, e.getX());
            endY.set(last, e.getY());

            repaint();
        }

        public void mouseMoved(MouseEvent e) {}
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("MultiLines");
        MultiLines panel = new MultiLines();
        frame.add(panel);
        frame.setSize(600, 400);
        frame.setVisible(true);
    }
}