/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beadando;
import beadando.mechanics.Gameworks;
import beadando.players.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 *
 * @author lkcsd
 */
public class Beadando {
    /** a készítés során ezt a main programot használtam a játék tesztelésére, hogy lássam, minden úgy működik, ahogy én gondolom. Tulajdonképpen minden fontos metódust meghívok benne.
     * Az unit tesztek megléte ellenére meghagyom, ha bármikor próbálgatni kellene rajta valamit. */
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Player> players = new ArrayList<>();
        players.add(new Strict("Zoltan"));
        players.add(new Tactical("Rudolf"));
        players.add(new Careful("David"));
        players.add(new Strict("Joska"));
        players.add(new Tactical("Koppany"));
        players.add(new Careful("Richard"));
        Gameworks match = new Gameworks("zones.txt",players);
        System.out.println(match.toString());
        match.playMatchnoDice("dice.txt");
    }
    
}
