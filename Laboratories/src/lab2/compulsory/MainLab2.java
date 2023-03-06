package lab2.compulsory;

/**
 * Class where the program starts running. It is used to show functionality of the methods and classes from
 * the lab 2 compulsory.
 *
 * @author Adrian-Paul Bilba
 * @version %I%, %G%
 * @since 1.0
 */
public class MainLab2 {
    /**
     * Main method where the program starts running and the classes from Lab2 Compulsory are tested.
     *
     * @param args Not used
     */
    public static void main(String[] args) {

        //intrebare: cum putem sa dam ca argument un array list fara sa ii facem new?
        //ex: Location location2 = new Location("Botosani", LocationType.CITY, 3.67, -7.8, {location1});
        Location location0 = new Location("Iasi", LocationType.CITY, 15.67, -17.8, null);
        Location location1 = new Location("Botosani", LocationType.CITY, 3.67, -7.8, null);
        Location location2 = new Location("Benzinaria Mea", LocationType.GAS_STATION, 1, 0, null);
        Location location3 = new Location("Paris", LocationType.CITY, -500, 500, null);
        Location location4 = new Location("Parizer", LocationType.HYPERMARKET, -123.66, 0.8, null);
        Location location5 = new Location("Parizer", LocationType.HYPERMARKET, -123.66, 0.8, null);

        Road road0 = new Road("Strada Smecheriei", RoadType.EXPRESS, 190, 60, new Pair(location0, location1));
        Road road1 = new Road("Poteca Nume Frumos", RoadType.COUNTRY, 45, 90, new Pair(location0, location2));

        location0.addNeighbour(location1);
        location0.addNeighbour(location2);

        System.out.println(location0);
        System.out.println(location1);
        System.out.println(location2);

        System.out.println(road0);
        System.out.println(road1);
        System.out.println(location4.equals(location5));
        System.out.println(location3.equals(location5));
    }
}
