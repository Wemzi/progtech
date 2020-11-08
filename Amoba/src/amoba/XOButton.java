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
    private final int coord;
    
    
    XOButton(int coordX, int coordY, int coord)
    {
        super();
        this.coordX=coordX;
        this.coordY=coordY;
        this.coord = coord;
    }

    public int getCoordX() {
        return coordX;
    }

    public int getCoordY() {
        return coordY;
    }

    public int getCoord() {
        return coord;
    }
    
    public int getAtloFirstElem()
    {
        int tmpX=getCoordX();
        int tmpY=getCoordY();
            if(coordX == coordY)
            {
            System.out.println(0);
            return 0;
            }
            else
            {
                while(tmpX > 0 && tmpY > 0 )
                {
                    tmpX--;
                    tmpY--;
                }
                return tmpX > 0 ? tmpX : tmpY;
                
            }
    }
    
    public int getAtloFirstElem2(int size)
    {
        int tmpX=getCoordX();
        int tmpY=getCoordY();

                while(tmpX > 0  && tmpY < size )
                {
                    tmpX--;
                    tmpY++;
                }
                return  size * tmpX + tmpY;

    }


        
    
    
}
