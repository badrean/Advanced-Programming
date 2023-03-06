package lab2.compulsory;

/**
 * Generic class that holds a pair of two objects of any type
 *
 * @author Adrian-Paul Bilba
 * @version %I%, %G%
 * @since 1.0
 */
public class Pair<S, T> {
    /**
     * The first object stored
     */
    private S first;
    /**
     * The second object stored
     */
    private T second;

    /**
     * Constructor that stores the first and second object passed in the first and second data members.
     *
     * @param first  The first object to be stored
     * @param second The second object to be stored
     * @since 1.0
     */
    public Pair(S first, T second) {
        this.first = first;
        this.second = second;
    }

    /**
     * Gets the first element
     *
     * @return first element
     */
    public S getFirst() {
        return first;
    }

    /**
     * Sets an element on the first position
     *
     * @param first element to be stored
     */
    public void setFirst(S first) {
        this.first = first;
    }

    /**
     * Returns second stored element
     *
     * @return second stored element
     */
    public T getSecond() {
        return second;
    }

    /**
     * Stores and element on the second position
     *
     * @param second element to be stored
     */
    public void setSecond(T second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}