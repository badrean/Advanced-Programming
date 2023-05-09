package compulsory.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GameServer {
    private int portNumber;
    private ServerSocket serverSocket;
    private boolean stopped = false;

    public GameServer(int portNumber) {
        this.portNumber = portNumber;
    }

    public void start() {
        try {
            serverSocket = new ServerSocket(portNumber);
            System.out.println("Game server started on port " + portNumber);

            while (!stopped) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected");

                ClientThread client = new ClientThread(clientSocket, this);
                client.start();
            }

            System.out.println("Game server stopped");
            serverSocket.close();
        } catch (IOException e) {
            System.err.println("Error starting game server: " + e.getMessage());
        }
    }

    public void stop() {
        stopped = true;
    }
}
