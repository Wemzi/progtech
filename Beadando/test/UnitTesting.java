/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import beadando.mechanics.Gameworks;
import beadando.players.Player;
import beadando.players.Strict;
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
        Gameworks test1 = new Gameworks("zones.txt","players.txt");
        assertEquals(test1.players.size(),6);
        assertEquals(test1.field.size(),15);
        
    }
    
    @Test
     public void properEnd()
    {
        Gameworks test2 = new Gameworks("zones.txt","players.txt");
        test2.playMatch();
        assertEquals(test2.players.size(),1);
        assertEquals(test2.field.size(),15);
    }
     
    @Test
    public void noWinner() throws FileNotFoundException
    {
        Gameworks test3 = new Gameworks("zones.txt","players.txt");
        assertEquals(test3.playMatchnoDice("dice.txt"),2);
    }
    
    
    
    @Test
    public void worksTheSameEveryTime() throws FileNotFoundException
    {

        Gameworks test4 = new Gameworks("zones.txt","players.txt");
        assertEquals(test4.playMatchnoDice("dice2.txt"),0);
        assertEquals(test4.players.get(0).name,"Rudolf");
        assertEquals(test4.players.get(0).getMoney(),49100);
        assertEquals(test4.players.get(0).getHouseTour().size(),2);
        
    }
    
     @Test
    public void worksTheSameEveryTime2() throws FileNotFoundException
    {
        Gameworks test5 = new Gameworks("zones.txt","players.txt");
        assertEquals(test5.playMatchnoDice("dice3.txt"),0);
        assertEquals(test5.players.get(0).name,"Koppany");
        assertEquals(test5.players.get(0).getMoney(),29950);
        assertEquals(test5.players.get(0).getHouseTour().size(),2);
        
    }
    
     @Test(expected=FileNotFoundException.class)
    public void noDice() throws FileNotFoundException
    {
        Gameworks test6 = new Gameworks("zones.txt","players.txt");
        assertEquals(test6.playMatchnoDice("dice4.txt"),2);
    }
        
    public void onePlayer()
    {
        ArrayList<Player> players = new ArrayList<>();
        players.add(new Strict("Zoltan"));
        Gameworks test7 = new Gameworks("zones.txt","oneplayer.txt");
        assertEquals(test7.players.size(),1);
        assertEquals(test7.field.size(),15);
        test7.playMatch();
        assertEquals(test7.players.get(0).getMoney(),10000);
       
        
    }        
    
    
    
}
