/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game2;

import java.awt.Graphics;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;
import java.util.Vector;

/**
 *
 * @author MyPC
 */
public class controller{
     LinkedList<Bullet> b=new LinkedList<>();
     Bullet bullet;
    LinkedList<flies> f=new LinkedList<>();
    flies flie;
    LinkedList<Gif> G=new LinkedList<>();
    Gif gif;
    LinkedList<Background> B=new LinkedList<>();
    Background background;
    LinkedList<Explosive> E=new LinkedList<>();
    Explosive explosive;
    LinkedList<Explosive2> E2=new LinkedList<>();
    Explosive2 explosive2;
    LinkedList<Coin> C=new LinkedList<>();
    Coin coin;
    
    private BulletFlies bf;
    LinkedList<BulletFlies> bl=new LinkedList<>();
    private Gameplay2_ game;
    private int timeloop=0;
    private long deathInitTime = -1L;
    private long time=5000L;
    static  int TG;
    public int tilaze=0;
    public static int timerand=500,timeloop2=500;
    public static int KtMove=0;
    Random rand=new Random();
    public controller()
    {
        
    }
    public void tick()
    {
       
       
        for(int i=0;i<b.size();i++){
            
            bullet=b.get(i);
             
            if(bullet.getY()<0)
                removeBullet(bullet);
            bullet.update();
           
        }
    }
    public void drawbackground(Graphics g)
    {
        for(int i=0;i<B.size();i++)
        {
            background=B.get(i);
            background.paint(g);
        }
    }
    public void draw(Graphics g) throws IOException
    {
        
       for(int i=0;i<b.size();i++){
            bullet=b.get(i);
            bullet.draw(g);
            
             
       }
       //list bullet
       for(int i=0;i<f.size();i++)
       {
           flie=f.get(i);
           flie.paint(g);
           
          if(flie.flat==1){
              if (deathInitTime < 0) {
            // if dead but just now dead, initialize deathInitTime
                deathInitTime = System.currentTimeMillis();
              } else {
                // he's been dead
                // check how long he's been dead
                long deathTime = System.currentTimeMillis() - deathInitTime;
                if (deathTime > 1000L) 
                if(timeloop<0){
                bl.add(new BulletFlies((int)flie.getX(), (int)flie.getY(),30,40,Gameplay2_.x,Gameplay2_.y));
//                game.ToaDoX(bf.getDx1());
//                game.ToaDoY(bf.getDy1());
                //flie.addbulletflies(new BulletFlies((int)flie.getX(), (int)flie.getY()));
                timeloop=rand.nextInt(timerand)+timeloop2;}
                else if(tilaze==1)
                        if(deathTime >time)
                         {
                          TG=1;
                          flie.addbulletflies(new BulletFlies((int)flie.getX(), (int)flie.getY(),30,40,Gameplay2_.x,Gameplay2_.y));
                          if(deathTime-time>3000L) 
                          time+=6000L;
                         }
                timeloop--; 
            }
              
         }
       }
       
       for(int i=0;i<bl.size();i++)
       {
           bf=bl.get(i);
           bf.paint(g);
           
       }
       for(int i=0;i<G.size();i++){
            gif=G.get(i);
            gif.paint(g);
       }
       
       for(int i=0;i<E.size();i++)
       {
           explosive=E.get(i);
           explosive.paint(g);
       }
       for(int i=0;i<E2.size();i++)
       {
           explosive2=E2.get(i);
           explosive2.paint(g);
       }
       for(int i=0;i<C.size();i++)
       {
           coin=C.get(i);
           coin.paint(g);
       }
    }
   
    public void addBulletFlies(BulletFlies block)
    {
        bl.add(block);
    }
    public void removeBulletFlies(BulletFlies block)
    {
        bl.remove(block);
    }
    public void addCoin(Coin block)
    {
        C.add(block);
    }
    public void removeCoin(Coin block)
    {
        C.remove();
    }
    public void addExplosive(Explosive block)
    {
        E.add(block);
    }
    public void removeExplosive(Explosive block)
    {
        E.remove(block);
    }
    public void addExplosive2(Explosive2 block)
    {
        E2.add(block);
    }
    public void removeExplosive2(Explosive2 block)
    {
        E2.remove(block);
    }
    public void addBackgroud(Background block)
    {
        B.add(block);
    }
    public void removeBackground(Background block)
    {
        B.remove(block);
    }
    public void addBullet(Bullet block)
    {
        b.add(block);
    }
    public  void removeBullet(Bullet block)
    {
        b.remove(block);
    }
     public void addflies(flies block)
    {
        f.add(block);
    }
    public  void removeflies(flies block)
    {
        f.remove(block);
       
    }
    
     public void addgif(Gif block)
    {
        G.add(block);
    }
    public  void removegif(Gif block)
    {
        G.remove(block);
        
    }
    public void move()
    {
        
        for(int i=0;i<f.size();i++)
       {
           flie=f.get(i);
           flie.move(0,i);
       }
        for(int i=0;i<G.size();i++){
            gif=G.get(i);
            gif.move();
       }
        for(int i=0;i<E2.size();i++)
       {
           explosive2=E2.get(i);
           explosive2.move();
       }
       for(int i=0;i<C.size();i++)
       {
           coin=C.get(i);
           coin.move();
       }
       for(int i=0;i<bl.size();i++)
       {
           bf=bl.get(i);
           //bf.move((double)toadox.get(i),(double)toadoy.get(i));
           //
           if(KtMove==0)
           bf.move2();
           else bf.move(bf.getDx1(), bf.getDy1());
           //sbf.move(-i, -10*i+i);
           
        }
    }
    public void movebackground() throws IOException
    {
        for(int i=0;i<B.size();i++)
        {
            background=B.get(i);
            background.move();
            
        }
    }
   
}
