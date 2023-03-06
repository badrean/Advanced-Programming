package lab2.compulsory;
import java.lang.Math;
/**
 * Class that manages the creation of a road element.
 *
 * @author Adrian-Paul Bilba
 * @version %I%, %G%
 * @since 1.0
 */
public class Road {
    private String name;
    private RoadType roadType;
    private double length;
    private int speedLimit;
    private Pair<Location, Location> connectedLocations;

    /**
     * Constructor that creates the road element given the parameters.
     * In case the length is smaller than the euclidean distance, the road is not constructed and the program
     * exits.
     *
     * @param name                  The name of the road
     * @param roadType              The type of the road
     * @param length                The length of the road in km
     * @param speedLimit            The speed limit of the road in km/h
     * @param connectedLocations    The locations that the road connects
     * @see   Location
     * @see   #calculateEuclideanDistance(Location, Location)
     */
    public Road(String name, RoadType roadType, double length, int speedLimit, Pair<Location, Location> connectedLocations) {
        this.name = name;
        double euclideanDistance = calculateEuclideanDistance(connectedLocations.getFirst(), connectedLocations.getSecond());
        if(length < euclideanDistance){
            System.out.println("Length of road doesn't have a valid length");
            System.exit(1);
        }
        this.roadType = roadType;
        this.length = length;
        this.speedLimit = speedLimit;
        this.connectedLocations = connectedLocations;
        connectedLocations.getFirst().addNeighbour(connectedLocations.getSecond());
    }

    /**
     * Method that calculates the euclidean for the coordinates of 2 given locations.
     *
     * @param first     First location to get the coordinates from
     * @param second    Second location to get the coordinates from
     * @return          The euclidean distance
     */
    private double calculateEuclideanDistance(Location first, Location second){
        double x1 = first.getX();
        double x2 = second.getX();
        double y1 = first.getY();
        double y2 = second.getY();

        return Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
    }

    /**
     * Returns the name of the road.
     *
     * @return    Name of the road
     */
    public String getName(){ return name; }

    /**
     * Sets the name of the road.
     *
     * @param name   The name to be set
     */
    public void setName(String name){ this.name = name; }

    /**
     * Returns the road type.
     *
     * @return   The road type
     * @see      RoadType
     */
    public RoadType getRoadType() {
        return roadType;
    }

    /**
     * Sets the road type.
     *
     * @param roadType   The type of the road to be set.
     * @see   RoadType
     */
    public void setRoadType(RoadType roadType) {
        this.roadType = roadType;
    }

    /**
     * Returns the length of the road in km.
     *
     * @return    Length of the road
     */
    public double getLength() {
        return length;
    }

    /**
     * Sets the length of the road
     *
     * @param length   Length to be set
     */
    public void setLength(double length) {
        this.length = length;
    }

    /**
     * Gets the speed limit of the road in km/h
     *
     * @return    The speed limit
     */
    public int getSpeedLimit() {
        return speedLimit;
    }

    /**
     * Sets the speed limit of the road
     *
     * @param speedLimit   The speed limit
     */
    public void setSpeedLimit(int speedLimit) {
        this.speedLimit = speedLimit;
    }

    /**
     * Get the connected locations
     *
     * @return   The connected locations
     * @see Pair
     */
    public Pair<Location, Location> getConnectedLocations() {
        return connectedLocations;
    }

    /**
     * Set the locations that the roads connects
     *
     * @param connectedLocations    the locations that the road connects
     * @see Pair
     */
    public void setConnectedLocations(Pair<Location, Location> connectedLocations) {
        this.connectedLocations = connectedLocations;
    }

    /**
     * Method that transforms the object into a string
     *
     * @return The string representing the object
     */
    @Override
    public String toString() {
        String retValue = new String(connectedLocations.getFirst().getName() + ", " +
                                     connectedLocations.getSecond().getName());

        return "Road{" +
                "roadType=" + roadType +
                ", length=" + length +
                ", speedLimit=" + speedLimit +
                ", connectedLocations=" + "( " + retValue + " )" +
                '}';
    }

    /**
     * Method used to check if a Road is equal to another.
     * First we check if the object is compared to itself, which should always return true.
     * Then we check if the object is of the same type as this object.
     * In case the name of both objects matches, the lengths are compared. In case lengths are equal,
     * the locations connected are checked. In case the roads also connect the same locations, they are
     * equal.
     *
     * @param obj   The object to be compared
     * @return      <code>true</code> If the objects are equal. <br>
     *              <code>false</code> Otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if(obj == this){
            return true;
        }
        if(!(obj instanceof Road)){
            return false;
        }
        Road auxiliary = (Road) obj;

        if(auxiliary.getName().equals(this.getName())){
            if(auxiliary.getLength() == this.getLength()){
                if(auxiliary.getConnectedLocations().getFirst().equals(this.getConnectedLocations().getFirst())  &&
                   auxiliary.getConnectedLocations().getSecond().equals(this.getConnectedLocations().getSecond()) ){
                    return true;
                }
            }
        }
        return false;
    }
}
