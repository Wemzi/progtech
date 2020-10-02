/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beadando.zones;

import beadando.players.Player;
import beadando.players.Tactical;

/**
 *
 * @author lkcsd
 */
public class Service extends Zone {

    public Service(int cost) {
        super(cost);
    }
    
     public void serviceZone(Player notluckyone)
    {
        notluckyone.changeMoney(-1*this.getCost());
        if(notluckyone instanceof Tactical)
        {
            ((Tactical) notluckyone).setBoughtBefore(false);
        }
    }
    
    @Override
    public String toString()
    {
        return "Service zone, cost: " + this.cost;
    }
    
}
