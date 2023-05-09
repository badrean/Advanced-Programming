package compulsory.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {
    private Socket clientSocket;
    private GameServer server;
    private boolean stopped = false;

    public ClientThread(Socket socket, GameServer server) {
        this.clientSocket = socket;
        this.server = server;
    }

    public void run() {
        try (
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        ) {
            String inputLine;

            while (!stopped && (inputLine = in.readLine()) != null) {

                switch (inputLine) {
                    case "STOP":
                        stopped = true;
                        System.out.println("Server received stop command.");
                        out.println("Stopping server.");
                        server.stop();
                        break;
                    case "EXIT":
                        stopped = true;
                        out.println("Client stopped");
                        System.out.println("Client stopped the connection");
                        break;
                    default:
                        out.println("Server received the request ...");
                }
            }

            clientSocket.close();
        } catch (IOException e) {
            System.err.println("Error handling client request: " + e.getMessage());
        }
    }
}
