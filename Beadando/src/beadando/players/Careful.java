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
public class Careful extends Player {

    public Careful(String name) {
        super(name);
    }

    
    @Override
    public boolean canIBuy(Property house)
    {
    if(house.isIsSold() && !house.isHasHouse())
    {
        return money >= house.getCost() * 2;
    }
    else
    {
        return money >= house.getCost() * 2;
    }
    }
        public String toString()
    {
        return name + " strategy: Careful (I'm only buying if i have twice as much money) money: " + this.getMoney();
    }
   
    
}
