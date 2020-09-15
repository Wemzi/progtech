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
public class realEstate extends Zone {
    private boolean isSold = false;
    private boolean hasHouse = false;
    public realEstate() {
        super(0);
    }

    public boolean isIsSold() {
        return isSold;
    }

    public boolean isHasHouse() {
        return hasHouse;
    }

    public void sellHouse() {
        this.isSold = true;
        
    }

    public void setHasHouse() {
        this.hasHouse = true;
    }
    
    
    
}
