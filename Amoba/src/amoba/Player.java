/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amoba;

import java.util.ArrayList;
import java.util.Random;


/**
 *
 * @author lkcsd
 */
public class Player {
    private ArrayList<XOButton> ownButtons;
    private static boolean isXturn = true;
    private final String name;

   
    public void prankPlayer()
    {
        Random randnumb = new Random();
        int random = Math.abs(randnumb.nextInt(ownButtons.size()));
        ownButtons.get(random).setText("");
        ownButtons.remove(random);
        
    }
    
    public Player(String name)
    {
        ownButtons=new ArrayList<>();
        this.name = name;
    }
    
    public ArrayList<XOButton> getownButtons()
    {
        return ownButtons;
    }
    
    public void addButton(XOButton e)
    {
        ownButtons.add(e);
    }
    
    public static boolean isXTurn()
    {
        isXturn = !isXturn;
        return !isXturn;
    }
    
    public String getName() {
        return name;
    }
    
}