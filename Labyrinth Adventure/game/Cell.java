package game;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.Image;
import javax.swing.JFrame;
import javax.lang.model.util.ElementScanner6;
import javax.swing.ImageIcon;
import java.io.IOException;


public class Cell {
    boolean hasBeenSelected=false;
    int colIdx;
    int rowIdx;

    boolean edgeRight=  true;
    boolean edgeLeft =  true;
    boolean edgeDown =  true;
    boolean edgeUp   =  true;

    public Image selectImage() throws IOException
    {
        if(edgeRight && edgeLeft && edgeDown )
        {
            Image i = ResourceLoader.loadImage("assets/edgelrd.png");
            return i;
        }
        else if(edgeRight && edgeLeft && edgeUp)
        {
            Image i = ResourceLoader.loadImage("assets/edgeurl.png");
            return i;
        }
        else if(edgeRight && edgeDown && edgeUp)
        {
            Image i = ResourceLoader.loadImage("assets/edgeurd.png");
            return i;
        }
        else if(edgeLeft && edgeDown && edgeUp)
        {
            Image i = ResourceLoader.loadImage("assets/edgelud.png");
            return i;
        }
        else if(edgeLeft && edgeDown)
        {
            Image i = ResourceLoader.loadImage("assets/edgeld.png");
            return i;
        }
        else if(edgeLeft && edgeUp)
        {
            Image i = ResourceLoader.loadImage("assets/edgeul.png");
            return i;
        }
        else if(edgeLeft && edgeRight)
        {
            Image i = ResourceLoader.loadImage("assets/edgelr.png");
            return i;
        }
        else if(edgeRight && edgeUp)
        {
            Image i = ResourceLoader.loadImage("assets/edgeur.png");
            return i;
        }
        else if(edgeRight && edgeDown)
        {
            Image i = ResourceLoader.loadImage("assets/edgerd.png");
            return i;
        }
        else if(edgeUp && edgeDown)
        {
            Image i = ResourceLoader.loadImage("assets/edgeud.png");
            return i;
        }
        else if(edgeDown)
        {
            Image i = ResourceLoader.loadImage("assets/edged.png");
            return i;
        }
        else if(edgeUp)
        {
            Image i = ResourceLoader.loadImage("assets/edgeu.png");
            return i;
        }
        else if(edgeLeft)
        {
            Image i = ResourceLoader.loadImage("assets/edgel.png");
            return i;
        }
        else if(edgeRight)
        {
            Image i = ResourceLoader.loadImage("assets/edger.png");
            return i;
        }
        else
        {
            Image i = ResourceLoader.loadImage("assets/grass.png");
            return i;
        }
    }

    public Cell(int colIdx, int rowIdx)
    {
        this.colIdx = colIdx;
        this.rowIdx = rowIdx;
    }

    public boolean getedgeRight()
    {
        return edgeRight;
    }

    public boolean getedgeUp()
    {
        return edgeUp;
    }

    public boolean getedgeDown()
    {
        return edgeDown;
    }

    public boolean getedgeLeft()
    {
        return edgeLeft;
    }

    public void setedgeRight()
    {
         edgeRight= false;
    }

    public void setedgeUp()
    {
         edgeUp = false;   }

    public void setedgeDown()
    {
         edgeDown= false;
    }

    public void setedgeLeft()
    {
         edgeLeft= false;
    }

    public int getcolIdx()
    {
        return colIdx;
    }

    public int getrowIdx()
    {
        return rowIdx;
    }
    public boolean gethasBeenSelected()
    {
        return hasBeenSelected;
    }

    public void sethasBeenSelected()
    {
        hasBeenSelected = true;
    }
}
