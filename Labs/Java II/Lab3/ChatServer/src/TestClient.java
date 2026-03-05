import java.io.*;
import java.net.*;

public class TestClient {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("127.0.0.1", 5005);
            
            PrintStream ps = new PrintStream(s.getOutputStream());
            DataInputStream dis = new DataInputStream(s.getInputStream());

            ps.println("Hello from Test Client!");

            String reply = dis.readLine();
            System.out.println("Server says: " + reply);

            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}