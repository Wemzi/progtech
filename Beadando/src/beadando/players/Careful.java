/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beadando.players;

/**
 *
 * @author lkcsd
 */
public class Careful extends Player {

    public Careful(String name) {
        super(name);
    }

        public String toString()
    {
        return name + " strategy: Careful, money: " + money; 
    }
   
    
}
