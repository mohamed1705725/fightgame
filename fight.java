/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author mohamed
 */
public class fight extends JPanel implements Runnable {

    public fighter fighter1 = new fighter("D:\\Marine.png", "D:\\rocket.gif", 15);
    public fighter fighter2 = new fighter("D:\\SiegeTank.jpg", "D:\\rocket2.gif", -15);
    JLabel l1, l2;
    int score1, score2;

    public fight() {
        setSize(600, 600);

        fighter1.pos.x = 10;
        fighter1.pos.y = 200;
        fighter2.pos.x = 1000;
        fighter2.pos.y = 200;
        score1 = 0;
        score2 = 0;
        

        /*  l2.setBounds(1000, 5, 100, 150);
        l1.setBounds(5, 5, 20, 150);
        this.add(l1);
        this.add(l2);*/
        this.addKeyListener(new keylist());

    }

    private class keylist implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {

            if (e.getKeyCode() == KeyEvent.VK_UP) {

                fighter1.movel();

            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {

                fighter1.mover();
                //repaint();
            }
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {

                fighter1.fireBullet();
            }

            if (e.getKeyCode() == KeyEvent.VK_W) {

                fighter2.mover();

            }
            if (e.getKeyCode() == KeyEvent.VK_S) {

                fighter2.movel();
                //repaint();
            }
            if (e.getKeyCode() == KeyEvent.VK_D) {

                fighter2.fireBullet();
            }

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

    public void paintComponent(Graphics g) {
        g.clearRect(0, 0, 1300, 700);
setLayout(null);
        l1 = new JLabel("your score :"+score1);
        l2 = new JLabel("your score :"+score2);
        l2.setBounds(1000, 5, 100, 150);
        l1.setBounds(5, 5, 100, 150);
        add(l2);
        add(l1);
        try {
            BufferedImage imgtank = ImageIO.read(new File(fighter1.ImagePath));
            BufferedImage imgrocket = ImageIO.read(new File(fighter1.Rocket.imgPath));
            g.drawImage(imgtank, fighter1.pos.x, fighter1.pos.y, null);
            g.drawImage(imgrocket, fighter1.Rocket.pos.x, fighter1.Rocket.pos.y, null);
            BufferedImage imgtank2 = ImageIO.read(new File(fighter2.ImagePath));
            BufferedImage imgrocket2 = ImageIO.read(new File(fighter2.Rocket.imgPath));
            g.drawImage(imgtank, fighter2.pos.x, fighter2.pos.y, null);
            g.drawImage(imgrocket, fighter2.Rocket.pos.x, fighter2.Rocket.pos.y, null);

        } catch (IOException e) {
            System.out.println(e);
        }

        if (fighter1.Rocket.pos.distance(fighter2.pos) <= 50) {
            System.out.println("Hit Occurs for 1");
            score1++;
            
            

        }
        if (fighter2.Rocket.pos.distance(fighter1.pos) <= 50) {
            System.out.println("Hit Occurs for 2");
            score2++;
            
           

        }

    }

    @Override
    public void run() {
        try {
            while (true) {

                Thread.sleep(50);
                repaint();
                if(score1>5){
                    JOptionPane.showMessageDialog(this, "player one is the winner");
                    
                    break;
                }
                if(score2>5){
                    JOptionPane.showMessageDialog(this, "player two is the winner");
                    break;
                }
            }
        } catch (InterruptedException e) {
        }
    }

}
