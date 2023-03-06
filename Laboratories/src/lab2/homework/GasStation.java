package lab2.homework;

import lab2.compulsory.*;

import java.util.ArrayList;

/**
 * Class that represents a particular location - gas station.
 * <p>
 * * @author Adrian-Paul Bilba
 * * @version %I%, %G%
 * * @since 1.0
 */
public class GasStation extends Location {
    /**
     * price of the gas
     */
    double gasPrice;

    /**
     * Constructor for the particular location - gas station
     *
     * @param name         name of the location
     * @param locationType type of the location
     * @param x            X coordinate of the location
     * @param y            Y coordinate of the location
     * @param neighbours   list of neighbours
     * @param gasPrice     gas price
     * @see Location
     */
    GasStation(String name, LocationType locationType, double x, double y, ArrayList<Location> neighbours, double gasPrice) {
        super(name, locationType, x, y, neighbours);
        this.gasPrice = gasPrice;
    }
}
