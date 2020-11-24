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
    
    /** Az amőba játékunk nyerés-eldöntő metódusa, melyben 4 ciklus során megszámoljuk az X -ek és O-k számát, 
     * majd ennek megfelelően szivatjuk a játékost, illetve ha elérte az 5-öt, akkor automatikusan nyert. */  
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
                if(XareasInARow==5)
                {
                        //System.out.println("GG");
                        winner=playerX;                        
                }
                else if(OareasInARow==5)
                {
                   // System.out.println("GGO");
                        winner=playerO;
                }
                else if(XareasInARow==3 && !gotPranked && !Player.getXTurn() && !playerX.getPranked3())
                {
                    playerX.prankPlayer();
                    playerX.gotPrankedfor3();
                    gotPranked = true;
                  //  System.out.println("pranked-1");
                }
                else if(OareasInARow==3 && !gotPranked && Player.getXTurn() && !playerO.getPranked3() )
                {
                    playerO.prankPlayer();
                    playerO.gotPrankedfor3();
                    gotPranked = true;
                   // System.out.println("pranked-2");
                }
                else if(XareasInARow==4 && !gotPranked && !Player.getXTurn() && !playerX.getPranked4())
                {
                    playerX.prankPlayer();
                    playerX.prankPlayer();
                    playerX.gotPrankedfor4();
                    gotPranked = true;
                    //System.out.println("pranked-3");
                }
                else if(OareasInARow==4 && !gotPranked && Player.getXTurn() && !playerO.getPranked4())
                { 
                    playerO.prankPlayer();
                    playerO.prankPlayer();
                    playerO.gotPrankedfor4();
                    gotPranked = true;
                   // System.out.println("pranked-4");
                }
            }
            else
            {
                XareasInARow=0;
                OareasInARow=0;
            }
            
            if(XareasInARow==5)
            {
               // System.out.println("GG");
                winner=playerX;                         
            }
            else if(OareasInARow==5)

                //System.out.println("GGO");
                    winner= playerO;
            }
            else if(XareasInARow==3 && !gotPranked && !Player.getXTurn() && !playerX.getPranked3() )
=======
                System.out.println("GGO");
                winner= playerO;
            }
            else if(XareasInARow==4 &&!gotPranked &&  !Player.getXTurn() )
>>>>>>> 0db88027f7257daf3bb3091d8ffe000def999f7b
            {
                playerX.prankPlayer().prankPlayer();
                
                gotPranked = true;
<<<<<<< HEAD
                playerX.gotPrankedfor3();
                //System.out.println("pranked1");
            }
            else if(OareasInARow==3 && !gotPranked && Player.getXTurn() && !playerO.getPranked3() )
            {
                playerO.prankPlayer();
                playerO.gotPrankedfor3();
                gotPranked = true;
                //System.out.println("pranked2");
            }
            else if(XareasInARow==4 && !gotPranked && !Player.getXTurn() && !playerX.getPranked4())
=======
                System.out.println("pranked3");
            }
            else if(OareasInARow==4 && !gotPranked && Player.getXTurn()  )
            {
                playerO.prankPlayer().prankPlayer();
               
                gotPranked = true;
                System.out.println("pranked4");
            } 
            else if(XareasInARow==3 &&!gotPranked &&  !Player.getXTurn() && varjmegX || !varjmegX   )
>>>>>>> 0db88027f7257daf3bb3091d8ffe000def999f7b
            {
                if(varjmegX)
                {
                    continue;
                }
                playerX.prankPlayer();
                playerX.gotPrankedfor4();
                gotPranked = true;
<<<<<<< HEAD
                //System.out.println("pranked3");
            }
            else if(OareasInARow==4 && !gotPranked && Player.getXTurn() && !playerO.getPranked4() )
=======
                System.out.println("pranked1");
                varjmegX=true;
                
            }
            else if(OareasInARow==3 &&!gotPranked &&  Player.getXTurn() && varjmegO || !varjmegO )
>>>>>>> 0db88027f7257daf3bb3091d8ffe000def999f7b
            {
                if(varjmegO)
                {
                    continue;
                }
                playerO.prankPlayer();
                playerO.gotPrankedfor4();
                gotPranked = true;
<<<<<<< HEAD
                //System.out.println("pranked4");
            } 
=======
                System.out.println("pranked2");
                varjmegO=true;

                
>>>>>>> 0db88027f7257daf3bb3091d8ffe000def999f7b
            }
            
        }
        
        XareasInARow=0;
        OareasInARow=0;
        varjmegO =  true;
        varjmegX =  true;
        
        System.out.println("Oszlop check");
        // oszlop check
            for(int idx=it.getCoordY(); idx<fieldButtons.size();idx+=Math.sqrt(fieldButtons.size()))
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
                    //System.out.println("GG");
                    winner=playerX;                         
                }
                else if(OareasInARow==5)
                {
<<<<<<< HEAD
                    //System.out.println("GGO");
                    winner=playerO;
                }    
            if(XareasInARow==3 && !gotPranked && !Player.getXTurn() && !playerX.getPranked3())
            {
                playerX.prankPlayer();
                gotPranked = true;
                playerX.gotPrankedfor3();
                //System.out.println("pranked5");
            }
            else if(OareasInARow==3 && !gotPranked && Player.getXTurn() && !playerO.getPranked3() )
            {
                playerO.prankPlayer();
                gotPranked = true;
                playerO.gotPrankedfor3();
                //System.out.println("pranked6");
            }
            else if(XareasInARow==4 && !gotPranked && !Player.getXTurn() && !playerX.getPranked4() )
            {
                playerX.prankPlayer();
                playerX.prankPlayer();
                playerX.gotPrankedfor4();
                gotPranked = true;
                //System.out.println("pranked7");
            }
            else if(OareasInARow==4 && !gotPranked && Player.getXTurn() && !playerO.getPranked4())
            {
                playerO.prankPlayer();
                playerO.prankPlayer();
                playerO.gotPrankedfor4();
                gotPranked = true;
                //System.out.println("pranked8");
            } 
=======
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
>>>>>>> 0db88027f7257daf3bb3091d8ffe000def999f7b
            }
            
            XareasInARow=0;
            OareasInARow=0;
            varjmegO =  true;
            varjmegX =  true;
        System.out.println("Jobbátló check");
        //átló check jobbra
        for(int idx=it.getCoordX()>it.getCoordY() ? it.getAtloFirstElem() * (int)Math.sqrt(fieldButtons.size()) : it.getAtloFirstElem(); idx<fieldButtons.size(); idx+=Math.sqrt(fieldButtons.size())+1)
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
<<<<<<< HEAD
                    {
                        //System.out.println("GG");
                        winner=playerX;                         
                    }
                else if(OareasInARow==5)
                    {
                        //System.out.println("GGO");
                        winner=playerO;
                    }    
                if(XareasInARow==3 && !gotPranked && !Player.getXTurn() && !playerX.getPranked3() )
=======
                {
                    System.out.println("GG");
                    winner=playerX;                         
                }
                else if(OareasInARow==5)
>>>>>>> 0db88027f7257daf3bb3091d8ffe000def999f7b
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
<<<<<<< HEAD
                    playerX.gotPrankedfor3();
                    //System.out.println("pranked9");
                }
                else if(OareasInARow==3 && !gotPranked && Player.getXTurn() && !playerO.getPranked3() )
=======
                    System.out.println("pranked1");
                    varjmegX=true;
                    
                }
                else if(OareasInARow==3 &&!gotPranked &&  Player.getXTurn() && varjmegO || !varjmegO )
>>>>>>> 0db88027f7257daf3bb3091d8ffe000def999f7b
                {
                    if(varjmegO)
                    {
                        continue;
                    }
                    playerO.prankPlayer();
                    gotPranked = true;
<<<<<<< HEAD
                    playerO.gotPrankedfor3();
                    //System.out.println("pranked10");
                }
                else if(XareasInARow==4 && !gotPranked && !Player.getXTurn() && !playerX.getPranked4() )
=======
                    System.out.println("pranked2");
                    varjmegO=true;
    
                    
                }
            } 
            
            XareasInARow=0;
            OareasInARow=0;
            varjmegO =  true;
            varjmegX =  true;
            System.out.println("Balátló check");
            //System.out.println( it.getCoordX()>it.getCoordY() ? it.getAtloFirstElem() * (int)Math.sqrt(fieldButtons.size()) : it.getAtloFirstElem()  );
            for(int idx = it.getAtloFirstElem2((int)Math.sqrt(fieldButtons.size())); idx<fieldButtons.size(); idx+=Math.sqrt(fieldButtons.size())-1)
            {
                if(!(fieldButtons.get(idx).getText().equals("")))
>>>>>>> 0db88027f7257daf3bb3091d8ffe000def999f7b
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
                    playerX.gotPrankedfor4();
                    gotPranked = true;
<<<<<<< HEAD
                    //System.out.println("pranked11");
                }
                else if(OareasInARow==4 && !gotPranked && Player.getXTurn() && !playerO.getPranked4() )
=======
                    System.out.println("pranked1");
                    varjmegX=true;
                    
                }
                else if(OareasInARow==3 &&!gotPranked &&  Player.getXTurn() && varjmegO || !varjmegO )
>>>>>>> 0db88027f7257daf3bb3091d8ffe000def999f7b
                {
                    if(varjmegO)
                    {
                        continue;
                    }
                    playerO.prankPlayer();
                    playerO.gotPrankedfor4();
                    gotPranked = true;
<<<<<<< HEAD
                    //System.out.println("pranked12");
                }
=======
                    System.out.println("pranked2");
                    varjmegO=true;
    
                    
                }   
>>>>>>> 0db88027f7257daf3bb3091d8ffe000def999f7b
            }
            return;
        }
    
        /** Megvizsgálja a metódus elején, hogy  a gombbal kértünk új játékot,
         *  vagy az előzőnek ténylegesen vége lett, és ha végig lett játszva a játék, 
         * akkor kiírja egy párbeszédablakban a nyertes nevét, 
         * majd rövid idő után bezárja az éppen nyitva lévő ablakot, és az új játékot egy új ablakban megnyitva kezdi el.   */
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
