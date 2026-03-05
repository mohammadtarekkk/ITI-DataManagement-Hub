import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class ButtonPanel extends JPanel {
    int x = 0;
    JButton inc;
    JButton dec;

    public ButtonPanel() {
        inc = new JButton("Increment");
        dec = new JButton("Decrement");

        inc.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            x++;
            repaint();
        }
    });
        dec.addActionListener(new DecLis());

        add(inc);
        add(dec);
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.drawString("Value: " + x, 70, 100);
    }

    class IncLis implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            x++;
            repaint();
        }
    }

    class DecLis implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            x--;
            repaint();
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Button Panel");
        ButtonPanel panel = new ButtonPanel();
        frame.add(panel);
        frame.setSize(200, 200);
        frame.setVisible(true);
    }
}
