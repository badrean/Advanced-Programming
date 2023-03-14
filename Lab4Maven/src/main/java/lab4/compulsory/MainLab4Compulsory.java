package lab4.compulsory;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Class used as main point of access for the application of Lab4.Compulsory
 *
 * @author adrian
 * @since 1.0
 */
public class MainLab4Compulsory {
    /**
     * Main method to enter the application.
     *
     * @param args Not used
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        List<Project> projects = Arrays.asList(new Project("WienerMobil"), new Project("Alpaca"), new Project("RottenTomato"));
        List<Student> students = Arrays.asList(
                new Student("Marius", projects),
                new Student("Andrei", projects.subList(0, 2)),
                new Student("Tudor", projects.subList(0, 1))
        );
        System.out.println("List values:");
        System.out.println(students);
        System.out.println(projects + "\n");

        LinkedList<Student> studentsLinkedList = students.stream().collect(Collectors.toCollection(LinkedList::new));
        TreeSet<Project> projectsTreeSet = projects.stream().collect(Collectors.toCollection(TreeSet::new));

        Collections.sort(studentsLinkedList);
        System.out.println(studentsLinkedList);
        System.out.println(projectsTreeSet);

    }
}
