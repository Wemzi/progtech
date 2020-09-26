/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beadando;

import beadando.mechanics.Gameworks;
import beadando.players.Careful;
import beadando.players.Player;
import beadando.players.Strict;
import beadando.players.Tactical;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author lkcsdvd
 */
public class UnitTesting {
    @Test
    public void creatingGameworks()
    {
        ArrayList<Player> players = new ArrayList<>();
        players.add(new Strict("Zoltan"));
        players.add(new Tactical("Rudolf"));
        players.add(new Careful("David"));
        players.add(new Strict("Joska"));
        players.add(new Tactical("Koppany"));
        players.add(new Careful("Richard"));
        Gameworks test1 = new Gameworks("zones.txt",players);
        assertEquals(test1.players.size(),6);
        assertEquals(test1.field.size(),15);
        
    }
    
    @Test
     public void properEnd()
    {
        ArrayList<Player> players = new ArrayList<>();
        players.add(new Strict("Zoltan"));
        players.add(new Tactical("Rudolf"));
        players.add(new Careful("David"));
        players.add(new Strict("Joska"));
        players.add(new Tactical("Koppany"));
        players.add(new Careful("Richard"));
        Gameworks test2 = new Gameworks("zones.txt",players);
        test2.playMatch();
        assertEquals(test2.players.size(),1);
        assertEquals(test2.field.size(),15);
    }
     
    @Test
    public void noWinner() throws FileNotFoundException
    {
        ArrayList<Player> players = new ArrayList<>();
        players.add(new Strict("Zoltan"));
        players.add(new Tactical("Rudolf"));
        players.add(new Careful("David"));
        players.add(new Strict("Joska"));
        players.add(new Tactical("Koppany"));
        players.add(new Careful("Richard"));
        Gameworks test3 = new Gameworks("zones.txt",players);
        assertEquals(test3.playMatchnoDice("dice.txt"),2);
    }
    
    
    
    @Test
    public void worksTheSameEveryTime() throws FileNotFoundException
    {
        ArrayList<Player> players = new ArrayList<>();
        players.add(new Strict("Zoltan"));
        players.add(new Tactical("Rudolf"));
        players.add(new Careful("David"));
        players.add(new Strict("Joska"));
        players.add(new Tactical("Koppany"));
        players.add(new Careful("Richard"));
        Gameworks test4 = new Gameworks("zones.txt",players);
        assertEquals(test4.playMatchnoDice("dice2.txt"),0);
        assertEquals(test4.players.get(0).name,"Rudolf");
        assertEquals(test4.players.get(0).money,5650);
        assertEquals(test4.players.get(0).getHouseTour().size(),2);
        
    }
    
     @Test
    public void worksTheSameEveryTime2() throws FileNotFoundException
    {
        ArrayList<Player> players = new ArrayList<>();
        players.add(new Strict("Zoltan"));
        players.add(new Tactical("Rudolf"));
        players.add(new Careful("David"));
        players.add(new Strict("Joska"));
        players.add(new Tactical("Koppany"));
        players.add(new Careful("Richard"));
        Gameworks test5 = new Gameworks("zones.txt",players);
        assertEquals(test5.playMatchnoDice("dice3.txt"),0);
        assertEquals(test5.players.get(0).name,"Richard");
        assertEquals(test5.players.get(0).money,2750);
        assertEquals(test5.players.get(0).getHouseTour().size(),1);
        
    }
    
     @Test(expected=FileNotFoundException.class)
    public void noDice() throws FileNotFoundException
    {
        ArrayList<Player> players = new ArrayList<>();
        players.add(new Strict("Zoltan"));
        players.add(new Tactical("Rudolf"));
        players.add(new Careful("David"));
        players.add(new Strict("Joska"));
        players.add(new Tactical("Koppany"));
        players.add(new Careful("Richard"));
        Gameworks test6 = new Gameworks("zones.txt",players);
        assertEquals(test6.playMatchnoDice("dice4.txt"),2);
    }
        
    public void creatingGameworks()
    {
        ArrayList<Player> players = new ArrayList<>();
        players.add(new Strict("Zoltan"));
        Gameworks test1 = new Gameworks("zones.txt",players);
        assertEquals(test1.players.size(),1);
        assertEquals(test1.field.size(),15);
        assertEquals(test1.field.size(),15);
        
    }        
    
    
    
}
