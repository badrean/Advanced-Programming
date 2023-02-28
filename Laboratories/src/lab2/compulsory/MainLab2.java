package lab2.compulsory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MainLab2 {
    public static void main(String[] args) {

        //intrebare: cum putem sa dam ca argument un array list fara sa ii facem new?
        //ex: Location location2 = new Location("Botosani", LocationType.CITY, 3.67, -7.8, {location1});
        Location location1 = new Location("Iasi", LocationType.CITY, 15.67, -17.8, null);
        Location location2 = new Location("Botosani", LocationType.CITY, 3.67, -7.8, null);
        Location location3 = new Location("Benzinaria Mea", LocationType.GAS_STATION, 1, 0, null);
        Location location4 = new Location("Paris", LocationType.CITY, -500, 500, null);
        Location location5 = new Location("Parizer", LocationType.HYPERMARKET, -123.66, 0.8, null);

        Road road1 = new Road(RoadType.EXPRESS, 19.30, 60, new Pair(location1, location2));
        Road road2 = new Road(RoadType.COUNTRY, 45, 90, new Pair(location1, location3));

        location1.addNeighbour(location2);
        location1.addNeighbour(location3);

        System.out.println(location1);
        System.out.println(location2);
        System.out.println(location3);

        System.out.println(road1);
        System.out.println(road2);
    }
}
