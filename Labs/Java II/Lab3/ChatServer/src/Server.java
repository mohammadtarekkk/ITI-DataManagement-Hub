import java.io.*;
import java.net.*;
import java.util.*;

public class Server {

    ServerSocket serverSocket;

    public Server() {
        try {
            serverSocket = new ServerSocket(5005);
            
            while (true) {
                Socket s = serverSocket.accept();
                new ChatHandler(s);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Server();
    }
}