/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amoba;

import java.util.ArrayList;
import javax.swing.JButton;


/**
 *
 * @author lkcsd
 */
public class Player {
    private ArrayList<JButton> ownButtons = new ArrayList<>();
    private boolean isWinner = false;
    
    
    public boolean determineWinner()
    {
        if(ownButtons.size()<5)
        {
            return false;
        }
        
    }
    
}
