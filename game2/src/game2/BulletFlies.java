/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class BulletFlies {
  private double x,y,w,h;
  static double dx,dy,dx1,dy1;
   public BufferedImage img;
   public static String s="";
     public BulletFlies(double x,double y,double w,double h,double dx,double dy) throws IOException
  {
      this.img = ImageIO.read(new File("image/"+s));
      this.x=x;
      this.y=y;
      this.w=w;
      this.h=h;
      this.dx=dx;
      this.dy=dy;
      this.dx1=(this.x-this.dx)/100;
      this.dy1=(this.y-this.dy)/100;
      
  }
    public void paint(Graphics g)
    {
        g.setColor(Color.yellow);
        g.drawImage(img,(int)x,(int)y,(int)w,(int)h,null);
        //g.fillOval(x, y, 20, 20);
    }
    public void move(double dx1,double dy1)
    {
       
        x-=dx1;
        
        y-=dy1;
        
    }
    public void move2()
    {
        y++;
    }
    public double getY()
    {
        return y;
    }
    public double getX()
    {
        return x;
    }
    public double getDx1()
    {
        return dx1;
    }
     public double getDy1()
    {
        return dy1;
    }
    public double getWidth()
    {
        return w;
    }
    public double getHeight()
    {
        return h;
    }
}
