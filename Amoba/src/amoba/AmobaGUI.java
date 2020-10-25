/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amoba;

import java.awt.BorderLayout;
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
    private ArrayList<JButton> buttons;
    private JFrame frame;
    private JTextArea display;
    private JPanel mainPanel;
    private JPanel selectorPanel;
    private ArrayList<JButton> Buttons = new ArrayList<>();
    
    public AmobaGUI()
    {
        frame = new JFrame("Amoba");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel = new JPanel();
        selectorPanel= new JPanel();
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
            Buttons.add(quickButton);
        }
        for ( JButton tmp : Buttons)
        {
            selectorPanel.add(tmp);
        }
  
        display.setLineWrap(true);
        display.setEditable(false);
        mainPanel.add(display);
        frame.getContentPane().add(mainPanel, BorderLayout.NORTH);
        frame.getContentPane().add(selectorPanel,BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
        
        
    }
    
    class SizeSelectActionListener implements ActionListener 
    {
        private int size;
        
        @Override
        public void actionPerformed (ActionEvent e)
        {
           mainPanel.remove(display);
           frame.remove(selectorPanel);
           frame.remove(mainPanel);
           mainPanel.setLayout(new GridLayout(size,size));
           frame.setSize(1000,1000);
           Font defaultFontType = new Font(Buttons.get(0).getFont().getName(),Buttons.get(0).getFont().getStyle(),50);
           Buttons = new ArrayList<JButton>();
           for(int idx=0; idx<size*size; idx++)
           {
              JButton tmp=new JButton();
              tmp.setFont(defaultFontType);
              tmp.addActionListener(new XOActionListener(tmp));
             tmp.setSize(1000, 1000);
              mainPanel.add(tmp);
           }
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
        private JButton thisButton;
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(Player.isXTurn())
            thisButton.setLabel("X");
            else
            {
                thisButton.setLabel("O");
            }
        }
    
        public XOActionListener(JButton Button)
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

    public ArrayList<JButton> getButtons() {
        return Buttons;
    }
    
    
    
    
}
