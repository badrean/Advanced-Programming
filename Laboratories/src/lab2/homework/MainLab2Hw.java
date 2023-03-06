package lab2.homework;

import lab2.compulsory.*;

/**
 * Class where the program starts running. It is used to show functionality of the methods and classes from
 * the lab 2 homework.
 *
 * @author Adrian-Paul Bilba
 * @version %I%, %G%
 * @since 1.0
 */
public class MainLab2Hw {
    /**
     * Main method where the program starts running and the classes from Lab2 Homework are tested.
     *
     * @param args Not used
     */
    public static void main(String[] args) {
        Map map = new Map();

        Location location0 = new City("Iasi", LocationType.CITY, 15.67, -17.8, null, 500000);
        Location location1 = new City("Botosani", LocationType.CITY, 3.67, -7.8, null, 15);
        Location location2 = new Airport("Benzinaria Mea", LocationType.AIRPORT, 1, 0, null, 4);
        Location location3 = new City("Paris", LocationType.CITY, -500, 500, null, 5000000);
        Location location4 = new GasStation("Parizer", LocationType.GAS_STATION, -123.66, 0.8, null, 4.9);
        Location location5 = new GasStation("Parizer", LocationType.GAS_STATION, -123.66, 0.8, null, 3.9);

        Road road0 = new Road("Strada Smecheriei", RoadType.EXPRESS, 190, 60, new Pair(location0, location1));
        Road road1 = new Road("Poteca Nume Frumos", RoadType.COUNTRY, 45, 90, new Pair(location0, location2));

        map.addLocation(location0);
        map.addLocation(location1);
        map.addLocation(location2);
        map.addLocation(location3);
        map.addLocation(location4);
        map.addLocation(location5);

        map.addRoad(road0);
        map.addRoad(road1);

        System.out.println(location0);
        System.out.println(location1);
        System.out.println(location2);

        System.out.println(road0);
        System.out.println(road1);
        System.out.println(location4.equals(location5));
        System.out.println(location3.equals(location5));

        System.out.println(map);
        System.out.println(map.checkLocationAccessibility());
        System.out.println(map.checkIfProblemIsValid());
    }
}
