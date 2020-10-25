/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgamine;

import player.*;

/**
 *
 * @author lkcsd
 */
public class Rpgamine {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Berserker player1 = new Berserker ("player1",100, 25,1);
        BlackDragon player2 = new BlackDragon ("player2",100, 25,1);
        RedDragon player3 = new RedDragon ("player3",100, 25,1);
        Tank player4 = new Tank ("player4",100, 25,1);
        Warrior player5 = new Warrior ("player5",100, 25,1);
        Tank player6 = new Tank ("player6",100, 25,1);
        player1.attack(player5);
    }
    
}
