package lab4.compulsory;

import java.util.List;

/**
 * Class used to create student objects
 *
 * @author adrian
 * @since 1.0
 */

public class Student implements Comparable<Student> {
    /**
     * Name of the student
     */
    private String name;
    /**
     * A list of admissible projects
     */
    private List<Project> admissibleProjects;

    /**
     * Class constructor. It creates a new Student object.
     *
     * @param name               name of the student
     * @param admissibleProjects list of admissible projects
     */
    public Student(String name, List<Project> admissibleProjects) {
        this.name = name;
        this.admissibleProjects = admissibleProjects;
    }

    /**
     * @param o the object to be compared.
     * @return <code>-1</code> in case this object is smaller than the object compared
     * * <code>0</code> in case they are equal
     * * <code>1</code> in case this object is greater than the object compared
     */
    @Override
    public int compareTo(Student o) {
        return name.compareTo(o.getName());
    }

    /**
     * Method used to get the name of the student
     *
     * @return name of the student
     */
    public String getName() {
        return name;
    }

    /**
     * Method used to set the name of the student
     *
     * @param name name of the student
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method used to get the list of admissible projects
     *
     * @return a list of admissible projects
     */
    public List<Project> getAdmissibleProjects() {
        return admissibleProjects;
    }

    /**
     * Method used to set the list of admissible projects
     *
     * @param admissibleProjects a list of admissible projects
     */
    public void setAdmissibleProjects(List<Project> admissibleProjects) {
        this.admissibleProjects = admissibleProjects;
    }

    /**
     * Method that returns a string of the current object
     *
     * @return a string representing the object
     */
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", admissibleProjects=" + admissibleProjects +
                '}';
    }
}
