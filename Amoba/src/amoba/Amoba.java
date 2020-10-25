/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amoba;

/**
 *
 * @author lkcsd
 */
public class Amoba {
    private Player playerX = new Player();
    private Player playerY = new Player();
    public static AmobaGUI window;
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        window = new AmobaGUI();
    }
    
}
