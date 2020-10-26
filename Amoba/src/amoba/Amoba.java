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
public class Amoba {
    ;
    public static AmobaGUI window=new AmobaGUI();
    public static int XareasInARow=0;
    public static int OareasInARow=0;
    private static final Player playerX = window.getPlayerX();
    private static final Player playerO = window.getPlayerO();
    
    
    public static Player determineWinner()
    {
        XareasInARow=0;
        OareasInARow=0;
        ArrayList<XOButton> fieldButtons = window.getButtons();
        
        // sor check
        for(int idx=0; idx<fieldButtons.size();idx++)
        {
            if(idx%Math.sqrt(fieldButtons.size())==0)
            {
                XareasInARow=0;
                OareasInARow=0;
            }
            if(!(fieldButtons.get(idx).getLabel().equals("")))
            {
                if(fieldButtons.get(idx).getLabel().equals("X"))
                {
                    OareasInARow=0;
                    ++XareasInARow;
                    //System.out.println(areasInARow);
                }
                else
                {
                    
                    XareasInARow=0;
                    ++OareasInARow;
                    //System.out.println(areasInARow);
                }
                if(XareasInARow==3)
                    {
                        prankPlayer(playerX);
                    }
                    if(OareasInARow==3)
                    {
                        prankPlayer(playerO);
                    }
                    if(XareasInARow==4)
                    {
                        prankPlayer(playerX);
                        prankPlayer(playerX);
                    }
                    if(OareasInARow==4)
                    {
                        prankPlayer(playerO);
                        prankPlayer(playerO);
                    }
                if(XareasInARow==5)
                {
                        System.out.println("GG");
                        return playerX;                        
                }
                else if(OareasInARow==5)
                {
                    System.out.println("GGO");
                        return playerO;
                }
            }
            else
            {
                //System.out.println(0);
                XareasInARow=0;
                OareasInARow=0;
            }      
        }
        
        XareasInARow=0;
        OareasInARow=0;
        
        // oszlop check
        for(int jdx=0;jdx<Math.sqrt(fieldButtons.size()); jdx++)
        {
            XareasInARow=0;
            OareasInARow=0;
            for(int idx=jdx; idx<fieldButtons.size();idx+=Math.sqrt(fieldButtons.size()))
            {
                
                if(!(fieldButtons.get(idx).getLabel().equals("")))
                {
                    if(fieldButtons.get(idx).getLabel().equals("X"))
                    {
                        OareasInARow=0;
                        ++XareasInARow;
                    }
                    else
                    {
                        XareasInARow=0;
                        ++OareasInARow;
                    }
                    if(XareasInARow==3)
                    {
                        prankPlayer(playerX);
                    }
                    else if(OareasInARow==3)
                    {
                        prankPlayer(playerO);
                    }
                    else if(XareasInARow==4)
                    {
                        prankPlayer(playerX);
                        prankPlayer(playerX);
                    }
                    else if(OareasInARow==4)
                    {
                        prankPlayer(playerO);
                        prankPlayer(playerO);
                    }
                    else if(XareasInARow==5)
                    {
                            System.out.println("GG");
                            return playerX;                         
                    }
                    else if(OareasInARow==5)
                    {
                        System.out.println("GGO");
                            return playerO;
                    }
                    }
                    else
                    {
                        XareasInARow=0;
                        OareasInARow=0;
                    }      
            }
        }
        
        XareasInARow=0;
        OareasInARow=0;
        
        //átló check jobbra
        for(int jdx=0; jdx<fieldButtons.size();jdx++)
        {
            for(int idx=jdx; idx<fieldButtons.size(); idx+=Math.sqrt(fieldButtons.size())+1)
            {
              if(!(fieldButtons.get(idx).getLabel().equals("")))
                {
                    if(fieldButtons.get(idx).getLabel().equals("X"))
                    {
                        OareasInARow=0;
                        ++XareasInARow;
                    }
                    else
                    {
                        XareasInARow=0;
                        ++OareasInARow;
                    }
                    if(XareasInARow==3)
                    {
                        prankPlayer(playerX);
                    }
                    else if(OareasInARow==3)
                    {
                        prankPlayer(playerO);
                    }
                    else if(XareasInARow==4)
                    {
                        prankPlayer(playerX);
                        prankPlayer(playerX);
                    }
                    else if(OareasInARow==4)
                    {
                        prankPlayer(playerO);
                        prankPlayer(playerO);
                    }
                    else if(XareasInARow==5)
                    {
                            System.out.println("GG");
                            return playerX;                         
                    }
                    else if(OareasInARow==5)
                    {
                        System.out.println("GGO");
                            return playerO;
                    }
                    }
                    else
                    {
                        XareasInARow=0;
                        OareasInARow=0;
                    }   
            }
        }
        
        XareasInARow=0;
        OareasInARow=0;
            
        //oszlop check balra  
        for(int jdx=0; jdx<fieldButtons.size();jdx++)
        {
            for(int idx=jdx; idx<fieldButtons.size(); idx+=Math.sqrt(fieldButtons.size())-1)
            {
              if(!(fieldButtons.get(idx).getLabel().equals("")))
                {
                    if(fieldButtons.get(idx).getLabel().equals("X"))
                    {
                        OareasInARow=0;
                        ++XareasInARow;
                    }
                    else
                    {
                        XareasInARow=0;
                        ++OareasInARow;
                    }
                    if(XareasInARow==3)
                    {
                        prankPlayer(playerX);
                    }
                    else if(OareasInARow==3)
                    {
                        prankPlayer(playerO);
                    }
                    else if(XareasInARow==4)
                    {
                        prankPlayer(playerX);
                        prankPlayer(playerX);
                    }
                    else if(OareasInARow==4)
                    {
                        prankPlayer(playerO);
                        prankPlayer(playerO);
                    }
                    if(XareasInARow==5)
                    {
                            System.out.println("GG");
                            return playerX;                         
                    }
                    else if(OareasInARow==5)
                    {
                        System.out.println("GGO");
                            return playerO;
                    }
                    }
                    else
                    {
                        XareasInARow=0;
                        OareasInARow=0;
                    }   
            }
        }
       
        return null;
    }
    
    public static void prankPlayer(Player prankable)
    {
        Random randnumb = new Random();
        prankable.getownButtons().get(Math.abs(randnumb.nextInt()%prankable.getownButtons().size())).setLabel("");
        prankable.getownButtons().remove(Math.abs(randnumb.nextInt()%prankable.getownButtons().size()));
        
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        return;
    }
    
}
