package lab3.compulsory;

import org.jetbrains.annotations.NotNull;

/**
 * Company class that holds the name of a person object
 * <p>
 *
 * @see lab3.compulsory.Node
 * @see java.lang.Comparable
 * @author adrian
 * @since 1.0
 */
public class Person implements Comparable, Node {
    /**
     * the name of the person object
     */
    String name;

    /**
     * Constructs an instance of Person class with the name given as param
     *
     * @param name the name to be saved
     */
    Person(String name) {
        this.name = name;
    }

    /**
     * Method that compares 2 objects of the type Node.
     *
     * @param obj the object to be compared.
     * @return <code>-1</code> in case this is smaller than param
     * <code>0</code> in case they are equal
     * <code>1</code> in case this is greater than param
     */
    @Override
    public int compareTo(@NotNull Object obj) {
        if (obj == this) {
            return 0;
        }
        if (!(obj instanceof Node)) {
            return -1;
        }
        Node auxiliary = (Node) obj;
        String auxiliaryName = auxiliary.getName();
        String thisName = this.getName();
        int indx = 0;
        while (indx < thisName.length() && indx < auxiliaryName.length()) {
            if (thisName.charAt(indx) < auxiliaryName.charAt(indx)) {
                return -1;
            }
            if (thisName.charAt(indx) > auxiliaryName.charAt(indx)) {
                return 1;
            }
            if (indx >= thisName.length()) {
                return -1; //the word compared has more letters than this, so it's greater than this
            }
            if (indx >= auxiliaryName.length()) {
                return 1; //this word has more letters than the compared word, so this is greater
            }
            indx++;
        }
        return 0;
    }

    /**
     * Returns the name of the class
     *
     * @return the name of the class
     */
    @Override
    public String getName() {
        return "Person: " + name;
    }

    /**
     * Method that returns a string of the current object
     *
     * @return a string representing the object
     */
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
