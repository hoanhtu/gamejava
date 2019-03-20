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
import javax.imageio.ImageIO;

/**
 *
 * @author MyPC
 */
public class Explosive {
    public BufferedImage img;
    public int x,y,w,h;
    public Explosive(){};
    public Explosive(int x,int y) throws IOException
    {
        this.img = ImageIO.read(new File("image/nổ2.png"));
        this.x=x;
        this.y=y;
    }
    public void paint(Graphics g)
    {
        g.drawImage(img,x,y,50,50,null);
    }
}
