package lab2.compulsory;
/**
 *
 *
 * @author Adrian-Paul Bilba
 * @version %I%, %G%
 * @since 1.0
 */
public class Road {
    private RoadType roadType;
    private double length;
    private int speedLimit;
    private Pair<Location, Location> connectedLocations;

    public Road(RoadType roadType, double length, int speedLimit, Pair<Location, Location> connectedLocations) {
        this.roadType = roadType;
        this.length = length;
        this.speedLimit = speedLimit;
        this.connectedLocations = connectedLocations;
    }

    public RoadType getRoadType() {
        return roadType;
    }

    public void setRoadType(RoadType roadType) {
        this.roadType = roadType;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public int getSpeedLimit() {
        return speedLimit;
    }

    public void setSpeedLimit(int speedLimit) {
        this.speedLimit = speedLimit;
    }

    public Pair<Location, Location> getConnectedLocations() {
        return connectedLocations;
    }

    public void setConnectedLocations(Pair<Location, Location> connectedLocations) {
        this.connectedLocations = connectedLocations;
    }

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
}
