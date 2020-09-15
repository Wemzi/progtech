/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beadando.players;
import beadando.zones.realEstate;
import java.util.ArrayList;

/**
 *
 * @author lkcsd
 */
public class Player {
    private int money=10000;
    private ArrayList<realEstate> houseTour = new ArrayList<>();
    
    public int getMoney() {
        return money;
    }

    public ArrayList<realEstate> getHouseTour() {
        return houseTour;
    }
    
    
}
