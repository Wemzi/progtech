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
            return money >= house.getCost() && !boughtBefore;
        }
        else
        {
            return money >= house.getCost() && !boughtBefore;
        }
    }
    
    @Override
    public void houseZone(Property house)
    {
        if(!house.isIsSold())
          {
              if(this.canIBuy(house))
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
          }
          else if(this != house.getOwner())
          {
          this.pay(house.getCost(),house.getOwner());
          boughtBefore=false;
          }
        
    }
    
    public String toString()
    {
        return name + " strategy: Tactical(I'm missing every second buying opportunity), money: " + this.getMoney(); 
    }
    
}
