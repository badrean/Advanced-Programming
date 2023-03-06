package lab2.homework;

import lab2.compulsory.*;

import java.util.ArrayList;
/**
 * Class that represents a particular location - gas city.
 * <p>
 * * @author Adrian-Paul Bilba
 * * @version %I%, %G%
 * * @since 1.0
 */
public class City extends Location {
    /**
     * population of the city
     */
    int population;

    /**
     * Constructor for particular location - city.
     *
     * @param name         name of the location
     * @param locationType type of the location
     * @param x            X coordinate of the location
     * @param y            Y coordinate of the location
     * @param neighbours   list of neighbours
     * @param population   city population
     * @see Location
     */
    City(String name, LocationType locationType, double x, double y, ArrayList<Location> neighbours, int population) {
        super(name, locationType, x, y, neighbours);
        this.population = population;
    }
}
