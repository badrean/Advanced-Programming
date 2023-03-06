package lab2.compulsory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Location is the class that manages the creation of
 * location.
 *
 * @author Adrian-Paul Bilba
 * @version %I%, %G%
 * @since 1.0
 */

public class Location {
    /**
     * Static variable that keeps track of the total number of locations.
     */
    private static int totalNumberOfLocations;
    /**
     * Identifier for location.
     */
    private int id;
    /**
     * Name of the location.
     */
    private String name;
    /**
     * Type of the location.
     *
     * @see LocationType
     */
    private LocationType locationType;
    /**
     * The x coordinate of the location.
     */
    private double x;
    /**
     * The y coordinate of the location.
     */
    private double y;
    /**
     * Array that stores the neighbours of the location.
     */
    private ArrayList<Location> neighbours;

    /**
     * Class constructor <br>
     * Creates a location given the name, location type, coordinates and a list of neighbours.
     *
     * @param name         The name of the location
     * @param locationType Type of the location
     * @param x            The x coordinate
     * @param y            The y coordinate
     * @param neighbours   The list of adjacent locations
     * @see LocationType
     * @see #addNeighbour(Location)
     * @since 1.0
     */
    public Location(String name, LocationType locationType, double x, double y, ArrayList<Location> neighbours) {
        this.id = totalNumberOfLocations;
        this.name = name;
        this.locationType = locationType;
        this.x = x;
        this.y = y;
        this.neighbours = new ArrayList<Location>();
        if (neighbours != null) {
            this.neighbours = neighbours;
            for (Location currElement : neighbours) {
                currElement.addNeighbour(this);
            }
        }
        totalNumberOfLocations++;
    }

    /**
     * Method used to check if a Location is equal to another.
     * First we check if the object is compared to itself, which should always return true.
     * Then we check if the object is of the same type as this object.
     * In case the name of both objects matches, the X and Y coordinates are compared. In case both coordinates
     * are equal, the Locations are equal.
     *
     * @param obj The object to be compared
     * @return <code>true</code> if the objects are equal <br>
     * <code>false</code> otherwise
     * @see #getName()
     * @see #getX()
     * @see #getY()
     * @since 1.0
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Location)) {
            return false;
        }
        Location auxiliary = (Location) obj;

        if (auxiliary.getName().equals(this.getName())) {
            if ((auxiliary.getX() == this.getX()) && (auxiliary.getY() == this.getY())) {
                return true;
            }
        }

        return false;
    }

    /**
     * This method returns a string containing the info of the location
     *
     * @return Returns a String which contains info about the location
     * @since 1.0
     */
    @Override
    public String toString() {
        String retNeighbours = "";
        for (Location idx : neighbours) {
            retNeighbours += idx.name + ", ";
        }
        if (retNeighbours.length() > 0)
            retNeighbours = retNeighbours.substring(0, retNeighbours.length() - 2);

        return "Location{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", locationType=" + locationType +
                ", x=" + x +
                ", y=" + y +
                ", neighbours=( " + retNeighbours + " )" +
                '}';
    }

    /**
     * Gets total number of locations
     *
     * @return total number of locations
     */
    public static int getTotalNumberOfLocations() {
        return totalNumberOfLocations;
    }

    /**
     * Returns the id of the location
     *
     * @return id of the location
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the id of the location
     *
     * @param id id to be set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the name of the location
     *
     * @return name of the location
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the location
     *
     * @param name name to be set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the location type
     *
     * @return the type of the location
     * @see LocationType
     */
    public LocationType getLocationType() {
        return locationType;
    }

    /**
     * Sets the type of the location
     *
     * @param locationType type of the location
     */
    public void setLocationType(LocationType locationType) {
        this.locationType = locationType;
    }

    /**
     * Returns the X coordinate
     *
     * @return X coordinate
     */
    public double getX() {
        return x;
    }

    /**
     * Sets the X coordinate
     *
     * @param x X coordinate to be set
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Returns the Y coordinate
     *
     * @return Y coordinate
     */
    public double getY() {
        return y;
    }

    /**
     * Sets the Y coordinate
     *
     * @param y Y coordinate to be set
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Returns a list of the neighbours
     *
     * @return list of neighbours
     */
    public List<Location> getNeighbours() {
        return neighbours;
    }

    /**
     * Sets the neighbours
     *
     * @param neighbours neighbours to be set
     */
    public void setNeighbours(ArrayList<Location> neighbours) {
        this.neighbours = neighbours;
    }

    /**
     * Method used to add new locations that are adjacent to the current one.
     *
     * @param neighbour The location that is adjacent to the current location
     * @since 1.0
     */
    public void addNeighbour(Location neighbour) {
        neighbours.add(neighbour);
        neighbour.getNeighbours().add(this);
    }
}
