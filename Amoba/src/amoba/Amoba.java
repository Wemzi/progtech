/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amoba;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author lkcsd
 */
public class Amoba {
    public AmobaGUI window = new AmobaGUI(this);
    public int XareasInARow=0;
    public int OareasInARow=0;
    private Player playerX= window.getPlayerX();
    private Player playerO = window.getPlayerO();
    public Player winner = null;
    
    
    public void determineWinner()
    {
        boolean gotPranked = false;
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
            if(!(fieldButtons.get(idx).getText().equals("")))
            {
                if(fieldButtons.get(idx).getText().equals("X"))
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
                if(XareasInARow==5)
                {
                        System.out.println("GG");
                        winner=playerX;                        
                }
                else if(OareasInARow==5)
                {
                    System.out.println("GGO");
                        winner=playerO;
                }
                else if(XareasInARow==3 && !gotPranked )
                {
                    playerX.prankPlayer();
                    gotPranked = true;
                    System.out.println("pranked-1");
                }
                else if(OareasInARow==3 && !gotPranked )
                {
                    playerO.prankPlayer();
                    gotPranked = true;
                    System.out.println("pranked-2");
                }
                else if(XareasInARow==4 && !gotPranked )
                {
                    playerX.prankPlayer();
                    playerX.prankPlayer();
                    gotPranked = true;
                    System.out.println("pranked-3");
                }
                else if(OareasInARow==4 && !gotPranked )
                {
                    playerO.prankPlayer();
                    playerO.prankPlayer();
                    gotPranked = true;
                    System.out.println("pranked-4");
                }
            }
            else
            {
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
                
                if(!(fieldButtons.get(idx).getText().equals("")))
                {
                    if(fieldButtons.get(idx).getText().equals("X"))
                    {
                        OareasInARow=0;
                        ++XareasInARow;
                    }
                    else
                    {
                        XareasInARow=0;
                        ++OareasInARow;
                    }                          
                }
                else
                    {
                        XareasInARow=0;
                        OareasInARow=0;
                    }
            if(XareasInARow==5)
            {
                System.out.println("GG");
                winner=playerX;                         
            }
            else if(OareasInARow==5)
            {
                System.out.println("GGO");
                    winner= playerO;
            }
            else if(XareasInARow==3 && !gotPranked )
            {
                playerX.prankPlayer();
                gotPranked = true;
                System.out.println("pranked1");
            }
            else if(OareasInARow==3 && !gotPranked )
            {
                playerO.prankPlayer();
                gotPranked = true;
                System.out.println("pranked2");
            }
            else if(XareasInARow==4 && !gotPranked )
            {
                playerX.prankPlayer();
                playerX.prankPlayer();
                gotPranked = true;
                System.out.println("pranked3");
            }
            else if(OareasInARow==4 && !gotPranked )
            {
                playerO.prankPlayer();
                playerO.prankPlayer();
                gotPranked = true;
                System.out.println("pranked4");
            } 
            }
                     
        }
        
        XareasInARow=0;
        OareasInARow=0;
        
        //átló check jobbra
        for(int jdx=0; jdx<fieldButtons.size();jdx++)
        {
            XareasInARow=0;
            OareasInARow=0;
            for(int idx=jdx; idx<fieldButtons.size(); idx+=Math.sqrt(fieldButtons.size())+1)
            {
              if(!(fieldButtons.get(idx).getText().equals("")))
                {
                    if(fieldButtons.get(idx).getText().equals("X"))
                    {
                        OareasInARow=0;
                        ++XareasInARow;
                    }
                    else
                    {
                        XareasInARow=0;
                        ++OareasInARow;
                    }       
                }
              else
                {
                    XareasInARow=0;
                    OareasInARow=0;
                }
                if(XareasInARow==5)
                {
                    System.out.println("GG");
                    winner=playerX;                         
                }
                else if(OareasInARow==5)
                {
                    System.out.println("GGO");
                    winner=playerO;
                }    
            if(XareasInARow==3 && !gotPranked )
            {
                playerX.prankPlayer();
                gotPranked = true;
                System.out.println("pranked5");
            }
            else if(OareasInARow==3 && !gotPranked )
            {
                playerO.prankPlayer();
                gotPranked = true;
                System.out.println("pranked6");
            }
            else if(XareasInARow==4 && !gotPranked )
            {
                playerX.prankPlayer();
                playerX.prankPlayer();
                gotPranked = true;
                System.out.println("pranked7");
            }
            else if(OareasInARow==4 && !gotPranked )
            {
                playerO.prankPlayer();
                playerO.prankPlayer();
                gotPranked = true;
                System.out.println("pranked8");
            } 
            }
            
        }
        
        for(int jdx=0; jdx<fieldButtons.size();jdx++)
        {
            XareasInARow=0;
            OareasInARow=0;
            for(int idx=jdx; idx<fieldButtons.size(); idx+=Math.sqrt(fieldButtons.size())-1)
            {
            if(!(fieldButtons.get(idx).getText().equals("")))
                {
                if(fieldButtons.get(idx).getText().equals("X"))
                        {
                            OareasInARow=0;
                            ++XareasInARow;
                        }
                else
                        {
                            XareasInARow=0;
                            ++OareasInARow;
                        }       
                    }
                else
                    {
                        XareasInARow=0;
                        OareasInARow=0;
                    }
                if(XareasInARow==5)
                    {
                        System.out.println("GG");
                        winner=playerX;                         
                    }
                else if(OareasInARow==5)
                    {
                        System.out.println("GGO");
                        winner=playerO;
                    }    
                if(XareasInARow==3 && !gotPranked )
                {
                    playerX.prankPlayer();
                    gotPranked = true;
                    System.out.println("pranked9");
                }
                else if(OareasInARow==3 && !gotPranked )
                {
                    playerO.prankPlayer();
                    gotPranked = true;
                    System.out.println("pranked10");
                }
                else if(XareasInARow==4 && !gotPranked )
                {
                    playerX.prankPlayer();
                    playerX.prankPlayer();
                    gotPranked = true;
                    System.out.println("pranked11");
                }
                else if(OareasInARow==4 && !gotPranked )
                {
                    playerO.prankPlayer();
                    playerO.prankPlayer();
                    gotPranked = true;
                    System.out.println("pranked12");
                }
            }
           
        }
            return;
        }
    
    public void restartGame() throws InterruptedException
        {
            if(winner!=null)
            {
            JOptionPane.showMessageDialog(null, "We have a Winner! winner is: " + winner.getName() +". Starting new game in 3 seconds.");            
            }
            winner=null;
            window.getFrame().dispose();
            window=new AmobaGUI(this);
            playerO=window.getPlayerO();
            playerX=window.getPlayerX();
        }
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    new Amoba();   
    }
    
}
