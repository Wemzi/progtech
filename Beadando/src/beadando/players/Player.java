/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beadando.players;
import beadando.zones.Property;
import java.util.ArrayList;

/**
 *
 * @author lkcsd
 */
abstract public class Player {
    protected int money=10000;
    public ArrayList<Property> houseTour = new ArrayList<>();
    public String name;
    public int position=0;
    public Player(String name)
    {
        this.name=name;
    }
    
    /** a léptetés metódusa, így vált mezőt a játékos, amelybe implementáltam a moduló osztás segítségével a pálya kerek jellegét is. */
    public void step(int diceNumber,int fieldsize)
    {
        position+=diceNumber;
        position = position%(fieldsize);
    }
    
    public void houseZone(Property house)
    {
            if(!house.isIsSold() && this.canIBuy(house))
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
                }
            else if(this != house.getOwner() && house.getOwner()!=null)
            {
            this.pay(house.getCost(),house.getOwner());
            }
    }
    
    
    /** az utolsó sora a program lefutásának, ahol kiiratjuk, ki a nyertes, és a tulajdonait.*/
    public String toStringWinner()
            {
                return "The winner is:" + name + " who has " + money + "cash and these properties: " +
                        this.getHouseTour().toString();
            }
    
    public int getMoney() {
        return money;
    }
    
    public void changeMoney(int change)
    {
        money+=change;
    }
    
    abstract public boolean canIBuy(Property house);
    
    public void pay(int amount,Player luckyone)
    {
        this.money-=amount;
        luckyone.money+=amount;
    }

    public ArrayList<Property> getHouseTour() {
        return houseTour;
    }
    
    
}
