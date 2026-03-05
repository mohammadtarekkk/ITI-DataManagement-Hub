import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import javax.swing.JFrame;
import java.awt.Font;
import javax.swing.JPanel;

public class FontListGE extends JPanel {
    public void paint(Graphics g) {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] families = ge.getAvailableFontFamilyNames();
        for (int i = 0; i < families.length; i++) {
            Font font = new Font(families[i], Font.BOLD, 18);
            g.setFont(font);
            String name = families[i];
            g.drawString(name, 10, 20 + i * 15);
        }
    }
    public static void main(String[] args) throws Exception {
        FontListGE fontList = new FontListGE();
        JFrame frame = new JFrame("Font List with GraphicsEnvironment");
        frame.setSize(300, 300);
        frame.setVisible(true);
        frame.add(fontList);
    }
}