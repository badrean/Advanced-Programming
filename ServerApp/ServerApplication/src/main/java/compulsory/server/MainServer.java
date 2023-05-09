package compulsory.server;

public class MainServer {
    public static void main(String[] args) {
        int portNumber = 5555;
        GameServer server = new GameServer(portNumber);
        server.start();
    }
}
