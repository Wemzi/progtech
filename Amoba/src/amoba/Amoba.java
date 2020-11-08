/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amoba;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author lkcsd
 */
public class Amoba {
    public AmobaGUI window = new AmobaGUI(this);
    public int XareasInARow=0;
    public int OareasInARow=0;
    public int MaXareas=0;
    public int MaOareas=0;
    private Player playerX= window.getPlayerX();
    private Player playerO = window.getPlayerO();
    public  Player winner = null;
    
    
    public void determineWinner(XOButton it)
    {
        boolean gotPranked = false;
       
        XareasInARow=0;
        OareasInARow=0;
        ArrayList<XOButton> fieldButtons = window.getButtons();
        boolean varjmegX=true;
        boolean varjmegO=true;
        // sor check
        System.out.println("Sor check");
        for(int idx=it.getCoordX()*(int)Math.sqrt(fieldButtons.size()); idx<it.getCoordX()*(int)Math.sqrt(fieldButtons.size())+(int)Math.sqrt(fieldButtons.size());idx++)
        {  
            if(!(fieldButtons.get(idx).getText().equals("")))
            {
                if(fieldButtons.get(idx).getText().equals("X"))
                {
                    if(OareasInARow==3)
                    {
                        varjmegO=false;
                    }
                    OareasInARow=0;
                    ++XareasInARow;
                    System.out.println("Oareas: " + OareasInARow + " Xareas:" + XareasInARow);
                    //System.out.println(areasInARow);
                }
                else
                {
                    if(XareasInARow==3)
                    {
                        varjmegX=false;
                    }
                    XareasInARow=0;
                    ++OareasInARow;
                    System.out.println("Oareas: " + OareasInARow + " Xareas:" + XareasInARow);
                    //System.out.println(areasInARow);
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
            else if(XareasInARow==4 &&!gotPranked &&  !Player.getXTurn() )
            {
                playerX.prankPlayer().prankPlayer();
                
                gotPranked = true;
                System.out.println("pranked3");
            }
            else if(OareasInARow==4 && !gotPranked && Player.getXTurn()  )
            {
                playerO.prankPlayer().prankPlayer();
               
                gotPranked = true;
                System.out.println("pranked4");
            } 
            else if(XareasInARow==3 &&!gotPranked &&  !Player.getXTurn() && varjmegX || !varjmegX   )
            {
                if(varjmegX)
                {
                    continue;
                }
                playerX.prankPlayer();
                gotPranked = true;
                System.out.println("pranked1");
                varjmegX=true;
                
            }
            else if(OareasInARow==3 &&!gotPranked &&  Player.getXTurn() && varjmegO || !varjmegO )
            {
                if(varjmegO)
                {
                    continue;
                }
                playerO.prankPlayer();
                gotPranked = true;
                System.out.println("pranked2");
                varjmegO=true;

                
            }
            
        }
        
        XareasInARow=0;
        OareasInARow=0;
        
        System.out.println("Oszlop check");
        // oszlop check
            for(int idx=it.getCoordY(); idx<fieldButtons.size();idx+=Math.sqrt(fieldButtons.size()))
            {
                if(!(fieldButtons.get(idx).getText().equals("")))
                {
                    if(fieldButtons.get(idx).getText().equals("X"))
                    {
                        OareasInARow=0;
                        ++XareasInARow;
                        System.out.println("Oareas: " + OareasInARow + " Xareas:" + XareasInARow);
                    }
                    else
                    {
                        XareasInARow=0;
                        ++OareasInARow;
                        System.out.println("Oareas: " + OareasInARow + " Xareas:" + XareasInARow);
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
            else if(XareasInARow==4 &&!gotPranked &&  !Player.getXTurn() )
            {
                playerX.prankPlayer().prankPlayer();
                
                gotPranked = true;
                System.out.println("pranked3");
            }
            else if(OareasInARow==4 && !gotPranked && Player.getXTurn()  )
            {
                playerO.prankPlayer().prankPlayer();
               
                gotPranked = true;
                System.out.println("pranked4");
            } 
            else if(XareasInARow==3 &&!gotPranked &&  !Player.getXTurn() )
            {
                playerX.prankPlayer();
                gotPranked = true;
                System.out.println("pranked1");
            }
            else if(OareasInARow==3 &&!gotPranked &&  Player.getXTurn() )
            {
                playerO.prankPlayer();
                gotPranked = true;
                System.out.println("pranked2");
            }
            }
            
            XareasInARow=0;
            OareasInARow=0;
        System.out.println("Jobbátló check");
        //átló check jobbra
        for(int idx=it.getCoordX()>it.getCoordY() ? it.getAtloFirstElem() * (int)Math.sqrt(fieldButtons.size()) : it.getAtloFirstElem(); idx<fieldButtons.size(); idx+=Math.sqrt(fieldButtons.size())+1)
            {
              if(!(fieldButtons.get(idx).getText().equals("")))
                {
                    if(fieldButtons.get(idx).getText().equals("X"))
                    {
                        OareasInARow=0;
                        ++XareasInARow;
                        System.out.println("Oareas: " + OareasInARow + " Xareas:" + XareasInARow);
                    }
                    else
                    {
                        XareasInARow=0;
                        ++OareasInARow;
                         System.out.println("Oareas: " + OareasInARow + " Xareas:" + XareasInARow);
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
                else if(XareasInARow==4 && !gotPranked && !Player.getXTurn())
                {
                    playerX.prankPlayer().prankPlayer();
                    gotPranked = true;
                    System.out.println("pranked7");
                }
                else if(OareasInARow==4 &&!gotPranked &&  Player.getXTurn() )
                {
                    playerO.prankPlayer().prankPlayer();
                    System.out.println("pranked8");
                } 
                else if(XareasInARow==3  && !gotPranked && !Player.getXTurn()  )
                {
                    playerX.prankPlayer();
                    gotPranked = true;
                    System.out.println("pranked5");
                }
                else if(OareasInARow==3  && !gotPranked && Player.getXTurn() )
                {
                    playerO.prankPlayer();
                    gotPranked = true;
                    System.out.println("pranked6");
                }
            }  
            System.out.println("Balátló check");
            //System.out.println( it.getCoordX()>it.getCoordY() ? it.getAtloFirstElem() * (int)Math.sqrt(fieldButtons.size()) : it.getAtloFirstElem()  );
            for(int idx = it.getAtloFirstElem2((int)Math.sqrt(fieldButtons.size())); idx<fieldButtons.size(); idx+=Math.sqrt(fieldButtons.size())-1)
            {
            if(!(fieldButtons.get(idx).getText().equals("")))
                {
                if(fieldButtons.get(idx).getText().equals("X"))
                        {
                            OareasInARow=0;
                            ++XareasInARow;
                            System.out.println("Oareas: " + OareasInARow + " Xareas:" + XareasInARow);
                        }
                else
                        {
                            XareasInARow=0;
                            ++OareasInARow;
                            System.out.println("Oareas: " + OareasInARow + " Xareas:" + XareasInARow);
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
                else if(XareasInARow==4 &&!gotPranked &&  !Player.getXTurn())
                {
                    playerX.prankPlayer().prankPlayer();
                    gotPranked = true;
                    System.out.println("pranked11");
                }
                else if(OareasInARow==4 && !gotPranked && Player.getXTurn() )
                {
                    playerO.prankPlayer().prankPlayer();
                    gotPranked = true;
                    System.out.println("pranked12");
                }
                else if( XareasInARow==3 && !gotPranked && !Player.getXTurn())
                {
                    playerX.prankPlayer();
                    gotPranked = true;
                    System.out.println("pranked9");
                }
                else if(OareasInARow==3 && !gotPranked && Player.getXTurn())
                {
                    playerO.prankPlayer();
                    gotPranked = true;
                    System.out.println("pranked10");
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
