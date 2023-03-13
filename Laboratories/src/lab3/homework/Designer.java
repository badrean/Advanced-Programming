package lab3.homework;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Map;

/**
 * Designer class that extends the person class. It adds a new data member that holds a list of the design
 * software known by the designer.
 * <p>
 *
 * @author adrian
 * @see lab3.homework.Person
 * @since 1.0
 */
public class Designer extends Person {
    /**
     * Array containing the known design software
     */
    private String[] usedSoftware;

    /**
     * Class constructor. It creates a new Designer object.
     *
     * @param name         name of the person
     * @param date         date of birth
     * @param usedSoftware array of known design software
     * @see Person
     */
    public Designer(String name, LocalDate date, String[] usedSoftware) {
        super(name, date, true);
        this.usedSoftware = usedSoftware;
    }

    /**
     * Method used to get the known design software of the designer
     *
     * @return an array of known design software
     */
    public String[] getUsedSoftware() {
        return usedSoftware;
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

        return "Programmer{" +
                "name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", usedSoftware=" + Arrays.toString(usedSoftware) +
                ", friendList=[" + retFriends + "]" +
                '}';
    }
}
