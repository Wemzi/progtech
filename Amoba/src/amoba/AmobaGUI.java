/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amoba;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
/**
 *
 * @author lkcsd
 */
public class AmobaGUI {
    private final JFrame frame;
    private final JTextArea display;
    private final JPanel mainPanel;
    private  JPanel secondaryPanel;
    private final ArrayList<XOButton> Buttons = new ArrayList<>();
    private final Player playerX = new Player();
    private final Player playerO = new Player();
    
    public AmobaGUI()
    {
        frame = new JFrame("Amoba");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel = new JPanel();
        secondaryPanel= new JPanel();
        display = new JTextArea("Please select a field size", 25, 40);
        ArrayList<String> ButtonLabels = new ArrayList<>();
        ButtonLabels.add("6 x 6 ");
        ButtonLabels.add("10 x 10 ");
        ButtonLabels.add("14 x 14 ");
        for ( String tmp : ButtonLabels)
        {
            JButton quickButton = new JButton();
            quickButton.setLabel(tmp);
            quickButton.addActionListener(new SizeSelectActionListener(Integer.parseInt(tmp.split(" ")[0])));
            secondaryPanel.add(quickButton);
        }

  
        display.setLineWrap(true);
        display.setEditable(false);
        mainPanel.add(display);
        frame.getContentPane().add(mainPanel, BorderLayout.NORTH);
        frame.getContentPane().add(secondaryPanel,BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
        
        
    }
    
    class SizeSelectActionListener implements ActionListener 
    {
        private final int size;
        
        @Override
        public void actionPerformed (ActionEvent e)
        {
           mainPanel.remove(display);
           frame.remove(secondaryPanel);
           frame.remove(mainPanel);
           secondaryPanel=new JPanel();
           display.setText("");
           display.setSize(120, 20);
           secondaryPanel.add(display);
           secondaryPanel.setPreferredSize(new Dimension(50,20));
           mainPanel.setLayout(new GridLayout(size,size));
           frame.setSize(1000,1000);
           Font defaultFontType = new Font(new JButton().getFont().getName(),new JButton().getFont().getStyle(),45);
           for(int idx=0; idx<size; idx++)
           {
               for(int jdx=0; jdx<size; jdx++)
               {
                    XOButton tmp = new XOButton(idx, jdx);
                    tmp.setFont(defaultFontType);
                    tmp.addActionListener(new XOActionListener(tmp));
                    tmp.setSize(1000, 1000);
                    Buttons.add(tmp);
                    mainPanel.add(tmp);
               }
           }
           frame.getContentPane().add(secondaryPanel, BorderLayout.NORTH);
           frame.add(mainPanel);
           
        }
        
        public SizeSelectActionListener(int size)
                {
                    super();
                    this.size=size;
                }
    }
    
    class XOActionListener implements ActionListener
    {
        private XOButton thisButton;
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(thisButton.getLabel().equals(""))
            {
                if(Player.isXTurn())
                {
                    thisButton.setLabel("X");
                    playerX.addButton(thisButton);
                    display.setText("Its Player O's turn");
                    Amoba.determineWinner();
                    
                }
                else
                {
                    thisButton.setLabel("O");
                    playerO.addButton(thisButton);
                    display.setText("Its Player X's turn");
                    Amoba.determineWinner();
                }
            }
            else return;
        }
    
        public XOActionListener(XOButton Button)
        {
            super();
            thisButton=Button;
        }
    }

    public JFrame getFrame() {
        return frame;
    }

    public JTextArea getDisplay() {
        return display;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public ArrayList<XOButton> getButtons() {
        return Buttons;
    }

    public Player getPlayerX() {
        return playerX;
    }

    public Player getPlayerO() {
        return playerO;
    }
    
    
}
