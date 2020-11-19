package game;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;
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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AdventureGUI {

    private JFrame frame;
    private Player Steve;
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
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setVisible(true);
        frame.setSize(630,630);
        Steve = new Player();
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {
                super.keyPressed(ke); 
                int kk = ke.getKeyCode();
                switch (kk){
                    case KeyEvent.VK_LEFT:  Steve.move(-1,0,cells.size(),cells.get(0).size()); break;
                    case KeyEvent.VK_RIGHT: Steve.move(+1,0,cells.size(),cells.get(0).size()); break;
                    case KeyEvent.VK_UP:    Steve.move(0,+1,cells.size(),cells.get(0).size()); break;
                    case KeyEvent.VK_DOWN:  Steve.move(0,-1,cells.size(),cells.get(0).size()); break;
                }
                frame.repaint();
            }
        });
    }

    public JFrame getFrame()
    {
        return frame;
    }

    public ArrayList<ArrayList<Cell>> getCells()
    {
        return cells;
    }

    public Player getPlayer()
    {
        return Steve;
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
        int picsize = 63 ;
        Graphics2D gr = (Graphics2D)g;
        for(int idx=cells.size()-1; idx>=0;idx--)
        {
            for (int jdx=0; jdx<cells.size(); jdx++)
            {
                Cell cell = cells.get(idx).get(jdx);
                Image img = null;
                try
                {
                if(board.getPlayer().getcoordY() == idx && board.getPlayer().getcoordX() == jdx )
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
                /*cell = cells.get(0).get(1);
                try
                {
                img = cell.selectImage();
                }
                catch(IOException e)
                {
                    System.out.println("Error loading file");
                }
                gr.drawImage(img,board.getFrame().getWidth()-100,board.getFrame().getWidth()-125,50,50,null);
                cell = cells.get(1).get(0);
                try
                {
                img = cell.selectImage();
                }
                catch(IOException e)
                {
                    System.out.println("Error loading file");
                }
                gr.drawImage(img,0,0,50,50,null);
                cell = cells.get(1).get(1);
                try
                {
                img = cell.selectImage();
                }
                catch(IOException e)
                {
                    System.out.println("Error loading file");
                }
                gr.drawImage(img,board.getFrame().getWidth()-125,0,50,50,null);
                */
            
            }
        }
    }
    
}
