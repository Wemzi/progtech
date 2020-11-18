package game;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.Image;
import java.io.IOException;

public class AdventureGUI {

    private JFrame frame;
    private Player player;
    private LabyrinthBuilder labyrinth;
    private Labyrinth mainPanel;
    private ArrayList<ArrayList<Cell>> cells;

    public AdventureGUI() throws IOException
    {
        frame = new JFrame("Labyrinth Adventure");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        labyrinth = new LabyrinthBuilder();
        cells = labyrinth.getCells();
        mainPanel = new Labyrinth(this);
        mainPanel.setPreferredSize(new Dimension(1000,1000));
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(1000,1000);
        frame.pack();
        frame.setVisible(true);

    }

    public ArrayList<ArrayList<Cell>> getCells()
    {
        return cells;
    }

    
}

class Labyrinth extends JPanel{
    private ArrayList<ArrayList<Cell>> cells;
    private AdventureGUI board;

    public Labyrinth(AdventureGUI board)
    {
        this.board=board;
        cells = board.getCells();
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        Graphics2D gr = (Graphics2D)g;
        for(int idx=0; idx<cells.size();idx++ )
        {
            for (int jdx=0; jdx<cells.get(0).size(); jdx++)
            {
                Cell cell = cells.get(idx).get(jdx);
                Image img = null;
                try
                {
                img = cell.selectImage();
                }
                catch(IOException e)
                {
                    System.out.println("Error loading file");
                }
                gr.drawImage(img, (idx * 53) , (jdx * 53), 50, 50, null);
            }
        }
        
    }
    
}
