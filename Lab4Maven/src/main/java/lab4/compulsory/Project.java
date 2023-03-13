package lab4.compulsory;

import java.util.Comparator;

/**
 * Class used to create project objects
 *
 * @author adrian
 * @since 1.0
 */
public class Project implements Comparable<Project> {
    /**
     * Name of the project
     */
    private String name;

    /**
     * Class constructor. It creates a new Project object.
     *
     * @param name name of the student
     */
    public Project(String name) {
        this.name = name;
    }

    /**
     * @param o the object to be compared.
     * @return <code>-1</code> in case this object is smaller than the object compared
     * * <code>0</code> in case they are equal
     * * <code>1</code> in case this object is greater than the object compared
     */
    @Override
    public int compareTo(Project o) {
        return name.compareTo(o.getName());
    }

    /**
     * Method used to get the name of the project
     *
     * @return name of the project
     */
    public String getName() {
        return name;
    }

    /**
     * Method used to set the name of the project
     *
     * @param name name of the project
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method that returns a string of the current object
     *
     * @return a string representing the object
     */
    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                '}';
    }
}
