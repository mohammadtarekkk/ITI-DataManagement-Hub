import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.JFrame;
import java.awt.Font;
import javax.swing.JPanel;

public class FontList extends JPanel{
    public void paint (Graphics g) {
        String[] families = Toolkit.getDefaultToolkit().getFontList();
        for (int i = 0; i < families.length; i++) {
            Font font = new Font(families[i], Font.BOLD, 18);
            g.setFont(font);
            String name = families[i];
            g.drawString(name, 10, 20 + i * 15);
        }
    }
    public static void main(String[] args) throws Exception {
        FontList fontList = new FontList();
        JFrame frame = new JFrame("Font List with Toolkit");
        frame.setSize(300, 300);
        frame.setVisible(true);
        frame.add(fontList);
    }
}