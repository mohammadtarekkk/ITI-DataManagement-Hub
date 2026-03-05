import java.io.*;
import java.net.*;
import java.util.*;

class ChatHandler extends Thread {

    DataInputStream dis;
    PrintStream ps;
    static Vector<ChatHandler> clientsVector = new Vector<ChatHandler>();

    public ChatHandler(Socket cs) {
        try {
            dis = new DataInputStream(cs.getInputStream());
            ps = new PrintStream(cs.getOutputStream());

            ChatHandler.clientsVector.add(this);

            start();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(dis));
            while (true) {
                String str = br.readLine();
                if (str != null) {
                    sendMessageToAll(str);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    void sendMessageToAll(String msg) {
        for (int i = 0; i < clientsVector.size(); i++) {
            clientsVector.get(i).ps.println(msg);
        }
    }
}