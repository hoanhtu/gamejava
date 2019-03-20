/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game2;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author MyPC
 */
public class Background {
   public BufferedImage img;
   private double x=0,y=0,dx=0,dy=0;
   
   public Background(double x,double y,double dx,double dy) throws IOException
   {
       this.img = ImageIO.read(new File("image/vuTru.jpg"));
       this.x=x;
       this.y=y;
       this.dx=dx;
       this.dy=dy;
      
   }
    public void paint(Graphics g)
    {
        g.drawImage(img,(int)x,(int)y,800,700,null);
    }
    public void move()
    {
        y+=dy;
    }
    public double getX()
    {
        return x;
    }
    public double getY()
    {
        return y;
    }
}
