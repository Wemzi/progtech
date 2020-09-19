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
public class Player {
    public int money=10000;
    public ArrayList<Property> houseTour = new ArrayList<>();
    public String name;
    public int position=0;
    public Player(String name)
    {
        this.name=name;
    }
    
    public void step(int diceNumber,int fieldsize)
    {
        position+=diceNumber;
        position = position%(fieldsize);
    }
    
    public void buyArea (Property house)
    {
        houseTour.add(house);
        house.sellHouse(this);
    }
    
    public void buyHouse (Property house)
    {
        house.setHasHouse();   
    }
    
    public String toStringWinner()
            {
                return "The winner is:" + name + " who has " + money + "cash and these properties: " +
                        this.getHouseTour().toString();
            }
    
    public int getMoney() {
        return money;
    }

    public ArrayList<Property> getHouseTour() {
        return houseTour;
    }
    
    
}
