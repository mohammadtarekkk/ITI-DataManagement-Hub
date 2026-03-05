import javax.swing.JFrame;
import java.awt.Graphics;

class MyPanel extends javax.swing.JPanel {
    @Override
    public void paintComponent(Graphics g) {
        g.drawString("Hello, World!", 100, 200);
    }
}
public class App {
    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame("GUI Application");
        MyPanel panel = new MyPanel();
        frame.setContentPane(panel);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}
