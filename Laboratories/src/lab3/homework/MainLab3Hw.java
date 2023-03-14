package lab3.homework;

import java.time.LocalDate;

/**
 * Class used as main point of access for the application of Lab3.Homework
 *
 * @author adrian
 * @since 1.0
 */
public class MainLab3Hw {
    /**
     * Main method to enter the application.
     *
     * @param args Not used
     */
    public static void main(String[] args) {
        Network network = new Network();

        Person person0 = new Person("Darius", LocalDate.of(1998, 10, 3), false);
        Person person1 = new Person("Adrian", LocalDate.of(1989, 1, 25), true);
        Programmer programmer0 = new Programmer("Stelian", LocalDate.of(1967, 8, 26), new String[]{"C++", "Java"});
        Programmer programmer1 = new Programmer("Raul", LocalDate.of(1968, 8, 1), new String[]{"C#", "Java", "Python"});
        Designer designer0 = new Designer("Marcel", LocalDate.of(1999, 12, 26), new String[]{"AdobeIllustrator"});
        Designer designer1 = new Designer("Dan", LocalDate.of(2001, 6, 18), new String[]{"AdobeIllustrator", "AdobePhotoshop"});
        Company company0 = new Company("WindowsInc", 10);
        Company company1 = new Company("BitDefender", 500);

        Person person_bad = new Person("Darius", LocalDate.of(1992, 3, 3), true);

        /* Adding nodes in the network */
        network.addNode(person0);
        network.addNode(person1);
        network.addNode(programmer0);
        network.addNode(programmer1);
        network.addNode(designer0);
        network.addNode(designer1);
        network.addNode(company0);
        network.addNode(company1);
        network.addNode(person_bad);

        /* Establishing friendships */
        person0.followFriend(person0);
        person0.followFriend(person1);
        person0.followFriend(person1);
        person0.followFriend(programmer1);
        person1.followFriend(person0);
        person1.followFriend(programmer0);
        person1.followFriend(programmer1);
        person1.followFriend(designer0);
        programmer0.followFriend(programmer1);
        programmer1.followFriend(programmer0);
        designer0.followFriend(designer1);
        company0.followFriend(company1);
        company1.followFriend(company0);

        System.out.println(network);

        /* Sorting alphabetically */
        network.getNetworkNodes().sort((Node o1, Node o2) -> {
            String auxiliaryName = o2.getName();
            String thisName = o1.getName();
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
        });

        System.out.println(network);

        /* Sorting by the number of friends */
        network.getNetworkNodes().sort(new CompareFriendsNumber());
        System.out.println();
        System.out.println(network);
    }
}
