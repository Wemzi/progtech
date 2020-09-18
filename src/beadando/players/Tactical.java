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
public class Tactical extends Player {
    
    private boolean boughtBefore=false;
    
    public Tactical(String name)
    {
        super(name);
    }
    
    public String toString()
    {
        return name + " strategy: Tactical, money: " + money; 
    }
    
}
