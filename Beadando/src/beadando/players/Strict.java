/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beadando.players;

import beadando.zones.Property;

/**
 *
 * @author lkcsd
 */
public class Strict extends Player {

    public Strict(String name) {
        super(name);
    }
    
    @Override
    public boolean canIBuy(Property house)
    {
     if(house.isIsSold() && !house.isHasHouse())
    {
        return money >= house.getCost();
    }
    else
    {
        return money >= house.getCost();
    }
    }
    
       public String toString()
    {
        return name + " strategy: Strict, money: " + this.getMoney();
    }
    
}
