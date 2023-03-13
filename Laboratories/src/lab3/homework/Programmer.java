package lab3.homework;


import java.time.LocalDate;
import java.util.Arrays;
import java.util.Map;

/**
 * Programmer class that extends the person class. It adds a new data member that holds a list of the programming
 * languages known by the programmer.
 * <p>
 *
 * @author adrian
 * @see lab3.homework.Person
 * @since 1.0
 */
public class Programmer extends Person {
    /**
     * An array of programming languages the programmers knows
     */
    private String[] programmingLanguages;

    /**
     * Class constructor. It creates a new Programmer object.
     *
     * @param name                 name of the person
     * @param date                 date of birth
     * @param programmingLanguages array of known programming languages
     * @see Person
     */
    public Programmer(String name, LocalDate date, String[] programmingLanguages) {
        super(name, date, true);
        this.programmingLanguages = programmingLanguages;
    }

    /**
     * Method used to get the known programming languages of the programmer
     *
     * @return an array of known programming languages
     */
    public String[] getProgrammingLanguages() {
        return programmingLanguages;
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
                ", programmingLanguages=" + Arrays.toString(programmingLanguages) +
                ", friendList=[" + retFriends + "]" +
                '}';
    }
}
