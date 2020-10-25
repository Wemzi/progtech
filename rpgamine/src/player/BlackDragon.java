/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package player;

/**
 *
 * @author lkcsd
 */
 public class BlackDragon extends Dragon {

    public BlackDragon(String name, int HP, int AD, int DEF) {
        super(name, HP, AD, DEF);
    }

    @Override
    public String toString() {
        return ("BlackDragon" + " name : " + name " HP: " + HP);
    }
    
    
}
