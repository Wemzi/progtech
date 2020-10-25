/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amoba;

import javax.swing.JButton;

/**
 *
 * @author lkcsdvd
 */
public class XOButton extends JButton {
    private final int coordX;
    private final int coordY;
    
    
    XOButton(int coordX, int coordY)
    {
        super();
        this.coordX=coordX;
        this.coordY=coordY;
    }
    
}
