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
import java.util.Random;
import javax.imageio.ImageIO;

/**
 *
 * @author MyPC
 */
public class Gif {
    private int x=0,y=0,w=0,h=0,s;
    public BufferedImage img;
    //public static String s="";
   
    public  Gif(int x,int y,int w,int h,int s) throws IOException
    {
        this.s=s;
        this.img = ImageIO.read(new File("image/gif"+s+".png"));
        this.x=x;
        this.y=y;
        this.w=w;
        this.h=h;
    }
    
    public void paint(Graphics g)
    {
        g.setColor(Color.RED);
        g.drawImage(img, x, y,w,h,null);
//g.fillOval(x, y, w, h);
    }
    public void move()
    {
        y++;
    }
    public int getX()
    {return  x;}
    public int getY()
    {return y;}
    public int getS()
    {return s;}
}
