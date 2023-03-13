package lab3.homework;

/**
 * Interface that implies the getName method and getNumberOfFriends
 * <p>
 * @author adrian
 * @since 1.0
 */
public interface Node {
    /**
     * method that returns the name of the person or company
     * @return the name of the person/company
     */
    String getName();
    /**
     * method that returns the number of friends a Person or Company has
     * @return the number of friends
     */
    int getNumberOfFriends();

}
