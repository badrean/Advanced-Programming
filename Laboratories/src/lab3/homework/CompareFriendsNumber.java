package lab3.homework;

import java.util.Comparator;

/**
 * Class used to compare 2 Node objects.
 * <p>
 *
 * @author adrian
 * @since 1.0
 */
public class CompareFriendsNumber implements Comparator<Node> {
    /**
     * Method used to sort the nodes of a network, by the number of friends. This method sorts the nodes in descendent
     * order.
     *
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return <code>-1</code> if the first object is smaller than the second object <br>
     * <code>0</code> if the objects are equal <br>
     * <code>1</code> if the first object is greater than the second object
     */
    @Override
    public int compare(Node o1, Node o2) {
        return Integer.compare(o2.getNumberOfFriends(), o1.getNumberOfFriends());
    }
}
