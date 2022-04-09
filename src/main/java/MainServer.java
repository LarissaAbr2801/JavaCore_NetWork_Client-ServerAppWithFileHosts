import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8080);
             Socket clientSocket = serverSocket.accept();
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader
                     (new InputStreamReader(clientSocket.getInputStream()))) {
            System.out.println("New connection accepted");

            out.println("Hi, write your name");
            in.readLine();
            String clientName = in.readLine();

            out.println(String.format("%s, are you a child?", clientName));
            String clientAnswerIfChild = in.readLine();

            if (clientAnswerIfChild.equals("yes") || clientAnswerIfChild.equals("Yes")) {
                out.println(String.format("Welcome to the kids area, %s! Let's play!",
                        clientName));
            } else if (clientAnswerIfChild.equals("no") || clientAnswerIfChild.equals("No")) {
                out.println(String.format("Welcome to the adult zone, %s!" +
                        " Have a good rest, or a good working day!", clientName));
            } else {
                out.println("Answer yes or no");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}