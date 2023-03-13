package lab3.homework;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

/**
 * Company class that holds the name of the company, a list of friends and a number of employees (specific property of
 * Company)
 * <p>
 *
 * @author adrian
 * @see lab3.homework.Node
 * @since 1.0
 */
public class Company implements Node {
    /**
     * Name of the company
     */
    protected String name;
    /**
     * List of the friends of the company
     */
    protected Map<String, Node> friendList;
    /**
     * Number of employees;
     */
    protected int numberOfEmployees;

    /**
     * Class constructor. It creates a new Company object.
     *
     * @param name   name of the company to be created
     * @param number number of employees
     */
    public Company(String name, int number) {
        this.name = name;
        this.numberOfEmployees = number;
        friendList = new HashMap<>();
    }

    /**
     * Method used to get the name of the company
     *
     * @return name of the company
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Method used to get the number of friends
     *
     * @return size of friend list, which represents the number of friends the company has
     */
    @Override
    public int getNumberOfFriends() {
        return friendList.size();
    }

    /**
     * Method used to get the number of employees
     *
     * @return number of employees
     */
    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    /**
     * Method used to get the map of friends
     *
     * @return a map containing the friends of the company
     */
    public Map<String, Node> getFriendList() {
        return friendList;
    }

    /**
     * Method used to add a new object to the list of friends. It checks if the friend was previously
     * added or if you try to follow yourself.
     *
     * @param friend object to be added to the list of friends
     */
    public void followFriend(Node friend) {
        if (this == friend) {
            System.out.println("You can't follow yourself!");
            return;
        }
        if (friendList.containsKey(friend.getName())) {
            System.out.println("You already are friends with " + friend.getName());
            return;
        }
        friendList.put(friend.getName(), friend);
    }

    /**
     * Method that returns a string of the current object
     *
     * @return a string representing the object
     */
    @Override
    public String toString() {
        StringBuilder retFriends = new StringBuilder();
        for (Map.Entry<String, Node> set : friendList.entrySet()) {
            retFriends.append(set.getKey()).append(", ");
        }
        if (retFriends.length() > 0)
            retFriends.delete(retFriends.length() - 2, retFriends.length());

        return "Company{" +
                "name='" + name + '\'' +
                ", numberOfEmployees=" + numberOfEmployees +
                ", friendList=[" + retFriends + "]" +
                '}';
    }
}
