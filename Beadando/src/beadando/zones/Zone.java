
package beadando.zones;
/**
 *
 * @author lkcsd
 */
public class Zone {
    protected int cost;
    public static int zoneID;
    public static int zoneNumber = 0;

    public Zone(int cost) {
        this.cost = cost;
        zoneID=zoneNumber++;
    }

    public static int getZoneID() {
        return zoneID;
    }
    
    public int getCost() {
        return cost;
    }
}
