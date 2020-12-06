/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author lkcsdvd
 */
public class Labyrinth extends JPanel{
    private ArrayList<ArrayList<Cell>> cells;
    private AdventureGUI board;

    public Labyrinth(AdventureGUI board)
    {
        this.board=board;
        cells = board.getCells();
    }

    public int countDistance(int szam1, int szam2)
    {
        return szam2-szam1;
    }
    /** Grafikai rajzoló metódus, itt hívjuk meg a képkiválasztó függvényket, és helyezzük őket a megfelelő helyre az ablakon belül. */
    @Override
    protected void paintComponent(Graphics g)
    {
        int picsize = board.getFrame().getWidth()/cells.size() ;
        Graphics2D gr = (Graphics2D)g;
        BufferedImage darkness = null;
        try
        {
            darkness = ResourceLoader.loadImage("assets/darkness.png");
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
        
        BufferedImage img = null;
        for(int idx=cells.size()-1; idx>=0;idx--)
        {
            for (int jdx=0; jdx<cells.get(0).size(); jdx++)
            {
                Cell cell = cells.get(idx).get(jdx);
                img = null;
                try
                {
                if(Math.abs(countDistance(board.getPlayer().getcoordX(),jdx)) > 2 || Math.abs(countDistance(board.getPlayer().getcoordY(),idx)) > 2)
                {
                    img = darkness;
                }
                else if(board.getDragon().getcoordY() == idx && board.getDragon().getcoordX() == jdx )
                {
                    img = cell.selectDragonImage();
                  
                }
                else if(board.getPlayer().getcoordY() == idx && board.getPlayer().getcoordX() == jdx )
                {
                    img = cell.selectPlayerImage();
                }
                else
                {
                    img = cell.selectImage();
                }
                
                }
                catch(IOException e)
                {
                    System.out.println("Error loading file");
                }
                gr.drawImage(img, jdx * picsize,(board.getFrame().getHeight()-(idx+2)*(picsize)), picsize, picsize, null);
            
            }
        }
    }
    
}