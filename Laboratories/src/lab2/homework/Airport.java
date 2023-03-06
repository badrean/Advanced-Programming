package lab2.homework;

import lab2.compulsory.*;


import java.util.ArrayList;
/**
 * Class that represents a particular location - gas airport.
 * <p>
 * * @author Adrian-Paul Bilba
 * * @version %I%, %G%
 * * @since 1.0
 */
public final class Airport extends Location{
    /**
     * nubmer of terminals
     */
    int numberOfTerminals;

    /**
     * Constructor for particular location - airport.
     *
     * @param name              name of the location
     * @param locationType      type of the location
     * @param x                 X coordinate of the location
     * @param y                 Y coordinate of the location
     * @param neighbours        list of neighbours
     * @param numberOfTerminals number of terminals
     * @see Location
     */
    Airport(String name, LocationType locationType, double x, double y, ArrayList<Location> neighbours, int numberOfTerminals){
        super(name, locationType, x, y, neighbours);
        this.numberOfTerminals = numberOfTerminals;
    }
}
