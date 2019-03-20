/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game2;

import static game2.flies.s;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;

/**
 *
 * @author MyPC
 */
public class Coin {
    public int x,y,w,h;
    public int dx=0,dy=10,dx1,dy1=5;
    public static int m=0,d2=5,d3=2,d4=1,d5=0;
    public BufferedImage img;
    static String s="1";
    Random rand=new Random();
    public Coin(int x,int y,int w,int h) throws IOException
    {
        this.img = ImageIO.read(new File("image/Coin1.png"));
        this.x=x;
        this.y=y;
        this.w=w;
        this.h=h;
        
    }
    public void paint(Graphics g)
    {
        g.drawImage(img, x, y,w,h,null);
        
    }
    public void move()
    {
        
        
        x+=dx;
        y+=dy;
        
        if(x<0)
            dx=-dx;
        if(x>800-w)
            dx=-dx;
        if(y<0)
            dy=-dy;
        if(y>600-h){
           
            dy=-dy1;
      
            //d2=dy1-1;
        }
        
        
    }
    
}
