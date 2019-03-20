/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.List;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;
import javax.imageio.ImageIO;

/**
 *
 * @author MyPC
 */
public class flies {
    public double x=50,y=50,w=50,h=50,width=1500,height=800,width1=0,height1=0;
    static int ky=0;
    public int flat=1;
    private BulletFlies bulletFlies;
    Random rand=new Random();
    double dx;//rand.nextInt(5);
    double dy;//rand.nextInt(5);
    public BufferedImage img;
    LinkedList<BulletFlies> bf=new LinkedList<>();
    public static String s="";
    Gameplay2_ gameplay2_0;
    public int x1;
    public int y1;
    public flies(double x,double y,double w,double h,double dx,double dy,double width,double height,double width1,double height1) throws IOException
    {
        this.img = ImageIO.read(new File("image/"+s));
        this.x=x;
        this.y=y;
        this.w=w;
        this.h=h;
        this.dx=dx;
        this.dy=dy;
        this.width=width;
        this.height=height;
        this.width1=width1;
        this.height1=height1;
        //this.ky=ky;
        //bulletFlies=new BulletFlies(x, y);
    }
    public void paint(Graphics g)
    {
        //flat=1
        if(flat==1){
        g.setColor(Color.BLUE);
        g.drawImage(img,(int)x,(int)y,(int)w,(int)h,null);
 
        //g.fillRect((int)x,(int) y,(int) w,(int) h);
        //bulletFlies.paint(g);
        }
//        for(int i=0;i<bf.size();i++)
//          {
//           bulletFlies =bf.get(i);
//           bulletFlies.paint(g);
//          }
        
        
    }
   
    public void setpaint()
    {
        flat=0;
        x=810;
        y=610;
        w=0;
        h=0;
    }
    public double getX()
    {return  x;}
    public double getY()
    {return y;}
    public double getDx()
    {return  dx;}
    public double getDy()
    {return dy;}
    public void setX(double x)
    {
        this.x=x;
    }
    public void setY(double y)
    {
        this.y=y;
    }
    public void setW(double w)
    {
        this.w=w;
    }
    public void setH(double h)
    {
        this.h=h;
    }
     public double getW()
    {return  w;}
    public double getH()
    {return h;}
    public void move(int ky1,int k)
    {
        x+=dx;
        y+=dy+ky1;
        if(x>width-w)
        dx=-dx;
       
        if(x<width1)
            dx=-dx;
        //bulletFlies.move();
        if(y>height-h)
            dy=-dy;
        if(y<height1)
            dy=-dy;
//        for(int i=0;i<bf.size();i++)
//       {
//           x1=Gameplay2__.x;
//           y1=Gameplay2__.y;
//           bulletFlies=bf.get(i);
//           bulletFlies.move2();
//           //bulletFlies.move(x1,y1);
//       }
        
    }
  
    public void move2()
    {
         x+=dx;
        y+=dy;
        if(x>width-w)
        dx=-dx;
       
        if(x<width1)
            dx=-dx;
        //bulletFlies.move();
        if(y>height-h)
            dy=-dy;
        if(y<height1)
            dy=-dy;
       
    }
     public void addbulletflies(BulletFlies block)
    {
        bf.add(block);
    }
    public  void removebulletflies(BulletFlies block)
    {
        bf.remove(block);
    }
}
