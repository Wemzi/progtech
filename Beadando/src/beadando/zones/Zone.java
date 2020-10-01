
package beadando.zones;
/**
 * helo
 * @author lkcsd
 */
public class Zone {
    protected int cost;
    public int zoneID;
    public static int zoneNumber = 0;

    public Zone(int cost) {
        this.cost = cost;
        zoneID=zoneNumber++;
    }

    public int getZoneID() {
        return zoneID;
    }
    
    public int getCost() {
        return cost;
    }
}
