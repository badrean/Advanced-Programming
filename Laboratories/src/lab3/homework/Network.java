package lab3.homework;

import java.util.ArrayList;
import java.util.List;

/**
 * Class used to store the users of a network.
 * <p>
 *
 * @author adrian
 * @see lab3.homework.Node
 * @since 1.0
 */
public class Network {
    /**
     * List containing the users of the network
     */
    private List<Node> networkNodes;

    /**
     * Class constructor. It creates a new Network object.
     */
    public Network() {
        networkNodes = new ArrayList<>();
    }

    /**
     * Method used to add a new user in the network. It checks if the name of the user already exists.
     *
     * @param node new user to be added in the network
     */
    public void addNode(Node node) {
        String nodeName = node.getName();
        for (Node idx : networkNodes) {
            if (idx.getName().equals(nodeName)) {
                System.out.println("User " + nodeName + " already exists");
                return;
            }
        }

        networkNodes.add(node);
    }

    /**
     * Method used to remove a user from the network
     *
     * @param node user to be removed
     */
    public void removeNode(Node node) {
        networkNodes.remove(node);
    }

    /**
     * Method used to get the users of the network
     *
     * @return list containing the users of the network
     */
    public List<Node> getNetworkNodes() {
        return networkNodes;
    }

    /**
     * Method that returns a string of the current object
     *
     * @return a string representing the object
     */
    @Override
    public String toString() {
        return "Network{" + networkNodes +
                '}';
    }
}
