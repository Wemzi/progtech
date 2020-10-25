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
                money-=house.getCost();
                house.sellHouse(this);
                }
                else
                {
                money-=house.getCost();
                house.setHasHouse();
                }
               }
          }
          else if(this != house.getOwner())
          {
          this.pay(house.getCost(),house.getOwner());
          }
    }

     public String toString()
    {
        return name + " strategy: Strict(I'm buying everything till I have money), money: " + this.getMoney();
    }
    
}
