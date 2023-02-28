package lab2.compulsory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 *
 * @author Adrian-Paul Bilba
 * @version %I%, %G%
 * @since 1.0
 */

public class Location {
    private static int totalNumberOfLocations;
    private int id;
    private String name;
    private LocationType locationType;
    private double x;
    private double y;
    private ArrayList<Location> neighbours;

    public Location(String name, LocationType locationType, double x, double y, ArrayList<Location> neighbours) {
        this.id = totalNumberOfLocations;
        this.name = name;
        this.locationType = locationType;
        this.x = x;
        this.y = y;
        this.neighbours = new ArrayList<>();
        if(neighbours != null) {
            this.neighbours = neighbours;
            for (Location currElement : neighbours) {
                currElement.addNeighbour(this);
            }
        }
        totalNumberOfLocations++;
    }

    @Override
    public String toString() {
        String retNeighbours = "";
        for(Location idx : neighbours){
            retNeighbours += idx.name + ", ";
        }
        if(retNeighbours.length() > 0)
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

    public static int getTotalNumberOfLocations() {
        return totalNumberOfLocations;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocationType getLocationType() {
        return locationType;
    }

    public void setLocationType(LocationType locationType) {
        this.locationType = locationType;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public List<Location> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(ArrayList<Location> neighbours) {
        this.neighbours = neighbours;
    }

    public void addNeighbour(Location neighbour){
        neighbours.add(neighbour);
        neighbour.getNeighbours().add(this);
    }
}
