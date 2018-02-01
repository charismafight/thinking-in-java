package c15;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class JabberServer {
    public static final int port = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(port);
        System.out.println("started " + ss);

        try {
            Socket s = ss.accept();
            try {
                System.out.println("Connection accepted " + s);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(s.getInputStream()));
                PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(s.getOutputStream()), true);
                while (true) {
                    String str = bufferedReader.readLine();
                    if (str.equals("END")) {
                        break;
                    }
                    System.out.println("Echoing " + str);
                    printWriter.println(str);
                }
            } finally {
                s.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            ss.close();
        }
    }
}
