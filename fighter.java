/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Point;

/**
 *
 * @author mohamed
 */
public class fighter {
     public Point pos=new Point();
    public String ImagePath;
    public Bullet Rocket;
    public int speed;
    public fighter (String ImagePath,String rocketpath,int rocketspeed)
    {
        Rocket=new Bullet(rocketpath,rocketspeed);
        speed=5;
        this.ImagePath=ImagePath;
        
    }

    void mover() {
        this.pos.y+=speed;
    }
      void movel() {
        this.pos.y-=speed;
    }

    public void fireBullet() {
        Rocket.pos.x=this.pos.x;
        Rocket.pos.y=this.pos.y+115;
        Thread t1=new Thread (Rocket);
        t1.start();
    }
}
