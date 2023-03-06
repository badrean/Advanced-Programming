package lab2.homework;

import lab2.compulsory.Location;
import lab2.compulsory.Road;

import java.util.*;

/**
 * Map is the class that manages the storage and access of the current existent locations and roads.
 *
 * @author Adrian-Paul Bilba
 * @version %I%, %G%
 * @since 1.0
 */
public class Map {
    /**
     * Vector that stores the current locations
     */
    private Vector<Location> storedLocations;
    /**
     * Vector that stores the current roads
     */
    private Vector<Road> storedRoads;

    /**
     * Constructor that stores the current locations and roads.
     *
     * @see Road
     * @see Location
     */
    public Map() {
        storedLocations = new Vector<Location>();
        storedRoads = new Vector<Road>();
    }

    /**
     * Gets the stored locations
     *
     * @return The list of stored locations
     */
    public Vector<Location> getStoredLocations() {
        return storedLocations;
    }

    /**
     * Gets the stored roads
     *
     * @return The list of stored roads
     */
    public Vector<Road> getStoredRoads() {
        return storedRoads;
    }

    /**
     * Adds a location
     *
     * @param location location to be added
     */
    public void addLocation(Location location) {
        storedLocations.add(location);
    }

    /**
     * Removes a stored location
     *
     * @param location location to be removed
     */
    public void removeLocation(Location location) {
        storedLocations.remove(location);
    }

    /**
     * Adds a road
     *
     * @param road road to be added
     */
    public void addRoad(Road road) {
        storedRoads.add(road);
    }

    /**
     * Removes a stored road
     *
     * @param road road to be removed
     */
    public void removeRoad(Road road) {
        storedRoads.remove(road);
    }

    /**
     * Method that transforms the object into a string
     *
     * @return The string representing the object
     */
    @Override
    public String toString() {
        var retString = new StringBuilder();
        retString.append("Map:\n");
        retString.append("Locations:\n");
        for (Location iterator : storedLocations) {
            retString.append("\t" + iterator.getName() + "\n");
        }
        retString.append("Roads:\n");
        for (Road iterator : storedRoads) {
            retString.append("\t" + iterator.getName() + "\n");
        }
        return retString.toString();
    }

    /**
     * Methods that checks if all the locations are accessible given the current roads.
     *
     * @return <code>true</code> If all locations are accessible. <br>
     * <code>false</code> Otherwise.
     * @see Road
     * @see Location
     * @see Location#getId()
     */
    public boolean checkLocationAccessibility() {
        boolean[] visited = new boolean[storedLocations.size()];
        for (boolean iterator : visited) {
            iterator = false;
        }

        Queue<Location> connectedLocations = new LinkedList<Location>();
        connectedLocations.add(storedLocations.firstElement());
        while (!(connectedLocations.isEmpty())) {
            List<Location> currentLocationNeighbours = connectedLocations.peek().getNeighbours();
            for (Location iterator : currentLocationNeighbours) {
                if (!visited[iterator.getId()]) {
                    connectedLocations.add(iterator);
                }
            }
            visited[connectedLocations.peek().getId()] = true;
            connectedLocations.remove();
        }

        for (boolean iterator : visited) {
            if (!iterator) {
                return false;
            }
        }
        return true;
    }

    /**
     * Method that checks if the problem is valid. The problem is valid if there are two same roads
     * or locations.
     *
     * @return <code>true</code> If the problem is valid. <br>
     * <code>false</code> Otherwise.
     * @see Road#equals(Object)
     * @see Location#equals(Object)
     */
    public boolean checkIfProblemIsValid() {
        Location lastLocation = null;
        for (Location iterator : storedLocations) {
            if (lastLocation != null) {
                if (iterator.equals(lastLocation)) {
                    System.out.println("Problem is not valid. Two locations are the same.");
                    return false;
                }
            }
            lastLocation = iterator;
        }
        Road lastRoad = null;
        for (Road iterator : storedRoads) {
            if (lastRoad != null) {
                if (iterator.equals(lastRoad)) {
                    System.out.println("Problem is not valid. Two roads are the same.");
                    return false;
                }
            }
            lastRoad = iterator;
        }

        return true;
    }
}
