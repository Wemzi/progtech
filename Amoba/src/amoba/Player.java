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
    private boolean pranked3=false;
    private boolean pranked4=false;

   /**a játékos megszivatásáért felelős metódus, 
    * a játékos gombjai közül (gyűjtemény) választ véletlenszerűen egyet amit kidob a gyűjteményből,
    * és ennek megfelelően a gomb szövegét („X”, vagy „O”) is „”-ra változtatja. */
    public void prankPlayer()
    {
        Random randnumb = new Random();
        int random = Math.abs(randnumb.nextInt(ownButtons.size()));
        ownButtons.get(random).setText("");
        ownButtons.remove(random);
        
    }
    
    public boolean getPranked3()
    {
        return pranked3;
    }
    
    public boolean getPranked4()
    {
        return pranked4;
    }
    
    public void gotPrankedfor3()
    {
        pranked3=true;
    }
    
    public void gotPrankedfor4()
    {
        pranked4=true;
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
    
    public static boolean getXTurn()
    {
        return isXturn;
    }
    
    public String getName() {
        return name;
    }
    
}