/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beadando;
import beadando.mechanics.Gameworks;
import beadando.players.*;
import java.util.ArrayList;

/**
 *
 * @author lkcsd
 */
public class Beadando {
    

    public static void main(String[] args) {
        ArrayList<Player> players = new ArrayList<>();
        players.add(new Strict("Zoltan"));
        players.add(new Tactical("Rudolf"));
        players.add(new Careful("David"));
        players.add(new Strict("Joska"));
        players.add(new Tactical("Koppany"));
        players.add(new Careful("Richard"));
        Gameworks match = new Gameworks("zones.txt",players);
        System.out.println(match.toString());
        match.playMatch();
    }
    
}
