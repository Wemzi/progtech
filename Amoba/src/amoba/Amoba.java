/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amoba;

import java.util.ArrayList;

/**
 *
 * @author lkcsd
 */
public class Amoba {
    private static Player playerX = new Player();
    private static Player playerO = new Player();
    public static AmobaGUI window;
    public static int areasInARow=0;
    
    public static Player determineWinner()
    {
        areasInARow=0;
        ArrayList<XOButton> fieldButtons = window.getButtons();
        
        // sor check
        for(int idx=0; idx<fieldButtons.size();idx++)
        {
            if(idx%Math.sqrt(fieldButtons.size())==0)
            {
                areasInARow=0;
            }
            if(!(fieldButtons.get(idx).getLabel().equals("")))
            {
                if(fieldButtons.get(idx).getLabel().equals("X"))
                {
                    ++areasInARow;
                    //System.out.println(areasInARow);
                }
                else
                {
                    --areasInARow;
                    //System.out.println(areasInARow);
                }
                if(areasInARow==5)
                {
                        System.out.println("GG");
                        return playerX;                         
                }
                else if(areasInARow==-5)
                {
                    System.out.println("GGO");
                        return playerO;
                }
            }
            else
            {
                //System.out.println(0);
                areasInARow=0;
            }      
        }
        
        // oszlop check
        for(int jdx=0;jdx<Math.sqrt(fieldButtons.size()); jdx++)
        {
            areasInARow=0;
            for(int idx=jdx; idx<fieldButtons.size();idx+=Math.sqrt(fieldButtons.size()))
            {
                
                if(!(fieldButtons.get(idx).getLabel().equals("")))
                {
                    if(fieldButtons.get(idx).getLabel().equals("X"))
                    {
                        ++areasInARow;
                        //System.out.println(areasInARow);
                    }
                    else
                    {
                        --areasInARow;
                        //System.out.println(areasInARow);
                    }
                    if(areasInARow==5)
                    {
                            System.out.println("GG");
                            return playerX;                         
                    }
                    else if(areasInARow==-5)
                    {
                        System.out.println("GGO");
                            return playerO;
                    }
                    }
                    else
                    {
                        areasInARow=0;
                    }      
            }
        }
        return null;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        window = new AmobaGUI();
        while(determineWinner()==null)
        {
            System.out.println("no winner");
        }
        return;
    }
    
}
