import javax.swing.JFrame;

public class App {
    public static void main(String[] args) throws Exception {
        FontList fontList = new FontList();
        JFrame frame = new JFrame("Font List");
        frame.getContentPane().add(fontList);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}
