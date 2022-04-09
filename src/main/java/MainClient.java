import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class MainClient {

    public static void main(String[] args) throws UnknownHostException {
        String host = "netology.homework";
        int port = 8080;
        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader
                     (new InputStreamReader(clientSocket.getInputStream()))) {
            String serverAskName = in.readLine();
            System.out.println("Server: " + serverAskName);

            String clientHi = "Hi, my name is ";
            out.println(clientHi);
            out.println(host);
            System.out.println("Client: " + clientHi + host);

            String serverAskIfChild = in.readLine();
            System.out.println("Server: " + serverAskIfChild);

            String clientAnswerIfChild = "no";
            out.println(clientAnswerIfChild);
            System.out.println("Client: " + clientAnswerIfChild);

            String serverWelcome = in.readLine();
            System.out.println("Server: " + serverWelcome);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
