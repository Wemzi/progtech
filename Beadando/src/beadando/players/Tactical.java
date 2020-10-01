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
public class Tactical extends Player {
    
    private boolean boughtBefore=false;
    
    public Tactical(String name)
    {
        super(name);
    }

    public boolean isBoughtBefore() {
        return boughtBefore;
    }

    public void setBoughtBefore(boolean boughtBefore) {
        this.boughtBefore = boughtBefore;
    }
    
    @Override
    public boolean canIBuy(Property house)
    {
        if(house.isIsSold() && !house.isHasHouse())
        {
            return money >= house.getCost() && boughtBefore;
        }
        else
        {
            return money >= house.getCost() && boughtBefore;
        }
    }
    
    @Override
    public void buyHouse(Property house)
    {
         if(!house.isHasHouse())
        {
        houseTour.add(house);
        house.sellHouse(this);
        money-=1000;
        }
        else
        {
        house.setHasHouse();
        money -= 4000;
        }
        boughtBefore=true;
    }
    
    public String toString()
    {
        return name + " strategy: Tactical, money: " + this.getMoney(); 
    }
    
}
