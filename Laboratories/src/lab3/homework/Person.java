package lab3.homework;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * Person class that holds the name of the person, the date of birth, a list of friends and if the person finished
 * college or not.
 * <p>
 *
 * @author adrian
 * @see lab3.homework.Node
 * @since 1.0
 */
public class Person implements Node {
    /**
     * Name of the person
     */
    protected String name;
    /**
     * Date of birth of the person
     */
    protected LocalDate dateOfBirth;
    /**
     * Whether the person finished college or not
     */
    protected boolean finishedCollege;
    /**
     * List of friends
     */
    protected Map<String, Node> friendList;

    /**
     * Class constructor. It creates a new Person object.
     *
     * @param name  name of the person
     * @param date  date of birth
     * @param value <code>true<code/> if the person finished college
     *              <code>false</code> if the person didn't finish college
     */
    public Person(String name, LocalDate date, boolean value) {
        this.name = name;
        dateOfBirth = date;
        finishedCollege = value;
        friendList = new HashMap<>();
    }

    /**
     * Method used to get the name of the person
     *
     * @return name of the person
     */
    public String getName() {
        return name;
    }

    /**
     * Method used to get the number of friends
     *
     * @return size of friend list, which represents the number of friends the person has
     */
    public int getNumberOfFriends() {
        return friendList.size();
    }

    /**
     * Method used to het the date of birth
     *
     * @return date of birth
     */
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Method used to check if the person finished college or not
     *
     * @return <code>true<code/> if the person finished college
     * <code>false</code> if the person didn't finish college
     */
    public boolean isFinishedCollege() {
        return finishedCollege;
    }

    /**
     * Method used to get the map of friends
     *
     * @return a map containing the friends of the person
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

        return "Person{" +
                "name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", finishedCollege=" + finishedCollege +
                ", friendList=[" + retFriends + "]" +
                '}';
    }
}
