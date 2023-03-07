package lab3.compulsory;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainLab3 {
    public static void main(String[] args) {
        List<Node> network = new ArrayList<Node>();

        Node node0 = new Person("Marius");
        Node node1 = new Person("Cornel");
        Node node2 = new Person("Alex");
        Node node3 = new Company("Black Sea");
        Node node4 = new Company("JetBrains");
        Node node5 = new Company("Amazon");

        network.add(node0);
        network.add(node1);
        network.add(node2);
        network.add(node3);
        network.add(node4);
        network.add(node5);

        System.out.println(network);

        Person test1;
        Person test2;
        test1 = (Person)node0;
        test2 = (Person)node2;

        System.out.println(test2.compareTo(test1));

    }
}
