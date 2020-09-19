/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beadando.zones;
import beadando.players.Player;

/**
 *
 * @author lkcsd
 */
public class Property extends Zone {
    private boolean isSold = false;
    private boolean hasHouse = false;
    private Player owner = null;
    
    public Property() {
        super(0);
    }

    public boolean isIsSold() {
        return isSold;
    }

    public boolean isHasHouse() {
        return hasHouse;
    }

    public void sellHouse(Player buyer) {
        this.isSold = true;
        owner = buyer;
    }

    public Player getOwner() {
        return owner;
    }

    public void setHasHouse() {
        this.hasHouse = true;
    }
    
    @Override
     public String toString()
    {
        if(isSold && hasHouse)
        {
            return "bought area, and built house on field:" + this.getZoneID();
        }
        else if(isSold)
        {
            return "bought area, but no built house on field:" + this.getZoneID();
        }
        else
        {
            return "Property zone";
        }
        
    }
    
    
}
