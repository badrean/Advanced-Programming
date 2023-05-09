package compulsory.client;

public class Main {
    public static void main(String[] args) {
        int portNumber = 5555;
        String serverAddress = "localhost";
        GameClient client = new GameClient(serverAddress, portNumber);
        client.start();
    }
}
