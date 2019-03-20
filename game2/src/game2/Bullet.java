
package game2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Bullet {
    public double x,y,dx=0,dy=-10,rad,speed;
    public double w=15,h=35;
    private int r;
    public BufferedImage img;
    public Bullet(double x,double y,double dx,double dy) throws IOException
    {
        this.img = ImageIO.read(new File("image/đạn.png"));
        this.x=x;
        this.y=y;
        this.dx=dx;
        this.dy=dy;
    }
   public void update()
    {
       y+=dy;
       x+=dx;
    }
    public void draw(Graphics g)
    {
        g.setColor(Color.white);
         g.drawImage(img,(int)x,(int)y,(int)w,(int)h,null);
        //g.fillOval((int)x,(int)y,10,10);
    }
    public  double getY()
    {
        return y;
    }
    public double getX()
    {
        return x;
    }
    public  double getW()
    {
        return w;
    }
    public double getH()
    {
        return h;
    }
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
    Rectangle2D getBounds(int i, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
  
}
