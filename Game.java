/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author mohamed
 */
public class Game {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        JFrame f=new JFrame();
        f.setSize(1300, 700);
        fight game=new fight();
         
        f.add(game,BorderLayout.CENTER);
        game.setFocusable(true);
        Thread t1=new Thread(game);
        t1.start();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
    
}
