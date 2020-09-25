/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beadando.zones;

import beadando.zones.Zone;

/**
 *
 * @author lkcsd
 */
public class Service extends Zone {

    public Service(int cost) {
        super(cost);
    }
    
    @Override
    public String toString()
    {
        return "Service zone, cost: " + this.cost;
    }
    
}
