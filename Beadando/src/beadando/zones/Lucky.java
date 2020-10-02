/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beadando.zones;
// xd

import beadando.players.Player;
import beadando.players.Tactical;

/**
 *
 * @author lkcsd
 */
public class Lucky extends Zone {

    public Lucky(int cost) {
        super(cost);
    }
    
    public void luckyZone(Player luckyone)
    {
        luckyone.changeMoney(this.getCost());
        if(luckyone instanceof Tactical)
        {
            ((Tactical)luckyone).setBoughtBefore(false);
            System.out.println("false");
        }
    }
    
    @Override
     public String toString()
    {
        return "Lucky zone, reward: " + this.cost;
    }
    
}
